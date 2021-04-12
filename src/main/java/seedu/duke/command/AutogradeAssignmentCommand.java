package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.exception.AnswerTooLongException;
import seedu.duke.exception.InvalidQuestionNumberException;
import seedu.duke.exception.MarkTooLargeException;
import seedu.duke.exception.MissingAnswerException;
import seedu.duke.exception.MissingMarksException;
import seedu.duke.storage.Storage;
import seedu.duke.data.student.Student;
import seedu.duke.data.assignment.Answer;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.assignment.McqAssignment;
import seedu.duke.data.assignment.ShortAnswerAssignment;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.FileFormatException;
import seedu.duke.exception.InvalidMcqOption;
import seedu.duke.exception.InvalidPercentageException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.exception.NotAutogradableException;
import seedu.duke.exception.NumbersMisalignException;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Command for autograding assignment.
 */
public class AutogradeAssignmentCommand extends Command {

    private String moduleCode;
    private String assignmentName;
    private static Logger logger = Logger.getLogger(ViewAnswersCommand.class.getName());

    /**
     * Constructor for autograding assignment.
     * @param moduleCode module code of module where an assignment has to be autograded
     * @param assignmentName name of assignment to be autograded
     * @throws ModuleNotSelectedException when a module has not been selected by the user
     */
    public AutogradeAssignmentCommand(String moduleCode, String assignmentName) throws ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }

        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName.trim();
    }

    /**
     * Execute function for autograde assignment command.
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModuleNotFoundException if module of assignment to be autograded is not found in data
     * @throws AssignmentNotFoundException if assignment to be autograded is not found in module
     * @throws DataFileNotFoundException if the autograding files are not found within the directory specified
     * @throws NumbersMisalignException if the numbers are misaligned
     * @throws NotAutogradableException if the assignment to be graded is a LongAnswerAssignment
     * @throws FileFormatException if the file format specified is wrong
     * @throws InvalidMcqOption if the Mcq option laoded from the answer script is invalid
     * @throws InvalidPercentageException if the percentage format is invalid
     * @throws InvalidQuestionNumberException if the question number is invalid
     * @throws MarkTooLargeException if the marks obtained by a student is larger than expected
     * @throws MissingAnswerException if an answer is missing from the answer script
     * @throws AnswerTooLongException if the answer provided is longer than the threshold set
     * @throws MissingMarksException if the marks of a student is missing
     */
    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException,
            AssignmentNotFoundException, DataFileNotFoundException, NumbersMisalignException,
            NotAutogradableException, FileFormatException, InvalidMcqOption, InvalidPercentageException,
            InvalidQuestionNumberException, MarkTooLargeException, MissingAnswerException, AnswerTooLongException,
            MissingMarksException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";
        Assignment assignment = module.findAssignment(assignmentName);
        if (assignment == null) {
            throw new AssignmentNotFoundException();
        }
        assert assignment != null : "assignment should not be null";
        Answer answer = storage.loadAnswer(assignmentName, moduleCode);
        assignment.setAnswers(answer);
        ArrayList<Student> students = module.getStudents();
        if (assignment instanceof McqAssignment) {
            McqAssignment mcqAssignment = (McqAssignment) assignment;
            mcqAssignment.autogradeAssignment(students, moduleCode, storage);
        } else if (assignment instanceof ShortAnswerAssignment) {
            ShortAnswerAssignment shortAnswerAssignment = (ShortAnswerAssignment) assignment;
            shortAnswerAssignment.autogradeAssignment(students, moduleCode, storage);
        } else {
            throw new NotAutogradableException();
        }
        ArrayList<Student> ungraded = assignment.getUngraded(students);
        ui.listAssignmentStudentGrades(assignment);
        ui.listUngradedStudents(ungraded);
    }
}

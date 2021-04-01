package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.Student;
import seedu.duke.assignment.Answer;
import seedu.duke.assignment.Assignment;
import seedu.duke.assignment.McqAssignment;
import seedu.duke.assignment.ShortAnswerAssignment;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.FileFormatException;
import seedu.duke.exception.InvalidMcqOption;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.NotAutogradableException;
import seedu.duke.exception.NumbersMisalignException;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AutogradeAssignmentCommand extends Command {

    private String moduleCode;
    private String assignmentName;
    private static Logger logger = Logger.getLogger(ViewAnswersCommand.class.getName());

    public AutogradeAssignmentCommand(String moduleCode, String assignmentName) {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
    }

    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException,
            AssignmentNotFoundException, DataFileNotFoundException, NumbersMisalignException,
            NotAutogradableException, FileFormatException, InvalidMcqOption {
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

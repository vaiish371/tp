package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.exception.AnswerTooLongException;
import seedu.duke.exception.InvalidQuestionNumberException;
import seedu.duke.storage.Storage;
import seedu.duke.data.student.Student;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.FileFormatException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.NumbersMisalignException;
import seedu.duke.exception.StudentNotFoundException;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ViewScriptCommand extends Command {

    private String moduleCode;
    private String assignmentName;
    private String studentName;
    private static Logger logger = Logger.getLogger(ViewScriptCommand.class.getName());

    /**
     * Constructor for ViewScriptCommand Class.
     *
     * @param moduleCode current module
     * @param assignmentName name of the assignment
     * @param studentName name of the student
     */
    public ViewScriptCommand(String moduleCode, String assignmentName, String studentName) {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName.trim();
        this.studentName = studentName.trim();
    }

    /**
     * Retrieves a student's script from the scripts directory and displays the student's answer on the console.
     *
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModuleNotFoundException module not found
     * @throws AssignmentNotFoundException assignment not found
     * @throws DataFileNotFoundException student script not found
     * @throws NumbersMisalignException question numbers do not match
     * @throws StudentNotFoundException student not found
     * @throws FileFormatException wrong format in student script
     * @throws InvalidQuestionNumberException question number not integer
     * @throws AnswerTooLongException answer more than 100 characters long
     */
    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException,
            AssignmentNotFoundException, DataFileNotFoundException, NumbersMisalignException, StudentNotFoundException,
            FileFormatException, InvalidQuestionNumberException, AnswerTooLongException {
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
        Student student = module.findStudent(studentName);
        if (student == null) {
            throw new StudentNotFoundException();
        }
        String studentNumber = student.getStudentNumber();
        ArrayList<String> script = storage.loadScript(assignmentName, moduleCode, studentNumber);
        ui.printScript(script, assignmentName, studentName, studentNumber);
    }
}

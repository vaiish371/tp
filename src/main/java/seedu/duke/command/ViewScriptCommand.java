package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.Student;
import seedu.duke.assignment.Assignment;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.NumbersMisalignException;
import seedu.duke.exception.StudentNotFoundException;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ViewScriptCommand extends Command{

    private String moduleCode;
    private String assignmentName;
    private String studentName;
    private static Logger logger = Logger.getLogger(ViewScriptCommand.class.getName());

    public ViewScriptCommand(String moduleCode, String assignmentName, String studentName) {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
        this.studentName = studentName;
    }

    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException,
            AssignmentNotFoundException, DataFileNotFoundException, NumbersMisalignException, StudentNotFoundException {
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

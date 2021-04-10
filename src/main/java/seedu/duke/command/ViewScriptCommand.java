package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.exception.*;
import seedu.duke.storage.Storage;
import seedu.duke.data.student.Student;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ViewScriptCommand extends Command {

    private String moduleCode;
    private String assignmentName;
    private String studentName;
    private static Logger logger = Logger.getLogger(ViewScriptCommand.class.getName());

    public ViewScriptCommand(String moduleCode, String assignmentName, String studentName)
            throws ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
        this.studentName = studentName;
    }

    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException,
            AssignmentNotFoundException, DataFileNotFoundException, NumbersMisalignException, StudentNotFoundException,
            FileFormatException {
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

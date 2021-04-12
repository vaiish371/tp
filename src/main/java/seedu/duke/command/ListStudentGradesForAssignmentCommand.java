package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.module.Module;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.ui.Ui;
import seedu.duke.exception.ModuleNotSelectedException;

public class ListStudentGradesForAssignmentCommand extends Command {
    public String moduleCode;
    public String assignmentName;

    /**
     * Constructor for ListStudentGradesForAssignmentCommand Class.
     *
     * @param moduleCode current module
     * @param assignmentName name of assignment
     * @throws ModuleNotSelectedException not working in any module
     */
    public ListStudentGradesForAssignmentCommand(String moduleCode, String assignmentName)
            throws ModuleNotSelectedException {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
    }

    /**
     * Lists the student grades for specified assignment.
     *
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModuleNotFoundException module not found
     */
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        Assignment assignmentToBeQueried = module.findAssignment(assignmentName);
        if (assignmentToBeQueried == null) {
            ui.assignmentNotFoundMessage(assignmentName, moduleCode);
        } else {
            ui.listAssignmentStudentGrades(assignmentToBeQueried);
        }
    }
}

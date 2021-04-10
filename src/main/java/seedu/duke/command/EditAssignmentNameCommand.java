package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.ui.Ui;

public class EditAssignmentNameCommand extends Command {
    private final String moduleCode;
    private final String oldName;
    private final String newName;

    public EditAssignmentNameCommand(String moduleCode, String oldName, String newName) {
        this.moduleCode = moduleCode;
        this.oldName = oldName;
        this.newName = newName;
    }

    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException,
            AssignmentNotFoundException, ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        Assignment assignmentToBeEdited = null;
        for (Assignment assignment : module.getAssignments()) {
            if (assignment.getName().equals(oldName)) {
                assignmentToBeEdited = assignment;
            }
        }
        if (assignmentToBeEdited == null) {
            throw new AssignmentNotFoundException();
        }

        assignmentToBeEdited.setName(newName);
        ui.printEditAssignmentName(module, oldName, newName);
    }
}

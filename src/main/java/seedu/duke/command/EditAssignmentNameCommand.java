package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.exception.EmptyParameterException;
import seedu.duke.exception.AssignmentNameExistsException;
import seedu.duke.exception.SameNameEditException;
import seedu.duke.ui.Ui;

public class EditAssignmentNameCommand extends Command {
    private final String moduleCode;
    private final String oldName;
    private final String newName;

    public EditAssignmentNameCommand(String moduleCode, String oldName, String newName)
            throws EmptyParameterException, SameNameEditException {
        this.moduleCode = moduleCode;
        this.oldName = oldName.trim();
        this.newName = newName.trim();
        if (newName.length() == 0) {
            throw new EmptyParameterException();
        }
        if (this.oldName.equals(this.newName)) {
            throw new SameNameEditException();
        }
    }

    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException,
            AssignmentNotFoundException, ModuleNotSelectedException, AssignmentNameExistsException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        Assignment assignmentToBeEdited = null;
        for (Assignment assignment : module.getAssignments()) {
            if (assignment.getName().equals(newName)) {
                throw new AssignmentNameExistsException();
            }
        }
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

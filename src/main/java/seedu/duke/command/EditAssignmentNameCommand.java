package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.exception.LessonNotFoundException;
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

    /**
     * Constructor for EditAssignmentNameCommand Class.
     *
     * @param moduleCode current module.
     * @param oldName String specifying current name of the assignment.
     * @param newName String specifying new name of the assignment.
     * @throws EmptyParameterException Thrown when newName is an empty String.
     * @throws SameNameEditException Thrown when newName is identical to oldName.
     */
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

    /**
     * Edits the name of an assignment from oldName to newName.
     * Prints output confirming change to user.
     *
     * @param data keeps track of module information.
     * @param ui prints messages to the console.
     * @param storage saves and retrieves information from database.
     * @throws ModuleNotFoundException Thrown when module is not found.
     * @throws AssignmentNotFoundException Thrown when assignment is not found.
     * @throws ModuleNotSelectedException Thrown when user is not currently working in any module.
     * @throws AssignmentNameExistsException Thrown when an assignment with the same name as newName already exists.
     */
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

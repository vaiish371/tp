package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.ui.Ui;


public class ListModuleAssignmentsCommand extends Command {

    private String moduleCode;

    /**
     * Constructor for ListModuleAssignmentsCommand Class.
     *
     * @param moduleCode current module.
     * @throws ModuleNotSelectedException Thrown when user is not currently working in any module.
     */
    public ListModuleAssignmentsCommand(String moduleCode) throws ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.moduleCode = moduleCode;
    }

    /**
     * Prints out list of assignments for the specified module.
     *
     * @param data keeps track of module information.
     * @param ui prints messages to the console.
     * @param storage saves and retrieves information from database.
     * @throws ModuleNotFoundException Thrown when module is not found.
     */
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";
        ui.listModuleAssignments(module);
    }
}

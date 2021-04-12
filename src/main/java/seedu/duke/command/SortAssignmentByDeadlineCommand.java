package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.ui.Ui;

public class SortAssignmentByDeadlineCommand extends Command {
    private String moduleCode;

    /**
     * Constructor for SortAssignmentByDeadlineCommand.
     *
     * @param moduleCode current module
     * @throws ModuleNotSelectedException not working in any module
     */
    public SortAssignmentByDeadlineCommand(String moduleCode) throws ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.moduleCode = moduleCode;

    }

    /**
     * Sorts all assignments in module by deadline from most to least urgent.
     *
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModuleNotFoundException module not found
     */
    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";
        module.sortAssignments();
        ui.listModuleAssignments(module);
    }
}

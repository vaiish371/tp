package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.exception.EmptyModuleException;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.DuplicateModuleException;
import seedu.duke.ui.Ui;

/**
 * Class for adding a module into the database.
 */
public class AddModuleCommand extends Command {
    public String moduleCode;

    /**
     * Constructor for AddModuleCommand.
     * @param moduleCode module code of the module to be appended into the database
     * @throws EmptyModuleException if the module code is empty
     */
    public AddModuleCommand(String moduleCode) throws EmptyModuleException {
        this.moduleCode = moduleCode.trim();
        if (moduleCode.length() == 0) {
            throw new EmptyModuleException();
        }
    }

    /**
     * Execute function for the command.
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws DuplicateModuleException if the module code of the module to be added already exists
     */
    public void execute(Data data, Ui ui, Storage storage) throws DuplicateModuleException {
        if (data.find(moduleCode) != null) {
            throw new DuplicateModuleException();
        }
        Module module = new Module(moduleCode);
        data.add(module);
        ui.printNewModule(module);
    }
}

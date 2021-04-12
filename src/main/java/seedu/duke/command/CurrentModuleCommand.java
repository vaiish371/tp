package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

/**
 * Command for showing the current module the user is in.
 */
public class CurrentModuleCommand extends Command {
    public String moduleCode;

    /**
     * Sets the module code as the current module that the user is in.
     */
    public CurrentModuleCommand() {
        moduleCode = Parser.getCurrentModule();
    }

    /**
     * Execute function to be run by the command. It prints out the user's current module for the user.
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModuleNotFoundException if the module to be printed out for the user is not found in the data.
     * @throws ModuleNotSelectedException if the user has not selected any modules yet.
     */
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException, ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        } else {
            Module currentModule = data.find(moduleCode);
            if (currentModule == null) {
                throw new ModuleNotFoundException();
            }
            assert currentModule != null : "module not found";
            ui.printModuleInfo(currentModule);
        }
    }
}

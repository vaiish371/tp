package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

public class RemoveModuleCommand extends Command {
    public String moduleCode;

    /**
     * Constructor for RemoveModuleCommand Class.
     *
     * @param moduleCode current module
     */
    public RemoveModuleCommand(String moduleCode) {
        this.moduleCode = moduleCode.trim();
        assert this.moduleCode != null : "Module code cannot be null";
    }

    /**
     * Removes the specified module from ModMan.
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
        } else {
            String currentModuleCode = Parser.getCurrentModule();
            if (currentModuleCode == null) {
                // Avoiding NullPointerException
            } else if (currentModuleCode.equals(moduleCode)) {
                Parser.setCurrentModule(null);
            }
            data.remove(moduleCode);
            ui.removeModuleMessage(moduleCode);
        }
    }
}

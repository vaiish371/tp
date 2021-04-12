package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;


public class SelectModuleCommand extends Command {
    public String moduleCode;

    /**
     * Constructor for SelectModuleCommand Class.
     *
     * @param moduleCode current module
     */
    public SelectModuleCommand(String moduleCode) {
        this.moduleCode = moduleCode.trim();
        assert this.moduleCode != null : "Module code cannot be null";
    }

    /**
     * Selects the specified module to be the current working module.
     *
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModuleNotFoundException module not found
     */
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException {
        if (data.find(moduleCode) == null) {
            throw new ModuleNotFoundException();
        } else {
            Parser.setCurrentModule(moduleCode);
            ui.selectModuleMessage(moduleCode);
        }
    }
}
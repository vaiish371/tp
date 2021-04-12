package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.ui.Ui;

public class ListModuleTimetableCommand extends Command {

    private String moduleCode;

    /**
     * Constructor for ListModuleTimetableCommand Class.
     *
     * @param moduleCode current module
     * @throws ModuleNotSelectedException not working in any module
     */
    public ListModuleTimetableCommand(String moduleCode) throws ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.moduleCode = moduleCode;
    }

    /**
     * Lists the lessons stored in module.
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
        } else {
            ui.listModuleTimetable(module);
        }
    }

}

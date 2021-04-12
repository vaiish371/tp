package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class ListModuleCommand extends Command {

    public ListModuleCommand() {
    }

    /**
     * Lists the modules stored.
     *
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     */
    public void execute(Data data, Ui ui, Storage storage) {
        String currentModuleCode = Parser.getCurrentModule();
        ArrayList<Module> modules = data.getModules();
        if (currentModuleCode == null) {
            ui.printModules(modules);
        } else {
            ui.printModules(modules, currentModuleCode);
        }
    }
}
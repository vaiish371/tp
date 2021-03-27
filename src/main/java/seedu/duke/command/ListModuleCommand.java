package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class ListModuleCommand extends Command {

    public ListModuleCommand() {
    }

    public void execute(Data data, Ui ui, Storage storage) {
        ArrayList<Module> modules = data.getModules();
        ui.printModules(modules);
    }
}
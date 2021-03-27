package seedu.duke.command;


import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

public class AddModuleCommand extends Command {
    public String moduleCode;

    public AddModuleCommand(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void execute(Data data, Ui ui, Storage storage) {
        Module module = new Module(moduleCode);
        data.add(module);
        ui.printNewModule(module);
    }
}

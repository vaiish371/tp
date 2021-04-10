package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.DuplicateModuleException;
import seedu.duke.ui.Ui;

public class AddModuleCommand extends Command {
    public String moduleCode;

    public AddModuleCommand(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void execute(Data data, Ui ui, Storage storage) throws DuplicateModuleException {
        if (data.find(moduleCode) != null) {
            throw new DuplicateModuleException();
        }
        Module module = new Module(moduleCode);
        data.add(module);
        ui.printNewModule(module);
    }
}

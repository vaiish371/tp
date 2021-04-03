package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.ui.Ui;

public class ListStudentsDetailsCommand extends Command {
    public String moduleCode;

    public ListStudentsDetailsCommand(String moduleCode) throws ModuleNotFoundException {
        if (moduleCode == null) {
            throw new ModuleNotFoundException();
        }
        this.moduleCode = moduleCode;
    }

    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        ui.listModuleStudentsDetails(module);
    }
}

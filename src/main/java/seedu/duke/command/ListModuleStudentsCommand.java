package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.ui.Ui;

public class ListModuleStudentsCommand extends Command {

    public String moduleCode;

    public ListModuleStudentsCommand(String moduleCode) {
        this.moduleCode = moduleCode;
        assert this.moduleCode != null : "Module code cannot be null";
    }

    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        ui.listModuleStudents(module);
    }
}

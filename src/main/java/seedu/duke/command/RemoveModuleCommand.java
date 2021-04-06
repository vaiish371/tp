package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

public class RemoveModuleCommand extends Command {
    public String moduleCode;

    public RemoveModuleCommand(String moduleCode) {
        this.moduleCode = moduleCode;
        assert this.moduleCode != null : "Module code cannot be null";
    }

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

package seedu.duke.command;

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

    public void execute(Data data, Ui ui) throws ModuleNotFoundException {
        if (data.find(moduleCode) == null) {
            throw new ModuleNotFoundException();
        } else {
            if (Parser.getCurrentModule().equals(moduleCode)) {
                Parser.setCurrentModule(null);
            }
            data.remove(moduleCode);
            ui.removeModuleMessage(moduleCode);
        }
    }
}

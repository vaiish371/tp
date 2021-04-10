package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

public class CurrentModuleCommand extends Command {
    public String moduleCode;
    
    public CurrentModuleCommand() {
        moduleCode = Parser.getCurrentModule();
    }

    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException, ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        } else {
            Module currentModule = data.find(moduleCode);
            if (currentModule == null) {
                throw new ModuleNotFoundException();
            }
            assert currentModule != null : "module not found";
            ui.printModuleInfo(currentModule);
        }
    }
}

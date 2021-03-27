package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

public class CurrentModuleCommand extends Command {
    public String moduleCode;
    
    public CurrentModuleCommand() {
        moduleCode = Parser.getCurrentModule();
    }

    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException {
        if (moduleCode == null) {
            System.out.println("\t You are not currently working in any module!");
            System.out.println("\t Please select a module by using the select command");
            assert moduleCode != null : "module code should not be null";
        } else {
            Module currentModule = data.find(moduleCode);
            if(currentModule == null) {
                throw new ModuleNotFoundException();
            }
            assert currentModule != null : "module not found";
            ui.printModuleInfo(currentModule);
        }
    }
}

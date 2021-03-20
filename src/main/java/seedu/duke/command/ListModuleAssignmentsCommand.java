package seedu.duke.command;

import seedu.duke.Assignment;
import seedu.duke.Module;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class ListModuleAssignmentsCommand extends Command {

    public String moduleCode;

    public ListModuleAssignmentsCommand(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void execute(Data data, Ui ui) throws ModuleNotFoundException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";
        ui.listModuleAssignments(module);
    }
}

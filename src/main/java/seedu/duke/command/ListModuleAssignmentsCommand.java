package seedu.duke.command;

import seedu.duke.Assignment;
import seedu.duke.Module;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class ListModuleAssignmentsCommand extends Command {

    public String moduleCode;

    public ListModuleAssignmentsCommand(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void execute(Data data, Ui ui) {
        Module module = data.find(moduleCode);
        ui.listModuleAssignments(module);
    }
}

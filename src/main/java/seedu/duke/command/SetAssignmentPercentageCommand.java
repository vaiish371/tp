package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.assignment.Assignment;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.ModManException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.InvalidPercentageException;
import seedu.duke.ui.Ui;

public class SetAssignmentPercentageCommand extends Command {
    private String moduleCode;
    private String assignmentName;
    private float percentage;

    public SetAssignmentPercentageCommand(String moduleCode, String assignmentName, String percentage)
            throws NumberFormatException, InvalidPercentageException {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
        this.percentage = Float.parseFloat(percentage);
        if (this.percentage < 0.0 || this.percentage > 100.0) {
            throw new InvalidPercentageException();
        }
    }

    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModManException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";
        Assignment assignment = module.findAssignment(assignmentName);
        if (assignment == null) {
            throw new AssignmentNotFoundException();
        }
        assert assignment != null : "assignment should not be null";
        assignment.setPercentage(this.percentage);
        ui.printSetAssignmentPercentage(moduleCode, assignmentName, this.percentage);
    }
}

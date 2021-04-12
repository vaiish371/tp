package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.ModManException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.exception.InvalidPercentageException;
import seedu.duke.ui.Ui;

public class SetAssignmentPercentageCommand extends Command {
    private static final float PERCENTAGE_MIN = (float)0.0;
    private static final float PERCENTAGE_MAX = (float)100.0;
    private String moduleCode;
    private String assignmentName;
    private float percentage;

    /**
     * Constructor for SetAssignmentPercentageCommand Class.
     *
     * @param moduleCode current module
     * @param assignmentName name of assignment
     * @param percentage percentage of overall grade
     * @throws NumberFormatException invalid number
     * @throws InvalidPercentageException invalid percentage
     * @throws ModuleNotSelectedException not working in any module
     */
    public SetAssignmentPercentageCommand(String moduleCode, String assignmentName, String percentage)
            throws NumberFormatException, InvalidPercentageException, ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName.trim();
        this.percentage = Float.parseFloat(percentage.trim());
        if (this.percentage < PERCENTAGE_MIN || this.percentage > PERCENTAGE_MAX) {
            throw new InvalidPercentageException();
        }
    }

    /**
     * Sets the percentage of overall grade the assignment contributes to.
     *
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModManException general exception
     */
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

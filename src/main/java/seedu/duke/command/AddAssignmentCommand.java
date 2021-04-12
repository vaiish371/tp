package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.storage.Storage;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.assignment.LongAnswerAssignment;
import seedu.duke.data.assignment.McqAssignment;
import seedu.duke.data.assignment.ShortAnswerAssignment;
import seedu.duke.data.Data;
import seedu.duke.exception.InvalidAssignmentException;
import seedu.duke.exception.DuplicateAssignmentException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.exception.EmptyParameterException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Command used for adding an assignment onto a particular module stored within our data.
 */
public class AddAssignmentCommand extends Command {
    public String moduleCode;
    public String assignmentName;
    public String assignmentType;
    private static final Logger logger = Logger.getLogger(Parser.class.getName());

    /**
     * Constructor for AddAssignmentCommand.
     * @param assignmentType type of assignment
     * @param moduleCode module code of the module that the assignment belongs to
     * @param assignmentName name of the assignment
     * @throws ModuleNotSelectedException if the user has not selected any modules yet.
     * @throws EmptyParameterException if any of the parameters remain empty (null or 0) upon construction
     */
    public AddAssignmentCommand(String assignmentType, String moduleCode, String assignmentName)
            throws ModuleNotSelectedException, EmptyParameterException {
        this.assignmentType = assignmentType.trim();
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName.trim();
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        if (assignmentName.length() == 0) {
            throw new EmptyParameterException();
        }
        if (assignmentType.length() == 0) {
            throw new EmptyParameterException();
        }
        assert this.assignmentName != null : "assignment name cannot be null";
    }

    /**
     * Execute function to be run.
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModuleNotFoundException if the module does not exist in the user's data yet
     * @throws InvalidAssignmentException if the user did not input la, sa or mcq for the assignment type
     * @throws DuplicateAssignmentException if the assignment name already exists for that particular module
     */
    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException,
            InvalidAssignmentException, DuplicateAssignmentException {
        Module module = data.find(moduleCode);
        Assignment assignment = null;
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        if (assignmentType.equals("la")) {
            assignment = new LongAnswerAssignment(assignmentName);
        } else if (assignmentType.equals("sa")) {
            assignment = new ShortAnswerAssignment(assignmentName);
        } else if (assignmentType.equals("mcq")) {
            assignment = new McqAssignment(assignmentName);
        } else {
            logger.log(Level.WARNING, "assignment type must be either la, sa or mcq");
            throw new InvalidAssignmentException();
        }

        for (int i = 0; i < module.getAssignments().size(); i++) {
            Assignment currentAssignment = module.getAssignments().get(i);
            if (currentAssignment.getName().equals(assignmentName)) {
                throw new DuplicateAssignmentException();
            }
        }
        module.addAssignment(assignment);
        ui.printNewAssignment(module, assignment);
    }
}

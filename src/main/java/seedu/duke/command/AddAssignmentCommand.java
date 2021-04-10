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
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AddAssignmentCommand extends Command {
    public String moduleCode;
    public String assignmentName;
    public String assignmentType;
    private static final Logger logger = Logger.getLogger(Parser.class.getName());

    public AddAssignmentCommand(String assignmentType, String moduleCode, String assignmentName)
            throws ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.assignmentType = assignmentType;
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
        assert this.assignmentName != null : "assignment name cannot be null";
    }

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

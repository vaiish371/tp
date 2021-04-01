package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.assignment.Assignment;
import seedu.duke.assignment.LongAnswerAssignment;
import seedu.duke.assignment.McqAssignment;
import seedu.duke.assignment.ShortAnswerAssignment;
import seedu.duke.data.Data;
import seedu.duke.exception.DuplicateAssignmentException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.ui.Ui;

public class AddAssignmentCommand extends Command {
    public String moduleCode;
    public String assignmentName;
    public String assignmentType;

    public AddAssignmentCommand(String assignmentType, String moduleCode, String assignmentName) {
        this.assignmentType = assignmentType;
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
    }

    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException,
            DuplicateAssignmentException {
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
        }
        assert module != null : "module should not be null";
        assert assignment != null : "module should not be null";
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

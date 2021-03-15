package seedu.duke.command;

import seedu.duke.AssignmentMCQ;
import seedu.duke.Module;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

public class AddAssignmentMCQCommand extends Command {
    public String moduleCode;
    public String assignmentName;
    public int numberOfQuestions;

    public AddAssignmentMCQCommand(String moduleCode, String assignmentName, String numberOfQuestions) {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
        this.numberOfQuestions = Integer.parseInt(numberOfQuestions);
    }

    public void execute(Data data, Ui ui) {
        Module module = data.find(moduleCode);
        AssignmentMCQ assignment = new AssignmentMCQ(assignmentName, numberOfQuestions);
        module.addAssignment(assignment);
        ui.printNewAssignmentMCQ(module, assignment);
    }
}

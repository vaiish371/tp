package seedu.duke.command;

import seedu.duke.Assignment;
import seedu.duke.Module;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class SetAssignmentDeadlineCommand extends Command {
    private String moduleCode;
    private String assignmentName;
    private LocalDate deadline;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    private static Logger logger = Logger.getLogger(SetAssignmentDeadlineCommand.class.getName());

    public SetAssignmentDeadlineCommand(String moduleCode, String assignmentName, String deadline) {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
        this.deadline = LocalDate.parse(deadline, formatter);
    }

    @Override
    public void execute(Data data, Ui ui) {
        assert deadline != null : "deadline must not be null";
        Module module = data.find(moduleCode);
        Assignment assignment = module.findAssignment(assignmentName);
        assignment.setDeadline(deadline);
        ui.printSetAssignmentDeadline(moduleCode, assignmentName, deadline);
    }
}

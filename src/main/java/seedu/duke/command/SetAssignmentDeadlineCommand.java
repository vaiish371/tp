package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.module.Module;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.DateTimeFormatException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import seedu.duke.exception.ModuleNotSelectedException;
import java.util.logging.Logger;

public class SetAssignmentDeadlineCommand extends Command {
    private String moduleCode;
    private String assignmentName;
    private LocalDate deadline;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    private static Logger logger = Logger.getLogger(SetAssignmentDeadlineCommand.class.getName());

    public SetAssignmentDeadlineCommand(String moduleCode, String assignmentName, String deadline)
            throws ModuleNotSelectedException, DateTimeParseException, DateTimeFormatException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
        this.deadline = LocalDate.parse(deadline, formatter);
        int year = this.deadline.getYear();
        if (year < 2021 || year > 2030) {
            throw new DateTimeFormatException();
        }

    }

    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException,
            AssignmentNotFoundException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";
        Assignment assignment = module.findAssignment(assignmentName);
        if (assignment == null) {
            throw new AssignmentNotFoundException();
        }
        assert assignment != null : "module should not be null";
        assignment.setDeadline(deadline);
        assert deadline != null : "deadline must not be null";
        ui.printSetAssignmentDeadline(moduleCode, assignmentName, deadline);
    }
}

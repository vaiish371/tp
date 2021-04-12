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
    private static final int EARLIEST_YEAR = 2021;
    private static final int LATEST_YEAR = 2030;
    private String moduleCode;
    private String assignmentName;
    private LocalDate deadline;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    private static Logger logger = Logger.getLogger(SetAssignmentDeadlineCommand.class.getName());

    /**
     * Constructor for SetAssignmentDeadlineCommand Class.
     *
     * @param moduleCode current module
     * @param assignmentName name of assignment
     * @param deadline deadline for assignment
     * @throws ModuleNotSelectedException not working in any module
     * @throws DateTimeParseException invalid date
     * @throws DateTimeFormatException invalid date format
     */
    public SetAssignmentDeadlineCommand(String moduleCode, String assignmentName, String deadline)
            throws ModuleNotSelectedException, DateTimeParseException, DateTimeFormatException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName.trim();
        this.deadline = LocalDate.parse(deadline.trim(), formatter);
        int year = this.deadline.getYear();
        if (year < EARLIEST_YEAR || year > LATEST_YEAR) {
            throw new DateTimeFormatException();
        }

    }

    /**
     * Sets the deadline for an assignment.
     *
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModuleNotFoundException module not found
     * @throws AssignmentNotFoundException assignment not found
     */
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

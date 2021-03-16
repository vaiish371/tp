package seedu.duke.command;

import seedu.duke.Assignment;
import seedu.duke.Module;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class ListStudentGradesForAssignmentCommand extends Command {
    public String moduleCode;
    public String assignmentName;

    public ListStudentGradesForAssignmentCommand(String moduleCode, String assignmentName) {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
    }

    public void execute(Data data, Ui ui) {
        Module module = data.find(moduleCode);
        Assignment assignmentToBeQueried = module.findAssignment(assignmentName);
        if (assignmentToBeQueried == null) {
            ui.assignmentNotFoundMessage(assignmentName, moduleCode);
        } else {
            ui.listAssignmentStudentGrades(assignmentToBeQueried);
        }
    }
}

package seedu.duke.command;

import seedu.duke.Assignment;
import seedu.duke.Module;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class ListStudentGradesForAssignmentCommand {
    public String moduleCode;
    public String assignmentName;

    public ListStudentGradesForAssignmentCommand(String moduleCode, String assignmentName) {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName;
    }

    public void execute(Data data, Ui ui) {
        Module module = data.find(moduleCode);
        ArrayList<Assignment> assignments = module.getAssignments();
        Assignment assignmentToBeQueried = null;
        for (Assignment assignment : assignments) {
            if (assignment.getName().equals(assignmentName)) {
                assignmentToBeQueried = assignment;
                break;
            }
        }
        if (assignmentToBeQueried == null) {
            System.out.println("Assignment not found!");
        } else {
            ui.listAssignmentStudentGrades(assignmentToBeQueried);
        }
    }
}
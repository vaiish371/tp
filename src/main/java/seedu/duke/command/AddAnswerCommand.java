package seedu.duke.command;

import seedu.duke.Answer;
import seedu.duke.Assignment;
import seedu.duke.AssignmentMCQ;
import seedu.duke.Module;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class AddAnswerCommand extends Command {
    public String moduleCode;
    public String assignmentName;
    public String[] assignmentAnswers;

    public AddAnswerCommand(String moduleCode, String assignmentName, String[] assignmentAnswers) {
        this.assignmentName = assignmentName;
        this.moduleCode = moduleCode;
        this.assignmentAnswers = assignmentAnswers;
    }

    public void execute(Data data, Ui ui) {
        Module module = data.find(moduleCode);
        ArrayList<Assignment> assignments = module.getAssignments();
        AssignmentMCQ assignmentToSetAnswerTo = null;
        for (Assignment i : assignments) {
            if ((i instanceof AssignmentMCQ) && (i.toString().equals(assignmentName))) {
                assignmentToSetAnswerTo = (AssignmentMCQ)i;
                break;
            }
        }
        if (assignmentToSetAnswerTo == null) {
            // throw some error
            System.out.println("Error");
        } else {
            Answer answer = new Answer(assignmentToSetAnswerTo.getNumberOfQuestions());
            answer.setAnswer(assignmentAnswers);
            assignmentToSetAnswerTo.setAnswer(answer);
            ui.printAnswerAdded(module, assignmentToSetAnswerTo);
        }
    }
}

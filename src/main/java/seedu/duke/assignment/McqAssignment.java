package seedu.duke.assignment;

import seedu.duke.exception.NumbersMisalignException;

import java.util.ArrayList;

public class McqAssignment extends Assignment {

    private Answer answer;

    public McqAssignment(String name) {
        super(name);
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answer = new Answer(answers, answers.size());
    }
}

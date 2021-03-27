package seedu.duke.assignment;

import java.util.ArrayList;

public class ShortAnswerAssignment extends Assignment {

    private Answer answer;

    public ShortAnswerAssignment(String name) {
        super(name);
    }

    @Override
    public void setAnswers(ArrayList<String> answers) {
        this.answer = new Answer(answers, answers.size());
    }
}

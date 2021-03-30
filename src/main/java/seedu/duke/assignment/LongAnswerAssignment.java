package seedu.duke.assignment;

import java.util.ArrayList;

public class LongAnswerAssignment extends Assignment {

    private Answer answer;

    public LongAnswerAssignment(String name) {
        super(name);
    }

    @Override
    public void setAnswers(Answer answer) {
        this.answer = answer;
    }

    public Answer getAnswers() {
        return this.answer;
    }
}

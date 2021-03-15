package seedu.duke;

import java.util.ArrayList;
import java.util.HashMap;

public class AssignmentMCQ extends Assignment {

    private int numberOfQuestions;
    private HashMap<String, Float> studentScores;
    private Answer answer;

    public AssignmentMCQ(String name, int numberOfQuestions) {
        super(name);
        this.numberOfQuestions = numberOfQuestions;
        this.studentScores = new HashMap<>();
        this.answer = new Answer(numberOfQuestions);
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getNumberOfQuestions() {
        return this.numberOfQuestions;
    }


}

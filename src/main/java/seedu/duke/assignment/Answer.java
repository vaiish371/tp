package seedu.duke.assignment;

import java.util.ArrayList;

public class Answer {

    private ArrayList<String> answers;
    private int numberOfQuestions;

    public Answer(ArrayList<String> answers, int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
        this.answers = answers;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }
}

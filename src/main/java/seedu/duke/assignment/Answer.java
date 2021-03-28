package seedu.duke.assignment;

import java.util.ArrayList;

public class Answer {

    private ArrayList<String> answers;
    private ArrayList<Integer> marks;
    private int numberOfQuestions;

    public Answer(ArrayList<String> answers, ArrayList<Integer> marks, int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
        this.answers = answers;
        this.marks = marks;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public int compareScript(ArrayList<String> script) {
        int score = 0;
        for (int i = 0; i < numberOfQuestions; i++) {
            if (answers.get(i).equals(script.get(i))) {
                score += marks.get(i);
            }
        }
        return score;
    }
}

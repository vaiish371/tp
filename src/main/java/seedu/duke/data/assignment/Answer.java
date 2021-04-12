package seedu.duke.data.assignment;

import java.util.ArrayList;

public class Answer {

    private ArrayList<String> answers;
    private ArrayList<Integer> marks;
    private int numberOfQuestions;

    /**
     * Constructor for Answer Class.
     *
     * @param answers ArrayList of the answers for each question
     * @param marks ArrayList of the marks for each question
     * @param numberOfQuestions number of questions in the answer key
     */
    public Answer(ArrayList<String> answers, ArrayList<Integer> marks, int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
        this.answers = answers;
        this.marks = marks;
    }

    /**
     * Returns the ArrayList of the answers for each question.
     *
     * @return answers for each question
     */
    public ArrayList<String> getAnswers() {
        return answers;
    }

    /**
     * Returns the ArrayList of the marks for each question.
     *
     * @return marks for each question
     */
    public ArrayList<Integer> getMarks() {
        return marks;
    }

    /**
     * Returns the number of questions in the answer key.
     *
     * @return number of questions in the answer key
     */
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    /**
     * Compares a student script with the answer key for the assignment.
     *
     * @param script student script
     * @return raw score the student got for the assignment
     */
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

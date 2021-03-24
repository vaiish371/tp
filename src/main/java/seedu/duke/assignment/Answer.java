package seedu.duke.assignment;

public class Answer {

    private String[] answers;
    private int numberOfQuestions;

    public Answer(String[] answers, int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
        this.answers = answers;
    }

    public String[] getAnswers() {
        return answers;
    }
}

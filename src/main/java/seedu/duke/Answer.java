package seedu.duke;

public class Answer {

    private String[] answers;
    private int numberOfQuestions;
    private boolean answerGiven; // No setter method because this needs to check independently of user input

    public Answer(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
        this.answers = new String[numberOfQuestions];
        this.answerGiven = false;
    }

    public boolean isAnswerGiven() {
        return answerGiven;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswer(String[] answers) {
        if (answers.length == numberOfQuestions) {
            this.answers = answers;
        } else {
            System.out.println("Error");
        }
    }

}

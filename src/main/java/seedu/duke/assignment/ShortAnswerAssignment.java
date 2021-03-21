package seedu.duke.assignment;

public class ShortAnswerAssignment extends Assignment {

    private Answer answer;

    public ShortAnswerAssignment(String name) {
        super(name);
    }

    public void setAnswers(String[] answers, int numberOfQuestions) {
        answer = new Answer(answers, numberOfQuestions);
    }
}

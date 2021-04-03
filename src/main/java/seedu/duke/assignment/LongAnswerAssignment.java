package seedu.duke.assignment;

public class LongAnswerAssignment extends Assignment {

    private Answer answer;

    public LongAnswerAssignment(String name) {
        super(name);
        this.typeOfAssignment = "LongAnswerAssignment";
    }

    @Override
    public void setAnswers(Answer answer) {
        this.answer = answer;
    }

    public Answer getAnswers() {
        return this.answer;
    }
}

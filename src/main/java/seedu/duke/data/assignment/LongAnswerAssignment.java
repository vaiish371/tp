package seedu.duke.data.assignment;

public class LongAnswerAssignment extends Assignment {

    private Answer answer;

    /**
     * Constructor for LongAnswerAssignment Class.
     *
     * @param name name of the assignment
     */
    public LongAnswerAssignment(String name) {
        super(name);
        this.typeOfAssignment = "LongAnswerAssignment";
    }

    /**
     * Sets the answer for the assignment.
     *
     * @param answer answer key
     */
    @Override
    public void setAnswers(Answer answer) {
        this.answer = answer;
    }

    /**
     * Returns answer key for assignment.
     *
     * @return answer key for assignment
     */
    public Answer getAnswers() {
        return this.answer;
    }
}

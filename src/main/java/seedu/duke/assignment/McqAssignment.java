package seedu.duke.assignment;

import seedu.duke.exception.NumbersMisalignException;

public class McqAssignment extends Assignment {

    private Answer answer;

    public McqAssignment(String name) {
        super(name);
    }

    public void setAnswers(String[] answers, int numberOfQuestions) throws NumbersMisalignException {
        if (answers.length != numberOfQuestions) {
            throw new NumbersMisalignException();
        }
        this.answer = new Answer(answers, numberOfQuestions);
    }
}

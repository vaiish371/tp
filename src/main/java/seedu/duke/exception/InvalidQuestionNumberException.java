package seedu.duke.exception;

public class InvalidQuestionNumberException extends ModManException {

    public InvalidQuestionNumberException() {
        this.errorMessage = "Please check that the question number or the marks for a question is an integer!";
    }

    public InvalidQuestionNumberException(String fileName) {
        this.errorMessage = "Please check the text file for " + fileName
                + "\n\t Please check that the question number or the marks for a question is an integer!";
    }
}

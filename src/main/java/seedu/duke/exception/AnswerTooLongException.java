package seedu.duke.exception;

public class AnswerTooLongException extends ModManException {
    public AnswerTooLongException() {
        this.errorMessage = "Answers should be limited to 100 characters!";
    }

    public AnswerTooLongException(String fileName) {
        this.errorMessage = "Please check the text file for " + fileName
                + "\n\t Answers should be limited to 100 characters!";
    }
}

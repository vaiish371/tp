package seedu.duke.exception;

public class MissingAnswerException extends ModManException {
    public MissingAnswerException() {
        this.errorMessage = "Please ensure all questions have answers!";
    }

    public MissingAnswerException(String fileName) {
        this.errorMessage = "Please check the text file for " + fileName
                + "\n\t Please ensure all questions have answers!";
    }
}

package seedu.duke.exception;

public class MissingMarksException extends ModManException {
    public MissingMarksException() {
        this.errorMessage = "Please check you have added marks for each question!";
    }

    public MissingMarksException(String fileName) {
        this.errorMessage = "Please check the text file for " + fileName
                + "\n\t Please check you have added marks for each question!";
    }
}

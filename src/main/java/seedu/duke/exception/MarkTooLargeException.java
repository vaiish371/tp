package seedu.duke.exception;

public class MarkTooLargeException extends ModManException {
    public MarkTooLargeException() {
        this.errorMessage = "Please check the value of the mark is not negative or too unreasonable!";
    }

    public MarkTooLargeException(String fileName) {
        this.errorMessage = "Please check the text file for " + fileName
                + "\n\t Please check the value of the mark is not negative or too unreasonable!";
    }
}

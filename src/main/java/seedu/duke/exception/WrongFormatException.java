package seedu.duke.exception;

public class WrongFormatException extends ModManException {
    public WrongFormatException() {
        this.errorMessage = "Command format is wrong.";
    }

    public WrongFormatException(String error) {
        this.errorMessage = error;
    }
}

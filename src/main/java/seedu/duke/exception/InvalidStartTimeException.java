package seedu.duke.exception;

public class InvalidStartTimeException extends ModManException {
    public InvalidStartTimeException() {
        this.errorMessage = "The start time must be before end time";
    }
}

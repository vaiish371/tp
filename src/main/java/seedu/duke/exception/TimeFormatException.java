package seedu.duke.exception;

public class TimeFormatException extends ModManException {
    public TimeFormatException() {
        this.errorMessage = "Time format is incorrect! Time must be in the format HHmm eg. 1800.";
    }
}

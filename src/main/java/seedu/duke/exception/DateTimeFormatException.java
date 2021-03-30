package seedu.duke.exception;

public class DateTimeFormatException extends ModManException {
    public DateTimeFormatException() {
        this.errorMessage = "Date/Time Format is wrong! Please try again.";
    }
}

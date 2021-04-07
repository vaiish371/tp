package seedu.duke.exception;

public class DayFormatException extends ModManException {
    public DayFormatException() {
        this.errorMessage = "Day must be spelt out fully in caps! Eg. MONDAY";
    }
}

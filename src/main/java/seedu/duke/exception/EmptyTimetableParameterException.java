package seedu.duke.exception;

public class EmptyTimetableParameterException extends ModManException {
    public EmptyTimetableParameterException() {
        this.errorMessage = "The parameter after the flag cannot be empty or whitespaces.";
    }
}

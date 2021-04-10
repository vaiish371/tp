package seedu.duke.exception;

public class EmptyParameterException extends ModManException {
    public EmptyParameterException() {
        this.errorMessage = "The parameter after the flag cannot be empty or whitespaces.";
    }
}

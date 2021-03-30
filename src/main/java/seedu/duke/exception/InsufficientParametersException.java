package seedu.duke.exception;

public class InsufficientParametersException extends ModManException {
    public InsufficientParametersException() {
        this.errorMessage = "Not enough parameters are given! Please try again.";
    }
}


package seedu.duke.exception;

public class EmptyModuleException extends ModManException {
    public EmptyModuleException() {
        this.errorMessage = "Module Code cannot be empty.";
    }
}

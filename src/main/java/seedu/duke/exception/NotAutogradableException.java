package seedu.duke.exception;

public class NotAutogradableException extends ModManException {

    public NotAutogradableException() {
        this.errorMessage = "Assignment is not autogradble";
    }
}

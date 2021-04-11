package seedu.duke.exception;

public class SameNameEditException extends ModManException {
    public SameNameEditException() {
        this.errorMessage = "The name before and after editing is the same!";
    }
}

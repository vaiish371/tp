package seedu.duke.exception;

public class IndexNotFoundException extends ModManException {
    public IndexNotFoundException() {
        this.errorMessage = "Index is either not found or written in wrong format.";
    }
}

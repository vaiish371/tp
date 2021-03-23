package seedu.duke.exception;

public class IndexNotFoundException extends ModManException {
    public IndexNotFoundException() {
        this.errorMessage = "Index is not found.";
    }
}

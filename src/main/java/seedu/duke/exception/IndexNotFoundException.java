package seedu.duke.exception;

public class IndexNotFoundException extends ModManException {
    public IndexNotFoundException() {
        this.errorMessage = "Index is either not found, written in wrong format or exceeds max/min value of integer.";
    }
}

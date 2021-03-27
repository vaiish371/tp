package seedu.duke.exception;

public class DataFileNotFoundException extends ModManException {

    public DataFileNotFoundException() {
        this.errorMessage = "File not found.";
    }
}

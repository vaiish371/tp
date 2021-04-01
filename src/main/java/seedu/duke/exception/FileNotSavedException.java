package seedu.duke.exception;

public class FileNotSavedException extends ModManException {
    public FileNotSavedException() {
        this.errorMessage = "Something went wrong when saving your data.";
    }
}

package seedu.duke.exception;

public class DataFileCorruptedException extends ModManException {
    public DataFileCorruptedException() {
        this.errorMessage = "The existing data file is corrupted.";
    }
}

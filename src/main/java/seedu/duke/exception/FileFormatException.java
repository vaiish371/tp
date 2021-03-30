package seedu.duke.exception;

public class FileFormatException extends ModManException {

    public FileFormatException() {
        this.errorMessage = "Format error in file";
    }
}

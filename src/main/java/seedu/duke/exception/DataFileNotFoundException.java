package seedu.duke.exception;

public class DataFileNotFoundException extends ModManException {
    public DataFileNotFoundException() {
        this.errorMessage = "File not found.";
    }

    public DataFileNotFoundException(String fileName) {
        this.errorMessage = "Please check the text file " + fileName
                + "\n\t File not found!";
    }
}

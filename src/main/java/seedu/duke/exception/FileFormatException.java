package seedu.duke.exception;

public class FileFormatException extends ModManException {

    public FileFormatException() {
        this.errorMessage = "Format error in file";
    }

    public FileFormatException(String fileName) {
        this.errorMessage = "Please check the text file for " + fileName
                + "\n\t Format error in file!";
    }
}

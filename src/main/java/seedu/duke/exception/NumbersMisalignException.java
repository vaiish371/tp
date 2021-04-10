package seedu.duke.exception;

public class NumbersMisalignException extends ModManException {
    public NumbersMisalignException() {
        this.errorMessage = "The number of questions do not align!";
    }

    public NumbersMisalignException(String fileName) {
        this.errorMessage = "Please check the text file for " + fileName
                + "\n\t The number of questions do not align!";
    }
}

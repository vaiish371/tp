package seedu.duke.exception;

public class NumbersMisalignException extends ModManException {
    public NumbersMisalignException() {
        this.errorMessage = "The number of questions do not align!";
    }
}

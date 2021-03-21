package seedu.duke.exception;

public class NumbersMisalignException extends ModManException {
    public NumbersMisalignException() {
        this.errorMessage = "The number of questions in your answers.txt file does not align with the number of questions you have set!";
    }
}

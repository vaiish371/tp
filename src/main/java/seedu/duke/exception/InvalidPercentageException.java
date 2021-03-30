package seedu.duke.exception;

public class InvalidPercentageException extends ModManException {

    public InvalidPercentageException() {
        this.errorMessage = "The percentage you entered is invalid! Please provide a percentage value between 0 to 100";
    }

}

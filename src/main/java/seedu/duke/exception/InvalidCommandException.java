package seedu.duke.exception;

public class InvalidCommandException extends ModManException {
    public InvalidCommandException(){
        errorMessage = "Command is invalid! Please try again";
    }
}

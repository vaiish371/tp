package seedu.duke.exception;

public class InvalidAssignmentException extends ModManException {
    public InvalidAssignmentException() {
        this.errorMessage = "Assignment type is wrong. Choose from: la, sa, mcq";
    }
}

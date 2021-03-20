package seedu.duke.exception;

public class AssignmentNotFoundException extends ModManException {
    public AssignmentNotFoundException() {
        this.errorMessage = "Assignment not found.";
    }
}

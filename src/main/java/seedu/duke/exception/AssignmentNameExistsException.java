package seedu.duke.exception;

public class AssignmentNameExistsException extends ModManException {
    public AssignmentNameExistsException() {
        this.errorMessage = "The assignment name already exists! Please choose another name for your assignment.";
    }
}

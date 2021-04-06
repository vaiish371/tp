package seedu.duke.exception;

public class DuplicateAssignmentException extends ModManException {
    public DuplicateAssignmentException() {
        this.errorMessage = "This assignment already exists! Please edit the existing\n"
                + "\t assignment or remove it before continuing.";
    }
}

package seedu.duke.exception;

public class DuplicateStudentException extends ModManException {
    public DuplicateStudentException() {
        this.errorMessage = "Student with student number or name or email already registered in module.";
    }
}

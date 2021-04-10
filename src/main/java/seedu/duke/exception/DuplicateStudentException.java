package seedu.duke.exception;

public class DuplicateStudentException extends ModManException {
    public DuplicateStudentException() {
        this.errorMessage = "Student with student number already registered in module.";
    }
}

package seedu.duke.exception;

public class StudentNotFoundException extends ModManException {
    public StudentNotFoundException() {
        this.errorMessage = "Student not found.";
    }
}

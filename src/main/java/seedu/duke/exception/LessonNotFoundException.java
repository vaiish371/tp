package seedu.duke.exception;

public class LessonNotFoundException extends ModManException {
    public LessonNotFoundException() {
        this.errorMessage = "Lesson not found! Please try again.";
    }
}

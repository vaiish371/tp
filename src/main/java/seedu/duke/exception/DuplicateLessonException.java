package seedu.duke.exception;

public class DuplicateLessonException extends ModManException {
    public DuplicateLessonException() {
        this.errorMessage = "Lesson with the exact same details is already in timetable.";
    }
}

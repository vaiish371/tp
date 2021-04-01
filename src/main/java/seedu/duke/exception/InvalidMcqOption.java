package seedu.duke.exception;

public class InvalidMcqOption extends ModManException {
    public InvalidMcqOption() {
        this.errorMessage = "Answer key contains invalid MCQ Option.\n"
                + "\t Please check that the answer key only has A, B, C, D, E or 1, 2, 3, 4, 5 as options";
    }
}

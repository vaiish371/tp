package seedu.duke.exception;

public abstract class ModManException extends Exception {
    protected String errorMessage;

    public String getErrorMessage() {
        return this.errorMessage;
    }
}

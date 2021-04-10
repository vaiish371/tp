package seedu.duke.exception;

public class ModuleNotSelectedException extends ModManException {
    public ModuleNotSelectedException() {
        this.errorMessage = "You are not currently working in any module!";
    }
}

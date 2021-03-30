package seedu.duke.exception;

public class ModuleNotSelectedException extends ModManException {
    public ModuleNotSelectedException() {
        this.errorMessage = "\t You are not currently working in any module!";
    }
}

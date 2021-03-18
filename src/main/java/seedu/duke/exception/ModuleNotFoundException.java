package seedu.duke.exception;

public class ModuleNotFoundException extends ModManException {
    public ModuleNotFoundException() {
        this.errorMessage = "Module is not found.";
    }
}

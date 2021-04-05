package seedu.duke.exception;

public class DuplicateModuleException extends ModManException {
    public DuplicateModuleException() {
        this.errorMessage = "This module already exists! \n"
                + "\t You can use the select command to select it as the module to work in.";
    }
}

package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModManException;
import seedu.duke.ui.Ui;

/**
 * Abstract command class to be inherited from all commands.
 */
public abstract class Command {

    /**
     * Set to true only if the exit command is called.
     */
    private boolean isExit = false;

    /**
     * Execute function to be run by all commands.
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModManException which is a superclass of all exceptions that can be expected from ModMan
     */
    public abstract void execute(Data data, Ui ui, Storage storage) throws ModManException;

    public boolean isExit() {
        return isExit;
    }

    public void setExit() {
        this.isExit = true;
    }

}

package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

public class ExitCommand extends Command {

    /**
     * Constructor for ExitCommand Class.
     */
    public ExitCommand() {
        this.setExit();
    }

    /**
     * Prints goodbye message.
     *
     * @param data keeps track of module information.
     * @param ui prints messages to the console.
     * @param storage saves and retrieves information from database.
     */
    public void execute(Data data, Ui ui, Storage storage) {
        ui.showExitMessage();
    }

}
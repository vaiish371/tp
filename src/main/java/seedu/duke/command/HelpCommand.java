package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModManException;
import seedu.duke.ui.Ui;

public class HelpCommand extends Command {

    /**
     * Constructor for HelpCommand Class.
     */
    public HelpCommand() {
    }

    /**
     * Prints help message listing basic commands for the user.
     *
     * @param data keeps track of module information.
     * @param ui prints messages to the console.
     * @param storage saves and retrieves information from database.
     */
    public void execute(Data data, Ui ui, Storage storage) {
        ui.printHelpMessage();
    }
}

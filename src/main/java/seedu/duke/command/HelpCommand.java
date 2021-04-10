package seedu.duke.command;

import seedu.duke.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModManException;
import seedu.duke.ui.Ui;

public class HelpCommand extends Command {

    public HelpCommand() {
    }

    public void execute(Data data, Ui ui, Storage storage) throws ModManException {
        ui.printHelpMessage();
    }
}

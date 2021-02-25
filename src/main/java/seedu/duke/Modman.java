package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.data.Data;
import seedu.duke.exception.ModManException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

public class Modman {

    private Data data;
    private Ui ui;

    public Modman() {
        ui = new Ui();
        data = new Data();
    }

    public void run() {
        ui.showWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(data, ui);
                isExit = c.isExit();
            } catch (ModManException e) {
                ui.showError(e.getErrorMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Modman().run();
    }
}

package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.data.Data;
import seedu.duke.exception.FileNotSavedException;
import seedu.duke.exception.ModManException;
import seedu.duke.parser.Parser;
//import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.logging.LogManager;

public class Modman {

    private Storage storage;
    private Data data;
    private Ui ui;

    public Modman() {
        ui = new Ui();
        storage = new Storage();
        try {
            data = storage.loadData();
        } catch (ModManException e) {
            data = new Data();
        }
    }

    public void run() {
        ui.showWelcomeMessage();
        ui.printModules(data.getModules());
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(data, ui, storage);
                isExit = c.isExit();
            } catch (ModManException e) {
                ui.showError(e.getErrorMessage());
            } finally {
                Ui.showLine();
            }
        }
        try {
            storage.saveData(data);
        } catch (FileNotSavedException e) {
            ui.showError(e.getErrorMessage());
        }
    }

    public static void main(String[] args) {
        LogManager.getLogManager().reset();
        new Modman().run();
    }
}

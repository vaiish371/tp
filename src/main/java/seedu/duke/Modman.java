package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.data.Data;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.FileNotSavedException;
import seedu.duke.exception.ModManException;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.logging.LogManager;

/**
 * Main class of the program.
 */
public class Modman {

    private Storage storage;
    private Data data;
    private Ui ui;

    /**
     * Main method of the program.
     * @throws FileNotSavedException if ModMan fails to save the data file
     */
    public Modman() throws FileNotSavedException {
        ui = new Ui();
        storage = new Storage();
        try {
            data = storage.loadData();
        } catch (DataFileNotFoundException e) {
            data = new Data();
            storage.saveData(data);
        } catch (ModManException e) {
            data = new Data();
            storage.saveData(data);
            ui.showUnrecognisedLoadError();
        } catch (Exception e) {
            data = new Data();
            storage.saveData(data);
            ui.showUnrecognisedLoadError();
        }
    }

    /**
     * Run method of the program that runs constantly in a while loop.
     */
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
            } catch (Exception e) {
                ui.showUnrecognisedError();
            } finally {
                Ui.showLine();
            }
        }
        try {
            storage.saveData(data);
        } catch (FileNotSavedException e) {
            ui.showError(e.getErrorMessage());
        } catch (Exception e) {
            ui.showUnrecognisedSaveError();
        }
    }

    public static void main(String[] args) throws FileNotSavedException {
        LogManager.getLogManager().reset();
        new Modman().run();
    }
}

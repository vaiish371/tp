package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.ModManException;
import seedu.duke.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AddModuleCommandTest {
    public static Data data = new Data();
    public static Ui ui = new Ui();
    public static Storage storage = new Storage();

    @Test
    void addmodule_CS2113T_success() throws ModManException {
        Command c = new AddModuleCommand("CS2113T");
        c.execute(data, ui, storage);
        assertEquals("CS2113T", data.find("CS2113T").getModuleCode());
    }

}

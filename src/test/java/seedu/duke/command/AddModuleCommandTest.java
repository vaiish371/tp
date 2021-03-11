package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class AddModuleCommandTest {
    public static Data data = new Data();
    public static Ui ui = new Ui();

    @Test
    void addmodule_CS2113T_success() {
        Command c = new AddModuleCommand("CS2113T");
        c.execute(data, ui);
        assertEquals("CS2113T", data.find("CS2113T").getModuleCode());
    }

    @Test
    void addmodule_null_exceptionThrown() {
        Command c = new AddModuleCommand(null);
        c.execute(data, ui);
        assertThrows(NullPointerException.class, () -> {
            data.find(null).getModuleCode();
        });
    }
}
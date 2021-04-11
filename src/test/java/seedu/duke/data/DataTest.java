package seedu.duke.data;

import org.junit.jupiter.api.Test;
import seedu.duke.data.module.Module;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DataTest {

    @Test
    void testFindModule() {
        Module mod =  new Module("CS2101");
        Data data = new Data();
        data.add(mod);
        assertEquals("CS2101", data.find("CS2101").getModuleCode());
    }

    @Test
    void testModuleNotFound() {
        Module mod =  new Module("CS2101");
        Data data = new Data();
        data.add(mod);
        assertThrows(NullPointerException.class, () -> data.find("CS2113T").getModuleCode());
    }
}
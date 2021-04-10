package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.exception.DateTimeFormatException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class SetAssignmentDeadlineCommandTest {

    @Test
    void setDeadline_01_01_2020_failOne() {
        assertThrows(DateTimeFormatException.class, () -> {
            new SetAssignmentDeadlineCommand("CS2113T", "Magic Sequence", "31 12 2020");
        });
    }

    @Test
    void setDeadline_01_01_2020_failTwo() {
        assertThrows(DateTimeFormatException.class, () -> {
            new SetAssignmentDeadlineCommand("CS2113T", "Magic Sequence", "01 01 2031");
        });
    }

    @Test
    void setDeadline_01_01_2020_passOne() {
        assertDoesNotThrow(() -> new SetAssignmentDeadlineCommand("CS2113T", "Magic Sequence", "31 12 2030"));
    }

    @Test
    void setDeadline_01_01_2020_passTwo() {
        assertDoesNotThrow(() -> new SetAssignmentDeadlineCommand("CS2113T", "Magic Sequence", "01 01 2021"));
    }

}

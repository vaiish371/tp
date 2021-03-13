package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.command.AddAssignmentCommand;
import seedu.duke.command.AddModuleCommand;
import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.exception.ModManException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ParserTest {

    @Test
    void testParse_bye_ExitCommand() throws ModManException {
        Parser parser = new Parser();
        String inputString = "bye";
        Command c = parser.parse(inputString);
        assertEquals(true, c instanceof ExitCommand);
    }


    @Test
    void testParse_addmodule_AddModuleCommand() throws ModManException {
        Parser parser = new Parser();
        String inputString = "addmodule CS2113T";
        Command c = parser.parse(inputString);
        assertEquals(true, c instanceof AddModuleCommand);
    }

    @Test
    void testParse_addassignment_AddAssignmentCommand() throws ModManException {
        Parser parser = new Parser();
        String inputString = "addassignment CS2113T quiz1";
        Command c = parser.parse(inputString);
        assertEquals(true, c instanceof AddAssignmentCommand);
    }

    @Test
    void testParse_invalidInput_expectException() {
        Parser parser = new Parser();
        String inputString = "blah";
        assertThrows(InvalidCommandException.class, () -> {
            parser.parse(inputString);
        });
    }
}
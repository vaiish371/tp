package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.Module;
import seedu.duke.command.AddAssignmentCommand;
import seedu.duke.command.AddModuleCommand;
import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.ListModuleAssignmentsCommand;
import seedu.duke.command.SetAssignmentDeadlineCommand;
import seedu.duke.exception.InsufficientParametersException;
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
    void testParse_addModuleValid_AddModuleCommand() throws ModManException {
        Parser parser = new Parser();
        String inputString = "add module CS2113T";
        Command c = parser.parse(inputString);
        assertEquals(true, c instanceof AddModuleCommand);
    }

    @Test
    void testParse_addModuleNoModuleCode_InvalidCommandException() {
        Parser parser = new Parser();
        String inputString = "add module ";
        assertThrows(InvalidCommandException.class, () -> {
            parser.parse(inputString);
        });
    }

    @Test
    void testParse_addAssignmentValid_AddAssignmentCommand() throws ModManException {
        Parser parser = new Parser();
        String inputString = "add assignment /a quiz1";
        Command c = parser.parse(inputString);
        assertEquals(true, c instanceof AddAssignmentCommand);
    }

    @Test
    void testParse_addAssignmentMissingParam_InvalidCommandException() {
        Parser parser = new Parser();
        String inputString = "add assignment ";
        assertThrows(InvalidCommandException.class, () -> {
            parser.parse(inputString);
        });
    }

    @Test
    void testParse_addAssignmentEmptyAssignment_InsufficientParametersException() {
        Parser parser = new Parser();
        String inputString = "add assignment /a     ";
        assertThrows(InsufficientParametersException.class, () -> {
            parser.parse(inputString);
        });
    }

    @Test
    void testParse_listAssignmentValid_ListModuleAssignmentsCommand() throws ModManException {
        Parser parser = new Parser();
        Module testModule = new Module("CS2113T");
        Parser.setCurrentModule(testModule.getModuleCode());
        String inputString = "list assignments";
        Command c = parser.parse(inputString);
        assertEquals(true, c instanceof ListModuleAssignmentsCommand);
    }

    @Test
    void testParse_setAssignmentDeadlineValid_SetAssignmentDeadlineCommand() throws ModManException {
        Parser parser = new Parser();
        String inputString = "set assignment deadline /a quiz1 /d 16 08 2021";
        Command c = parser.parse(inputString);
        assertEquals(true, c instanceof SetAssignmentDeadlineCommand);
    }

    @Test
    void testParse_setAssignmentDeadlineMissingParam_InvalidCommandException() {
        Parser parser = new Parser();
        String inputString = "set assignment deadline /a quiz1 ";
        assertThrows(InsufficientParametersException.class, () -> {
            parser.parse(inputString);
        });
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

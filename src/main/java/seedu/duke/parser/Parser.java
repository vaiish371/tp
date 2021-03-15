package seedu.duke.parser;

import seedu.duke.command.*;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.exception.ModManException;

public class Parser {

    public static Command parse(String line) throws ModManException {
        Command command = null;
        String[] args = line.split(" ");
        switch (args[0]) {
        case "bye":
            command = new ExitCommand();
            break;
        case "addmodule":
            command = new AddModuleCommand(args[1]);
            break;
        case "addassignment":
            command = new AddAssignmentCommand(args[1], args[2]);
            break;
        case "addtimetable":
            //Module Time Venue Lesson_Type
            String[] times = args[4].split("-");
            command = new AddTimetableCommand(args[1], args[2], args[3], times[0], times[1], times[2]);
            break;
        default:
            throw new InvalidCommandException();
        }
        return command;
    }
}

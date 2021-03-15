package seedu.duke.parser;

import seedu.duke.command.*;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.exception.ModManException;

public class Parser {

    public static Command parse(String line) throws ModManException {
        Command command = null;
        String[] words = line.split(" ");
        switch (words[0]) {
        case "bye":
            command = new ExitCommand();
            break;
        case "addmodule":
            command = new AddModuleCommand(words[1]);
            break;
        case "addassignment":
            command = new AddAssignmentCommand(words[1], words[2]);
            break;
        case "addtimetable":
            //Module Time Venue Lesson_Type
            String[] times = words[4].split("-");
            command = new AddTimetableCommand(words[1], words[2], words[3], times[0], times[1], times[2]);
            break;
        default:
            throw new InvalidCommandException();
        }
        return command;
    }
}

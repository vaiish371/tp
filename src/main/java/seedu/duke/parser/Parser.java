package seedu.duke.parser;

import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.exception.ModManException;

public class Parser {

    public static Command parse(String line) throws ModManException {
        Command command = null;
        String[] words = line.split(" ");
        switch (words[0]){
        case "bye":
            command = new ExitCommand();
            break;
        default:
            throw new InvalidCommandException();
        }
        return command;

    }
}

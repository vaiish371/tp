package seedu.duke.parser;

import seedu.duke.command.*;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.exception.ModManException;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Parser {
    private static Logger logger = Logger.getLogger(Parser.class.getName());

    public static Command parse(String line) throws ModManException {
        logger.setLevel(Level.INFO);
        logger.log(Level.FINE, "Parsing user command");
        Command command = null;
        String[] words = line.split(" ");
        switch (words[0]) {
        case "bye":
            logger.log(Level.INFO, "bye command entered");
            command = new ExitCommand();
            break;
        case "addmodule":
            logger.log(Level.INFO, "addmodule command entered");
            command = new AddModuleCommand(words[1]);
            break;
        case "addassignment":
            logger.log(Level.INFO, "addassignment command entered");
            command = new AddAssignmentCommand(words[1], words[2]);
            break;
        case "addassignmentmcq":
            logger.log(Level.INFO, "addassignmentmcq command entered");
            command = new AddAssignmentMCQCommand(words[1], words[2], words[3]);
            break;
        case "addanswers":
            logger.log(Level.INFO, "addanswers command entered");
            String[] answers = Arrays.copyOfRange(words, 3, words.length);
            command = new AddAnswerCommand(words[1], words[2], answers);
            break;
        case "listassignment":
            logger.log(Level.INFO, "listassignment command entered");
            command = new ListModuleAssignmentsCommand(words[1]);
            break;
        default:
            logger.log(Level.WARNING, "Invalid command entered");
            throw new InvalidCommandException();
        }
        assert command != null : "command should not be null";
        return command;
    }
}

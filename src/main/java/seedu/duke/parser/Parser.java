package seedu.duke.parser;

import seedu.duke.command.ListStudentsDetailsCommand;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.exception.ModManException;

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
        case "addModule":
            logger.log(Level.INFO, "addModule command entered");
            command = new AddModuleCommand(words[1]);
            break;
        case "addAssignment":
            logger.log(Level.INFO, "addAssignment command entered");
            command = new AddAssignmentCommand(words[1], words[2]);
            break;
        case "addStudent":
            logger.log(Level.INFO, "addStudent command entered");
            command = new AddStudentCommand(words[1], words[2], words[3], words[4], words[5]);
            break;
        case "listAssignment":
            logger.log(Level.INFO, "listAssignment command entered");
            command = new ListModuleAssignmentsCommand(words[1]);
            break;
        case "listStudents":  //lists only the names of students in a module
            logger.log(Level.INFO, "listStudents command entered");
            command = new ListModuleStudentsCommand(words[1]);
            break;
        case "listStudentDetails": //list details of students in a module
            logger.log(Level.INFO, "listStudentDetails command entered");
            command = new ListStudentsDetailsCommand(words[1]);
            break;
        default:
            logger.log(Level.WARNING, "Invalid command entered");
            throw new InvalidCommandException();
        }
        assert command != null : "command should not be null";
        return command;
    }
}

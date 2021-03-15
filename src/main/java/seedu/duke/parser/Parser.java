package seedu.duke.parser;

import seedu.duke.command.ListStudentsDetailsCommand;
import seedu.duke.command.AddTimetableCommand;
import seedu.duke.command.AddAssignmentCommand;
import seedu.duke.command.AddModuleCommand;
import seedu.duke.command.AddStudentCommand;
import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.ListModuleAssignmentsCommand;
import seedu.duke.command.ListModuleStudentsCommand;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.exception.ModManException;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Parser {
    private static Logger logger = Logger.getLogger(Parser.class.getName());

    public static Command parse(String line) throws ModManException {
        logger.setLevel(Level.INFO);
        logger.log(Level.FINE, "parsing user command");
        Command command = null;
        String[] args = line.split("\\s+");
        String commandType;
        try {
            commandType = args[0].toLowerCase();
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "no parameters were entered");
            throw new InvalidCommandException();
        }
        assert commandType != null : "user input is empty";
        switch (commandType) {
        case "bye":
            logger.log(Level.INFO, "bye command entered");
            command = new ExitCommand();
            break;
        case "addmodule":
            try {
                logger.log(Level.INFO, "addmodule command entered");
                command = new AddModuleCommand(args[1]);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.log(Level.WARNING, "not enough parameters for addmodule command");
                throw new InvalidCommandException();
            }
        case "addassignment":
            try {
                logger.log(Level.INFO, "addassignment command entered");
                command = new AddAssignmentCommand(args[1], args[2]);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.log(Level.WARNING, "not enough parameters for addassignment command");
                throw new InvalidCommandException();
            }
        case "listassignment":
            try {
                logger.log(Level.INFO, "listassignment command entered");
                command = new ListModuleAssignmentsCommand(args[1]);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.log(Level.WARNING, "not enough parameters for addassignment command");
                throw new InvalidCommandException();
            }
        case "addstudent":
            logger.log(Level.INFO, "addstudent command entered");
            command = new AddStudentCommand(args[1], args[2], args[3], args[4], args[5]);
            break;
        case "liststudent":
            logger.log(Level.INFO, "liststudent command entered");
            command = new ListModuleStudentsCommand(args[1]);
            break;
        case "addtimetable":
            String[] times = args[4].split("-");
            command = new AddTimetableCommand(args[1], args[2], args[3], times[0], times[1], times[2]);
            break;
        case "listStudentDetails": //list details of students in a module
            logger.log(Level.INFO, "listStudentDetails command entered");
            command = new ListStudentsDetailsCommand(args[1]);
            break;
        default:
            logger.log(Level.WARNING, "invalid command entered");
            throw new InvalidCommandException();
        }
        assert command != null : "command should not be null";
        return command;
    }
}

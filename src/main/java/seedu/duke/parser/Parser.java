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
    private static final int ADD_MODULE_LENGTH = 11;
    private static final int LIST_ASSIGNMENT_LENGTH = 16;
    private static final int M_LENGTH = 3;
    private static final int A_LENGTH = 3;
    private static final int S_LENGTH = 3;
    private static final int E_LENGTH = 3;
    private static final int T_LENGTH = 3;
    private static final int V_LENGTH = 3;
    private static final int D_LENGTH = 3;
    private static final int HASH_LENGTH = 3;
    private static final int LIST_STUDENT_LENGTH = 13;
    private static final int LIST_STUDENT_DETAILS_LENGTH = 21;

    public static Command parse(String line) throws ModManException {
        logger.setLevel(Level.INFO);
        logger.log(Level.FINE, "parsing user command");
        Command command = null;
        if (line.equals("bye")) {
            logger.log(Level.INFO, "bye command entered");
            command = new ExitCommand();
        } else if (line.startsWith("add module ")) {
            try {
                logger.log(Level.INFO, "add module command entered");
                String moduleCode = line.substring(ADD_MODULE_LENGTH);
                command = new AddModuleCommand(moduleCode);
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.log(Level.WARNING, "not enough parameters for add module command");
                throw new InvalidCommandException();
            }
        } else if (line.startsWith("add assignment ")) {
            try {
                logger.log(Level.INFO, "add assignment command entered");
                String module_seperator = "/m";
                String assignment_seperator = "/a";
                int module_index = line.indexOf(module_seperator);
                int assignment_index = line.indexOf(assignment_seperator);
                String moduleCode = line.substring(module_index + M_LENGTH, assignment_index - 1);
                String assignmentName = line.substring(assignment_index + A_LENGTH).trim();
                command = new AddAssignmentCommand(moduleCode, assignmentName);
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.log(Level.WARNING, "not enough parameters for add assignment command");
                throw new InvalidCommandException();
            }
        } else if (line.startsWith("list assignment ")) {
            try {
                logger.log(Level.INFO, "list assignment command entered");
                String moduleCode = line.substring(LIST_ASSIGNMENT_LENGTH);
                command = new ListModuleAssignmentsCommand(moduleCode);
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.log(Level.WARNING, "not enough parameters for list assignment command");
                throw new InvalidCommandException();
            }
        } else if (line.startsWith("add student ")) {
            logger.log(Level.INFO, "add student command entered");
            String module_seperator = "/m";
            String name_seperator = "/s";
            String number_seperator = "/#";
            String email_seperator = "/e";
            int module_index = line.indexOf(module_seperator);
            int name_index = line.indexOf(name_seperator);
            int number_index = line.indexOf(number_seperator);
            int email_index = line.indexOf(email_seperator);
            String moduleCode = line.substring(module_index + M_LENGTH, name_index - 1);
            String studentName = line.substring(name_index + S_LENGTH, number_index - 1);
            String studentNumber = line.substring(number_index + HASH_LENGTH, email_index - 1);
            String email = line.substring(email_index + E_LENGTH).trim();
            command = new AddStudentCommand(moduleCode, studentName, studentNumber, email);
        } else if (line.startsWith("list student ")) {
            logger.log(Level.INFO, "list student command entered");
            String moduleCode = line.substring(LIST_STUDENT_LENGTH);
            command = new ListModuleStudentsCommand(moduleCode);
        } else if (line.startsWith("add timetable ")) {
            String module_seperator = "/m";
            String type_seperator = "/t";
            String venue_seperator = "/v";
            String day_seperator = "/d";
            String start_seperator = "/s";
            String end_seperator = "/e";
            int module_index = line.indexOf(module_seperator);
            int type_index = line.indexOf(type_seperator);
            int venue_index = line.indexOf(venue_seperator);
            int day_index = line.indexOf(day_seperator);
            int start_index = line.indexOf(start_seperator);
            int end_index = line.indexOf(end_seperator);
            String moduleCode = line.substring(module_index + M_LENGTH, type_index - 1);
            String type = line.substring(type_index + T_LENGTH, venue_index - 1);
            String venue = line.substring(venue_index + V_LENGTH, day_index - 1);
            String day = line.substring(day_index + D_LENGTH, start_index - 1);
            String start = line.substring(start_index + S_LENGTH, end_index - 1);
            String end = line.substring(end_index + E_LENGTH).trim();
            command = new AddTimetableCommand(moduleCode, type, venue, day, start, end);
        } else if (line.startsWith("list student details ")) {
            logger.log(Level.INFO, "listStudentDetails command entered");
            String moduleCode = line.substring(LIST_STUDENT_DETAILS_LENGTH);
            command = new ListStudentsDetailsCommand(moduleCode);
        } else {
            logger.log(Level.WARNING, "invalid command entered");
            throw new InvalidCommandException();
        }
        assert command != null : "command should not be null";
        return command;
    }



}

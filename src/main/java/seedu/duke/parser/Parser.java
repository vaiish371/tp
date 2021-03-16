package seedu.duke.parser;

import seedu.duke.command.ListStudentGradesForAssignmentCommand;
import seedu.duke.command.ListStudentsDetailsCommand;
import seedu.duke.command.AddTimetableCommand;
import seedu.duke.command.AddAssignmentCommand;
import seedu.duke.command.AddModuleCommand;
import seedu.duke.command.AddStudentCommand;
import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.ListModuleAssignmentsCommand;
import seedu.duke.command.ListModuleStudentsCommand;

import seedu.duke.command.SetAssignmentGradeCommand;
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
    private static final int G_LENGTH = 3;
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
            command = getAddModuleCommand(line);
        } else if (line.startsWith("add assignment ")) {
            command = getAddAssignmentCommand(line);
        } else if (line.startsWith("list assignment ")) {
            command = getListModuleAssignmentCommand(line);
        } else if (line.startsWith("add student ")) {
            command = getAddStudentCommand(line);
        } else if (line.startsWith("list student details ")) {
            command = getListStudentDetailsCommand(line);
        } else if (line.startsWith("list student assignment grades ")) {
            command = getListStudentAssignmentGradesCommand(line);
        } else if (line.startsWith("list student ")) {
            command = getListStudentCommand(line);
        } else if (line.startsWith("add timetable ")) {
            command = getAddTimetableCommand(line);
        } else if (line.startsWith("set assignment grade ")) {
            command = getSetAssignmentGradeCommand(line);
        } else {
            logger.log(Level.WARNING, "invalid command entered");
            throw new InvalidCommandException();
        }
        assert command != null : "command should not be null";
        return command;
    }

    private static Command getSetAssignmentGradeCommand(String line) {
        Command command;
        String moduleSeperator = "/m";
        String assignmentSeperator = "/a";
        String studentSeperator = "/s";
        String gradeSeparator = "/g";
        int moduleIndex = line.indexOf(moduleSeperator);
        int assignmentIndex = line.indexOf(assignmentSeperator);
        int studentIndex = line.indexOf(studentSeperator);
        int gradeIndex = line.indexOf(gradeSeparator);
        String moduleCode = line.substring(moduleIndex + M_LENGTH, assignmentIndex - 1);
        String assignmentName = line.substring(assignmentIndex + A_LENGTH, studentIndex - 1);
        String studentName = line.substring(studentIndex + S_LENGTH, gradeIndex - 1);
        String grade = line.substring(gradeIndex + G_LENGTH).trim();
        command = new SetAssignmentGradeCommand(moduleCode, assignmentName, studentName, grade);
        return command;
    }

    private static Command getListStudentDetailsCommand(String line) {
        Command command;
        logger.log(Level.INFO, "listStudentDetails command entered");
        String moduleCode = line.substring(LIST_STUDENT_DETAILS_LENGTH);
        command = new ListStudentsDetailsCommand(moduleCode);
        return command;
    }

    private static Command getAddTimetableCommand(String line) {
        Command command;
        String moduleSeperator = "/m";
        String typeSeperator = "/t";
        String venueSeperator = "/v";
        String daySeperator = "/d";
        String startSeperator = "/s";
        String endSeperator = "/e";
        int moduleIndex = line.indexOf(moduleSeperator);
        int typeIndex = line.indexOf(typeSeperator);
        int venueIndex = line.indexOf(venueSeperator);
        int dayIndex = line.indexOf(daySeperator);
        int startIndex = line.indexOf(startSeperator);
        int endIndex = line.indexOf(endSeperator);
        String moduleCode = line.substring(moduleIndex + M_LENGTH, typeIndex - 1);
        String type = line.substring(typeIndex + T_LENGTH, venueIndex - 1);
        String venue = line.substring(venueIndex + V_LENGTH, dayIndex - 1);
        String day = line.substring(dayIndex + D_LENGTH, startIndex - 1);
        String start = line.substring(startIndex + S_LENGTH, endIndex - 1);
        String end = line.substring(endIndex + E_LENGTH).trim();
        command = new AddTimetableCommand(moduleCode, type, venue, day, start, end);
        return command;
    }

    private static Command getListStudentCommand(String line) {
        Command command;
        logger.log(Level.INFO, "list student command entered");
        String moduleCode = line.substring(LIST_STUDENT_LENGTH);
        command = new ListModuleStudentsCommand(moduleCode);
        return command;
    }

    private static Command getAddStudentCommand(String line) {
        Command command;
        logger.log(Level.INFO, "add student command entered");
        String moduleSeperator = "/m";
        String nameSeperator = "/s";
        String numberSeperator = "/#";
        String emailSeperator = "/e";
        int moduleIndex = line.indexOf(moduleSeperator);
        int nameIndex = line.indexOf(nameSeperator);
        int numberIndex = line.indexOf(numberSeperator);
        int emailIndex = line.indexOf(emailSeperator);
        String moduleCode = line.substring(moduleIndex + M_LENGTH, nameIndex - 1);
        String studentName = line.substring(nameIndex + S_LENGTH, numberIndex - 1);
        String studentNumber = line.substring(numberIndex + HASH_LENGTH, emailIndex - 1);
        String email = line.substring(emailIndex + E_LENGTH).trim();
        command = new AddStudentCommand(moduleCode, studentName, studentNumber, email);
        return command;
    }

    private static Command getListModuleAssignmentCommand(String line) throws InvalidCommandException {
        Command command;
        try {
            logger.log(Level.INFO, "list assignment command entered");
            String moduleCode = line.substring(LIST_ASSIGNMENT_LENGTH);
            command = new ListModuleAssignmentsCommand(moduleCode);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for list assignment command");
            throw new InvalidCommandException();
        }
        return command;
    }

    private static Command getAddAssignmentCommand(String line) throws InvalidCommandException {
        Command command;
        try {
            logger.log(Level.INFO, "add assignment command entered");
            String moduleSeperator = "/m";
            String assignmentSeperator = "/a";
            int moduleIndex = line.indexOf(moduleSeperator);
            int assignmentIndex = line.indexOf(assignmentSeperator);
            String moduleCode = line.substring(moduleIndex + M_LENGTH, assignmentIndex - 1);
            String assignmentName = line.substring(assignmentIndex + A_LENGTH).trim();
            command = new AddAssignmentCommand(moduleCode, assignmentName);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for add assignment command");
            throw new InvalidCommandException();
        }
        return command;
    }
    
    private static Command getListStudentAssignmentGradesCommand(String line) throws InvalidCommandException {
        Command command;
        try {
            logger.log(Level.INFO, "list student assignment grades command entered");
            String moduleSeperator = "/m";
            String assignmentSeperator = "/a";
            int moduleIndex = line.indexOf(moduleSeperator);
            int assignmentIndex = line.indexOf(assignmentSeperator);
            String moduleCode = line.substring(moduleIndex + M_LENGTH, assignmentIndex - 1);
            String assignmentName = line.substring(assignmentIndex + A_LENGTH).trim();
            command = new ListStudentGradesForAssignmentCommand(moduleCode, assignmentName);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for add assignment command");
            throw new InvalidCommandException();
        }
        return command;
    }

    private static Command getAddModuleCommand(String line) throws InvalidCommandException {
        Command command;
        try {
            logger.log(Level.INFO, "add module command entered");
            String moduleCode = line.substring(ADD_MODULE_LENGTH);
            command = new AddModuleCommand(moduleCode);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for add module command");
            throw new InvalidCommandException();
        }
        return command;
    }
}

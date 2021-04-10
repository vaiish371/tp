package seedu.duke.parser;

import seedu.duke.command.AddAssignmentCommand;
import seedu.duke.command.AddModuleCommand;
import seedu.duke.command.AddStudentCommand;
import seedu.duke.command.AddTimetableCommand;
import seedu.duke.command.AutogradeAssignmentCommand;
import seedu.duke.command.Command;
import seedu.duke.command.CurrentModuleCommand;
import seedu.duke.command.DeleteModuleTimetableCommand;
import seedu.duke.command.EditAssignmentNameCommand;
import seedu.duke.command.EditModuleTimetableCommand;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.GetAssignmentCommentsCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.ListModuleAssignmentsCommand;
import seedu.duke.command.ListModuleCommand;
import seedu.duke.command.ListModuleStudentsCommand;
import seedu.duke.command.ListModuleTimetableCommand;
import seedu.duke.command.ListStudentGradesForAssignmentCommand;
import seedu.duke.command.ListStudentsDetailsCommand;
import seedu.duke.command.RemoveModuleCommand;
import seedu.duke.command.SelectModuleCommand;
import seedu.duke.command.SetAssignmentCommentsCommand;
import seedu.duke.command.SetAssignmentDeadlineCommand;
import seedu.duke.command.SetAssignmentGradeCommand;
import seedu.duke.command.SetAssignmentPercentageCommand;
import seedu.duke.command.SortAssignmentByDeadlineCommand;
import seedu.duke.command.ViewAnswersCommand;
import seedu.duke.command.ViewScriptCommand;
import seedu.duke.exception.DateTimeFormatException;
import seedu.duke.exception.DayFormatException;
import seedu.duke.exception.EmptyTimetableParameterException;
import seedu.duke.exception.IndexNotFoundException;
import seedu.duke.exception.InsufficientParametersException;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.exception.InvalidPercentageException;
import seedu.duke.exception.ModManException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.exception.TimeFormatException;

import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Parser {
    private static final Logger logger = Logger.getLogger(Parser.class.getName());
    private static final int ADD_MODULE_LENGTH = 11;
    private static final int REMOVE_MODULE_LENGTH = 14;
    private static final int DELETE_TIMETABLE_LENGTH = 17;
    private static final int EDIT_TIMETABLE_LENGTH = 15;
    private static final int A_LENGTH = 3;
    private static final int C_LENGTH = 3;
    private static final int S_LENGTH = 3;
    private static final int E_LENGTH = 3;
    private static final int T_LENGTH = 3;
    private static final int V_LENGTH = 3;
    private static final int D_LENGTH = 3;
    private static final int G_LENGTH = 3;
    private static final int HASH_LENGTH = 3;
    private static final int SELECT_LENGTH = 7;
    private static String currentModule = null;

    public static Command parse(String line) throws ModManException {
        logger.setLevel(Level.INFO);
        logger.log(Level.FINE, "parsing user command");
        Command command;
        line = line.trim();
        if (line.equals("bye")) {
            logger.log(Level.INFO, "bye command entered");
            command = new ExitCommand();
        } else if (line.equals("help")) {
            command = getHelpModuleCommand();
        } else if (line.startsWith("select ")) {
            command = getSelectModuleCommand(line);
        } else if (line.equals("list module")) {
            command = getListModuleCommand();
        } else if (line.startsWith("add module ")) {
            command = getAddModuleCommand(line);
        } else if (line.startsWith("remove module ")) {
            command = getRemoveModuleCommand(line);
        } else if (line.equals("current")) {
            command = getCurrentModuleCommand();
        } else if (line.startsWith("add assignment ")) {
            command = getAddAssignmentCommand(line);
        } else if (line.equals("list assignments")) {
            command = getListModuleAssignmentCommand();
        } else if (line.startsWith("add student ")) {
            command = getAddStudentCommand(line);
        } else if (line.equals("list student details")) {
            command = getListStudentDetailsCommand();
        } else if (line.startsWith("list assignment grades ")) {
            command = getListStudentAssignmentGradesCommand(line);
        } else if (line.equals("list student")) {
            command = getListStudentCommand();
        } else if (line.startsWith("add timetable ")) {
            command = getAddTimetableCommand(line);
        } else if (line.equals("list timetable")) {
            command = getListModuleTimetableCommand();
        } else if (line.startsWith("edit timetable ")) {
            command = getEditModuleTimetableCommand(line);
        } else if (line.startsWith("delete timetable ")) {
            command = getDeleteModuleTimetableCommand(line);
        } else if (line.startsWith("set assignment grade ")) {
            command = getSetAssignmentGradeCommand(line);
        } else if (line.startsWith("set assignment comments ")) {
            command = getSetAssignmentCommentsCommand(line);
        } else if (line.startsWith("get assignment comments ")) {
            command = getGetAssignmentCommentsCommand(line);
        } else if (line.startsWith("set assignment percentage ")) {
            command = getSetAssignmentPercentageCommand(line);
        } else if (line.startsWith("set assignment deadline ")) {
            command = getSetAssignmentDeadlineCommand(line);
        } else if (line.equals("sort assignments by deadline")) {
            command = getSortAssignmentByDeadlineCommand();
        } else if (line.startsWith("edit assignment name ")) {
            command = getEditAssignmentNameCommand(line);
        } else if (line.startsWith("view assignment answer ")) {
            command = getViewAnswersCommand(line);
        } else if (line.startsWith("view student script ")) {
            command = getViewScriptCommand(line);
        } else if (line.startsWith("autograde assignment ")) {
            command = getAutogradeAssignentCommand(line);
        } else {
            logger.log(Level.WARNING, "invalid command entered");
            throw new InvalidCommandException();
        }
        assert command != null : "command should not be null";
        return command;
    }

    private static Command getHelpModuleCommand() {
        logger.log(Level.INFO, "help command entered");
        Command command;
        command = new HelpCommand();
        return command;
    }

    private static Command getViewScriptCommand(String line)
            throws InsufficientParametersException, ModuleNotSelectedException {
        Command command;
        try {
            logger.log(Level.INFO, "view script command entered");
            String assignmentSeparator = "/a";
            String studentSeparator = "/s";
            int assignmentIndex = line.indexOf(assignmentSeparator);
            int studentIndex = line.indexOf(studentSeparator);
            String assignmentName = line.substring(assignmentIndex + A_LENGTH, studentIndex - 1);
            String studentName = line.substring(studentIndex + S_LENGTH).trim();
            command = new ViewScriptCommand(currentModule, assignmentName, studentName);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for view answers command");
            throw new InsufficientParametersException();
        }
        return command;
    }
  

    private static Command getAutogradeAssignentCommand(String line)
            throws InsufficientParametersException, ModuleNotSelectedException {
        Command command;
        try {
            logger.log(Level.INFO, "autograde assignment command entered");
            String assignmentSeparator = "/a";
            int assignmentIndex = line.indexOf(assignmentSeparator);
            String assignmentName = line.substring(assignmentIndex + A_LENGTH).trim();
            command = new AutogradeAssignmentCommand(currentModule, assignmentName);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for view script command");
            throw new InsufficientParametersException();
        }
        return command;
    }
    
           
    private static Command getViewAnswersCommand(String line)
            throws InsufficientParametersException, ModuleNotSelectedException {
        Command command;
        try {
            logger.log(Level.INFO, "view assignment answers command entered");
            String assignmentSeparator = "/a";
            int assignmentIndex = line.indexOf(assignmentSeparator);
            String assignmentName = line.substring(assignmentIndex + A_LENGTH).trim();
            command = new ViewAnswersCommand(currentModule, assignmentName);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for view answers command");
            throw new InsufficientParametersException();
        }
        return command;
    }

    private static Command getCurrentModuleCommand() {
        logger.log(Level.INFO, "current command entered");
        Command command = new CurrentModuleCommand();
        return command;
    }

    private static Command getRemoveModuleCommand(String line) {
        logger.log(Level.INFO, "remove module command entered");
        Command command;
        String moduleCode = line.substring(REMOVE_MODULE_LENGTH);
        assert moduleCode.length() != 0 : "moduleCode should not be empty";
        command = new RemoveModuleCommand(moduleCode);
        return command;
    }

    private static Command getSelectModuleCommand(String line) {
        logger.log(Level.INFO, "select module command entered");
        Command command;
        String moduleCode = line.substring(SELECT_LENGTH);
        assert moduleCode.length() != 0 : "moduleCode should not be empty";
        command = new SelectModuleCommand(moduleCode);
        return command;
    }

    private static Command getListModuleCommand() {
        logger.log(Level.INFO, "list module command entered");
        Command command;
        command = new ListModuleCommand();
        return command;
    }

    public static void setCurrentModule(String currentModule) {
        Parser.currentModule = currentModule;
    }

    public static String getCurrentModule() {
        if (currentModule == null) {
            return null;
        } else {
            return currentModule;
        }
    }

    private static Command getEditAssignmentNameCommand(String line) throws InsufficientParametersException {
        Command command;
        try {
            logger.log(Level.INFO, "edit assignment name command entered");
            String oldNameSeparator = "/a";
            String newNameSeparator = "/n";
            int oldNameIndex = line.indexOf(oldNameSeparator);
            int newNameIndex = line.indexOf(newNameSeparator);
            String oldName = line.substring(oldNameIndex + A_LENGTH, newNameIndex - 1);
            String newName = line.substring(newNameIndex + A_LENGTH).trim();
            command = new EditAssignmentNameCommand(currentModule, oldName, newName);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for edit assignment name command");
            throw new InsufficientParametersException();
        }
        return command;
    }


    private static Command getSortAssignmentByDeadlineCommand() throws ModuleNotSelectedException {
        Command command;
        logger.log(Level.INFO, "sort assignments by deadline command entered");
        assert currentModule != null : "currentModule should not be null";
        command = new SortAssignmentByDeadlineCommand(currentModule);
        return command;
    }

    private static Command getSetAssignmentDeadlineCommand(String line) throws InsufficientParametersException,
            DateTimeFormatException, ModuleNotSelectedException {
        Command command;
        try {
            logger.log(Level.INFO, "set deadline command entered");
            String assignmentSeparator = "/a";
            String deadlineSeparator = "/d";
            int assignmentIndex = line.indexOf(assignmentSeparator);
            int deadlineIndex = line.indexOf(deadlineSeparator);
            String assignmentName = line.substring(assignmentIndex + A_LENGTH, deadlineIndex - 1);
            String deadline = line.substring(deadlineIndex + D_LENGTH).trim();
            command = new SetAssignmentDeadlineCommand(currentModule, assignmentName, deadline);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for set assignment deadline command");
            throw new InsufficientParametersException();
        } catch (DateTimeParseException | DateTimeFormatException e) {
            logger.log(Level.WARNING, "Deadline format is wrong.");
            throw new DateTimeFormatException();
        }
        return command;
    }

    private static Command getSetAssignmentCommentsCommand(String line)
            throws InsufficientParametersException, ModuleNotSelectedException {
        Command command;
        try {
            logger.log(Level.INFO, "set comments command entered");
            String assignmentSeparator = "/a";
            String commentSeparator = "/c";
            int assignmentIndex = line.indexOf(assignmentSeparator);
            int commentsIndex = line.indexOf(commentSeparator);
            String assignmentName = line.substring(assignmentIndex + A_LENGTH, commentsIndex - 1);
            String comments = line.substring(commentsIndex + C_LENGTH).trim();
            command = new SetAssignmentCommentsCommand(currentModule, assignmentName, comments);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for set assignment deadline command");
            throw new InsufficientParametersException();
        }
        return command;
    }

    private static Command getGetAssignmentCommentsCommand(String line)
            throws InsufficientParametersException, ModuleNotSelectedException {
        Command command;
        try {
            logger.log(Level.INFO, "set comments command entered");
            String assignmentSeparator = "/a";
            int assignmentIndex = line.indexOf(assignmentSeparator);
            String assignmentName = line.substring(assignmentIndex + A_LENGTH);
            command = new GetAssignmentCommentsCommand(currentModule, assignmentName);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for set assignment deadline command");
            throw new InsufficientParametersException();
        }
        return command;
    }

    private static Command getSetAssignmentGradeCommand(String line)
            throws InsufficientParametersException, ModuleNotSelectedException {
        Command command;
        try {
            logger.log(Level.INFO, "set assignment grade command entered");
            String assignmentSeparator = "/a";
            String studentSeparator = "/s";
            String gradeSeparator = "/g";
            int assignmentIndex = line.indexOf(assignmentSeparator);
            int studentIndex = line.indexOf(studentSeparator);
            int gradeIndex = line.indexOf(gradeSeparator);
            String assignmentName = line.substring(assignmentIndex + A_LENGTH, studentIndex - 1);
            String studentName = line.substring(studentIndex + S_LENGTH, gradeIndex - 1);
            String grade = line.substring(gradeIndex + G_LENGTH).trim();
            command = new SetAssignmentGradeCommand(currentModule, assignmentName, studentName, grade);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for set assignment deadline command");
            throw new InsufficientParametersException();
        }
        return command;
    }

    private static Command getSetAssignmentPercentageCommand(String line) throws InvalidCommandException,
            InvalidPercentageException, ModuleNotSelectedException {
        Command command;
        try {
            logger.log(Level.INFO, "setAssignmentPercentage command entered");
            String assignmentSeparator = "/a";
            String percentageSeparator = "/p";
            int assignmentIndex = line.indexOf(assignmentSeparator);
            int percentageIndex = line.indexOf(percentageSeparator);
            String assignmentName = line.substring(assignmentIndex + A_LENGTH, percentageIndex - 1);
            String percentage = line.substring(percentageIndex + D_LENGTH).trim();
            command = new SetAssignmentPercentageCommand(currentModule, assignmentName, percentage);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for set assignment percentage command");
            throw new InvalidCommandException();
        } catch (NumberFormatException | InvalidPercentageException error) {
            throw error;
        }
        return command;
    }

    private static Command getListStudentDetailsCommand() throws ModuleNotSelectedException {
        Command command;
        logger.log(Level.INFO, "list student details command entered");
        command = new ListStudentsDetailsCommand(currentModule);
        return command;
    }

    private static Command getAddTimetableCommand(String line) throws InsufficientParametersException,
            DayFormatException, ModuleNotSelectedException, TimeFormatException, EmptyTimetableParameterException {
        Command command;
        String typeSeparator = "/t";
        String venueSeparator = "/v";
        String daySeparator = "/d";
        String startSeparator = "/s";
        String endSeparator = "/e";
        try {
            logger.log(Level.INFO, "add timetable command entered");
            int typeIndex = line.indexOf(typeSeparator);
            int venueIndex = line.indexOf(venueSeparator);
            int dayIndex = line.indexOf(daySeparator);
            int startIndex = line.indexOf(startSeparator);
            int endIndex = line.indexOf(endSeparator);
            String type = line.substring(typeIndex + T_LENGTH, venueIndex - 1);
            String venue = line.substring(venueIndex + V_LENGTH, dayIndex - 1);
            String day = line.substring(dayIndex + D_LENGTH, startIndex - 1);
            String start = line.substring(startIndex + S_LENGTH, endIndex - 1);
            String end = (line + " ").substring(endIndex + E_LENGTH).trim();
            command = new AddTimetableCommand(currentModule, type, venue, day, start, end);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for set assignment deadline command");
            throw new InsufficientParametersException();
        } catch (DateTimeParseException e) {
            logger.log(Level.WARNING, "Start/End time format is wrong.");
            throw new TimeFormatException();
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING, "Day format is wrong.");
            throw new DayFormatException();
        } catch (ModuleNotSelectedException e) {
            logger.log(Level.WARNING, "module directory not selected.");
            throw new ModuleNotSelectedException();
        } catch (EmptyTimetableParameterException e) {
            throw e;
        }
        return command;
    }

    private static Command getListModuleTimetableCommand() throws ModuleNotSelectedException {
        Command command;
        try {
            logger.log(Level.INFO, "list timetable command entered");
            command = new ListModuleTimetableCommand(currentModule);
        } catch (ModuleNotSelectedException e) {
            logger.log(Level.WARNING, "module directory not selected");
            throw new ModuleNotSelectedException();
        }
        return command;
    }

    private static Command getEditModuleTimetableCommand(String line) throws InsufficientParametersException,
            IndexNotFoundException, ModuleNotSelectedException {
        Command command;
        String typeSeparator = "/t";
        String venueSeparator = "/v";
        String daySeparator = "/d";
        String startSeparator = "/s";
        String endSeparator = "/e";
        try {
            logger.log(Level.INFO, "edit timetable command entered");
            int typeIndex = line.indexOf(typeSeparator);
            int venueIndex = line.indexOf(venueSeparator);
            int dayIndex = line.indexOf(daySeparator);
            int startIndex = line.indexOf(startSeparator);
            int endIndex = line.indexOf(endSeparator);
            String lessonIndex = line.substring(EDIT_TIMETABLE_LENGTH, typeIndex - 1);
            String type = line.substring(typeIndex + T_LENGTH, venueIndex - 1);
            String venue = line.substring(venueIndex + V_LENGTH, dayIndex - 1);
            String day = line.substring(dayIndex + D_LENGTH, startIndex - 1);
            String start = line.substring(startIndex + S_LENGTH, endIndex - 1);
            String end = (line + " ").substring(endIndex + E_LENGTH).trim();
            command = new EditModuleTimetableCommand(lessonIndex, currentModule, type, venue, day, start, end);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for edit timetable command");
            throw new InsufficientParametersException();
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, "lesson index not found");
            throw new IndexNotFoundException();
        }
        return command;
    }

    private static Command getDeleteModuleTimetableCommand(String line)
            throws IndexNotFoundException, ModuleNotSelectedException {
        Command command;
        try {
            logger.log(Level.INFO, "delete timetable command entered");
            String lessonIndex = line.substring(DELETE_TIMETABLE_LENGTH);
            int lessonIndexAsNumber = Integer.parseInt(lessonIndex) - 1;
            command = new DeleteModuleTimetableCommand(lessonIndexAsNumber, currentModule);
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, "Lesson index wrong format.");
            throw new IndexNotFoundException();
        }
        return command;
    }

    private static Command getListStudentCommand() throws ModuleNotSelectedException {
        Command command;
        logger.log(Level.INFO, "list student command entered");
        command = new ListModuleStudentsCommand(currentModule);
        return command;
    }

    private static Command getAddStudentCommand(String line) throws InsufficientParametersException,
            ModuleNotSelectedException {
        Command command;
        try {
            logger.log(Level.INFO, "add student command entered");
            String nameSeparator = "/s";
            String numberSeparator = "/#";
            String emailSeparator = "/e";
            int nameIndex = line.indexOf(nameSeparator);
            int numberIndex = line.indexOf(numberSeparator);
            int emailIndex = line.indexOf(emailSeparator);
            String studentName = line.substring(nameIndex + S_LENGTH, numberIndex - 1);
            String studentNumber = line.substring(numberIndex + HASH_LENGTH, emailIndex - 1);
            String email = line.substring(emailIndex + E_LENGTH).trim();
            command = new AddStudentCommand(currentModule, studentName, studentNumber, email);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for add student command");
            throw new InsufficientParametersException();
        } catch (ModuleNotSelectedException e) {
            logger.log(Level.WARNING, "module directory not selected");
            throw new ModuleNotSelectedException();
        }
        return command;
    }

    private static Command getListModuleAssignmentCommand() throws ModuleNotSelectedException {
        Command command;
        logger.log(Level.INFO, "list assignment command entered");
        command = new ListModuleAssignmentsCommand(currentModule);
        return command;
    }

    private static Command getAddAssignmentCommand(String line) throws InvalidCommandException,
            InsufficientParametersException, ModuleNotSelectedException {
        Command command;
        try {
            logger.log(Level.INFO, "add assignment command entered");
            String assignmentTypeSeparator = "/t";
            String assignmentSeparator = "/a";
            int assignmentTypeIndex = line.indexOf(assignmentTypeSeparator);
            int assignmentIndex = line.indexOf(assignmentSeparator);
            String assignmentType = line.substring(assignmentTypeIndex + T_LENGTH, assignmentIndex - 1).trim();
            String assignmentName = line.substring(assignmentIndex + A_LENGTH).trim();
            command = new AddAssignmentCommand(assignmentType, currentModule, assignmentName);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for add assignment command");
            throw new InsufficientParametersException();
        }
        return command;
    }

    private static Command getListStudentAssignmentGradesCommand(String line)
            throws InsufficientParametersException, ModuleNotSelectedException {
        Command command;
        try {
            logger.log(Level.INFO, "list student assignment grades command entered");
            String assignmentSeparator = "/a";
            int assignmentIndex = line.indexOf(assignmentSeparator);
            String assignmentName = line.substring(assignmentIndex + A_LENGTH).trim();
            command = new ListStudentGradesForAssignmentCommand(currentModule, assignmentName);
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "not enough parameters for add assignment command");
            throw new InsufficientParametersException();
        }
        return command;
    }

    private static Command getAddModuleCommand(String line) throws InsufficientParametersException {
        Command command;
        logger.log(Level.INFO, "add module command entered");
        String moduleCode = line.substring(ADD_MODULE_LENGTH);
        if (moduleCode.equals("")) {
            logger.log(Level.WARNING, "not enough parameters for add module command");
            throw new InsufficientParametersException();
        }
        command = new AddModuleCommand(moduleCode);
        assert moduleCode.length() != 0 : "moduleCode should not be empty";
        return command;
    }
}

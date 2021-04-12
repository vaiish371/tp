package seedu.duke.command;

import seedu.duke.data.lesson.Day;
import seedu.duke.data.lesson.Lesson;
import seedu.duke.data.module.Module;
import seedu.duke.exception.DuplicateLessonException;
import seedu.duke.exception.EmptyParameterException;
import seedu.duke.exception.InvalidStartTimeException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

/**
 * Command for adding timetable to a module.
 */
public class AddTimetableCommand extends Command {
    private final String moduleCode;
    private final Day day;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String venue;
    private final String lessonType;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
    private static final Logger logger = Logger.getLogger("AddTimetableCommand");

    /**
     * Constructor for adding timetable to a module.
     * @param moduleCode module code of the module that the timetable belongs to
     * @param lessonType type of lesson
     * @param venue venue of lesson
     * @param day day of lesson
     * @param startTime start time of lesson
     * @param endTime end time of lesson
     * @throws DateTimeParseException if the date input by the user cannot be parsed as a LocalDate object
     * @throws ModuleNotSelectedException if the user has not selected a module yet
     * @throws EmptyParameterException if any parameters provided by the user is empty (0 or null)
     */
    public AddTimetableCommand(String moduleCode, String lessonType, String venue, String day, String startTime,
                               String endTime) throws DateTimeParseException, ModuleNotSelectedException,
            EmptyParameterException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        if (lessonType.trim().length() == 0) {
            throw new EmptyParameterException();
        }
        if (venue.trim().length() == 0) {
            throw new EmptyParameterException();
        }
        if (day.trim().length() == 0) {
            throw new EmptyParameterException();
        }
        if (startTime.trim().length() == 0) {
            throw new EmptyParameterException();
        }
        if (endTime.trim().length() == 0) {
            throw new EmptyParameterException();
        }
        this.moduleCode = moduleCode;
        this.day = Day.valueOf(day.trim());
        this.startTime = LocalTime.parse(startTime.trim(), formatter);
        this.endTime = LocalTime.parse(endTime.trim(), formatter);
        this.venue = venue.trim();
        this.lessonType = lessonType.trim();
    }

    /**
     * Execute function for add timetable command.
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModuleNotFoundException if the module cannot be found in the database
     * @throws InvalidStartTimeException if the start time by the user is invalid
     * @throws DuplicateLessonException if the lesson to be added already exists
     */
    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException, InvalidStartTimeException,
            DuplicateLessonException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
            throw new InvalidStartTimeException();
        }

        assert module != null : "module should not be null";
        Lesson lesson = new Lesson(day.toString(), startTime, endTime, venue, lessonType);
        for (Lesson moduleLesson : module.getLessons()) {
            if (moduleLesson.equals(lesson)) {
                throw new DuplicateLessonException();
            }
        }
        module.addLesson(lesson);
        ui.printNewTimetable(moduleCode, lesson);
    }
}

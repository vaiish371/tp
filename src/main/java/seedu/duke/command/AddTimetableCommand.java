package seedu.duke.command;

import seedu.duke.data.lesson.Day;
import seedu.duke.data.lesson.Lesson;
import seedu.duke.data.module.Module;
import seedu.duke.exception.EmptyTimetableParameterException;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.InvalidStartTimeException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.ui.Ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

public class AddTimetableCommand extends Command {
    private final String moduleCode;
    private final Day day;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String venue;
    private final String lessonType;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
    private static final Logger logger = Logger.getLogger("AddTimetableCommand");

    public AddTimetableCommand(String moduleCode, String lessonType, String venue, String day, String startTime,
                               String endTime) throws DateTimeParseException, ModuleNotSelectedException,
            EmptyTimetableParameterException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        if (lessonType.trim().length() == 0) {
            throw new EmptyTimetableParameterException();
        }
        if (venue.trim().length() == 0) {
            throw new EmptyTimetableParameterException();
        }
        if (day.trim().length() == 0) {
            throw new EmptyTimetableParameterException();
        }
        if (startTime.trim().length() == 0) {
            throw new EmptyTimetableParameterException();
        }
        if (endTime.trim().length() == 0) {
            throw new EmptyTimetableParameterException();
        }
        this.moduleCode = moduleCode;
        this.day = Day.valueOf(day.trim());
        this.startTime = LocalTime.parse(startTime.trim(), formatter);
        this.endTime = LocalTime.parse(endTime.trim(), formatter);
        this.venue = venue.trim();
        this.lessonType = lessonType.trim();
    }

    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException, InvalidStartTimeException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
            throw new InvalidStartTimeException();
        }
        assert module != null : "module should not be null";
        Lesson lesson = new Lesson(day.toString(), startTime, endTime, venue, lessonType);
        module.addLesson(lesson);
        ui.printNewTimetable(moduleCode, lesson);
    }
}

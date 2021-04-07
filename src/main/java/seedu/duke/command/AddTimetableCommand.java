package seedu.duke.command;

import seedu.duke.Day;
import seedu.duke.Lesson;
import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.InvalidStartTimeException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.ui.Ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
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

    public AddTimetableCommand(String moduleCode, String lessonType, String venue,
                               Day day, String startTime, String endTime) throws DateTimeParseException {
        logger.log(Level.INFO, "start initialising AddTimeTableCommand");
        this.moduleCode = moduleCode;
        this.day = day;
        this.startTime = LocalTime.parse(startTime, formatter);
        this.endTime = LocalTime.parse(endTime, formatter);
        this.venue = venue;
        this.lessonType = lessonType;
        logger.log(Level.INFO, "AddTimeTableCommand initialised");
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

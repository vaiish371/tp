package seedu.duke.command;

import seedu.duke.data.lesson.Day;
import seedu.duke.data.lesson.Lesson;
import seedu.duke.data.module.Module;
import seedu.duke.exception.DateTimeFormatException;
import seedu.duke.exception.DayFormatException;
import seedu.duke.exception.EmptyTimetableParameterException;
import seedu.duke.exception.IndexNotFoundException;
import seedu.duke.exception.InvalidStartTimeException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.exception.TimeFormatException;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditModuleTimetableCommand extends Command {
    private final int lessonIndex;
    private final String moduleCode;
    private final String day;
    private final String startTime;
    private final String endTime;
    private final String venue;
    private final String lessonType;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
    private static final Logger logger = Logger.getLogger(Parser.class.getName());

    public EditModuleTimetableCommand(String lessonIndex, String moduleCode, String lessonType, String venue,
                               String day, String startTime, String endTime) throws NumberFormatException,
            ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.lessonIndex = Integer.parseInt(lessonIndex) - 1;
        this.moduleCode = moduleCode;
        this.day = day.trim();
        this.startTime = startTime.trim();
        this.endTime = endTime.trim();
        this.venue = venue.trim();
        this.lessonType = lessonType.trim();
    }

    @Override
    public void execute(Data data, Ui ui, Storage storage) throws IndexNotFoundException, DateTimeFormatException,
            ModuleNotFoundException, EmptyTimetableParameterException, DayFormatException, InvalidStartTimeException,
            TimeFormatException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";

        try {
            ArrayList<Lesson> lessons = module.getLessons();
            Lesson lesson = lessons.get(lessonIndex);
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
            if (!lessonType.equals("-")) {
                lesson.setLessonType(lessonType);
            }
            if (!venue.equals("-")) {
                lesson.setVenue(venue);
            }
            if (!day.equals("-")) {
                lesson.setDay(Day.valueOf(day));
            }
            if (!startTime.equals("-")) {
                lesson.setStartTime(LocalTime.parse(startTime, formatter));
            }
            if (!endTime.equals("-")) {
                lesson.setEndTime(LocalTime.parse(endTime, formatter));
            }
            ui.editModuleTimetable(moduleCode, lesson);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            logger.log(Level.WARNING, "lesson index not found or no lessons added yet");
            throw new IndexNotFoundException();
        } catch (DateTimeParseException error) {
            logger.log(Level.WARNING, "Start/End date format wrong");
            throw new TimeFormatException();
        } catch (EmptyTimetableParameterException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw new DayFormatException();
        } catch (InvalidStartTimeException e) {
            throw e;
        }
    }
}

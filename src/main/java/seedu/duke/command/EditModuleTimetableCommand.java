package seedu.duke.command;

import seedu.duke.data.lesson.Day;
import seedu.duke.data.lesson.Lesson;
import seedu.duke.data.module.Module;
import seedu.duke.exception.*;
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
            ModuleNotFoundException, EmptyParameterException, DayFormatException, InvalidStartTimeException,
            TimeFormatException, DuplicateLessonException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";

        try {
            ArrayList<Lesson> lessons = module.getLessons();
            Lesson lesson = lessons.get(lessonIndex);
            Lesson duplicateLesson = new Lesson(lesson);
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
            if (!lessonType.equals("-")) {
                duplicateLesson.setLessonType(lessonType);
            }
            if (!venue.equals("-")) {
                duplicateLesson.setVenue(venue);
            }
            if (!day.equals("-")) {
                duplicateLesson.setDay(Day.valueOf(day));
            }
            if (!startTime.equals("-")) {
                duplicateLesson.setStartTime(LocalTime.parse(startTime, formatter));
            }
            if (!endTime.equals("-")) {
                duplicateLesson.setEndTime(LocalTime.parse(endTime, formatter));
            }
            for (Lesson moduleLesson : module.getLessons()) {
                if (moduleLesson.equals(duplicateLesson)) {
                    throw new DuplicateLessonException();
                }
            }
            lesson.setDay(duplicateLesson.getDay());
            lesson.setStartTime(duplicateLesson.getStartTime());
            lesson.setEndTime(duplicateLesson.getEndTime());
            lesson.setVenue(duplicateLesson.getVenue());
            lesson.setLessonType(duplicateLesson.getLessonType());
            ui.editModuleTimetable(moduleCode, lesson);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            logger.log(Level.WARNING, "lesson index not found or no lessons added yet");
            throw new IndexNotFoundException();
        } catch (DateTimeParseException error) {
            logger.log(Level.WARNING, "Start/End date format wrong");
            throw new TimeFormatException();
        } catch (EmptyParameterException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw new DayFormatException();
        } catch (InvalidStartTimeException e) {
            throw e;
        } catch (DuplicateLessonException e) {
            throw e;
        }
    }
}

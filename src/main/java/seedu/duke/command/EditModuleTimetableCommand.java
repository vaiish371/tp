package seedu.duke.command;

import seedu.duke.Lesson;
import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.DateTimeFormatException;
import seedu.duke.exception.IndexNotFoundException;
import seedu.duke.exception.ModManException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.ui.Ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class EditModuleTimetableCommand extends Command {
    private final int lessonIndex;
    private final String moduleCode;
    private final String day;
    private final String startTime;
    private final String endTime;
    private final String venue;
    private final String lessonType;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");

    public EditModuleTimetableCommand(String lessonIndex, String moduleCode, String lessonType, String venue,
                               String day, String startTime, String endTime) throws NumberFormatException {
        this.lessonIndex = Integer.parseInt(lessonIndex) - 1;
        this.moduleCode = moduleCode;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.venue = venue;
        this.lessonType = lessonType;
    }

    @Override
    public void execute(Data data, Ui ui, Storage storage) throws IndexNotFoundException, DateTimeFormatException,
            ModuleNotFoundException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";

        try {
            ArrayList<Lesson> lessons = module.getLessons();
            Lesson lesson = lessons.get(lessonIndex);
            if (!lessonType.equals("-")) {
                lesson.setLessonType(lessonType);
            }
            if (!venue.equals("-")) {
                lesson.setVenue(venue);
            }
            if (!day.equals("-")) {
                lesson.setDay(day);
            }
            if (!startTime.equals("-")) {
                lesson.setStartTime(LocalTime.parse(startTime, formatter));
            }
            if (!endTime.equals("-")) {
                lesson.setEndTime(LocalTime.parse(endTime, formatter));
            }
            ui.editModuleTimetable(moduleCode, lesson);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            throw new IndexNotFoundException();
        } catch (DateTimeParseException error) {
            throw new DateTimeFormatException();
        }
    }
}

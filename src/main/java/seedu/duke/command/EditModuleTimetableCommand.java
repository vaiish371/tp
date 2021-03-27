package seedu.duke.command;

import seedu.duke.Lesson;
import seedu.duke.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.IndexNotFoundException;
import seedu.duke.exception.ModManException;
import seedu.duke.ui.Ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
                               String day, String startTime, String endTime) {
        this.lessonIndex = Integer.parseInt(lessonIndex) - 1;
        this.moduleCode = moduleCode;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.venue = venue;
        this.lessonType = lessonType;
    }

    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModManException {
        ArrayList<Lesson> lessons = data.find(moduleCode).getLessons();
        try {
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
        } catch (IndexOutOfBoundsException e) {
            throw new IndexNotFoundException();
        }
    }
}

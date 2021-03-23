package seedu.duke.command;

import seedu.duke.Lesson;
import seedu.duke.data.Data;
import seedu.duke.exception.IndexNotFoundException;
import seedu.duke.exception.ModManException;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class DeleteModuleTimetableCommand extends Command {
    private final int lessonIndex;
    private final String moduleCode;

    public DeleteModuleTimetableCommand(String lessonIndex, String moduleCode) {
        this.lessonIndex = Integer.parseInt(lessonIndex) - 1;
        this.moduleCode = moduleCode;
    }

    @Override
    public void execute(Data data, Ui ui) throws ModManException {
        ArrayList<Lesson> lessons = data.find(moduleCode).getLessons();
        try {
            Lesson lesson = lessons.get(lessonIndex);
            lessons.remove(lessonIndex);
            ui.deleteModuleTimetable(moduleCode, lesson);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexNotFoundException();
        }
    }
}

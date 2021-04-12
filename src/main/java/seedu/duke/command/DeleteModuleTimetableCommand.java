package seedu.duke.command;

import seedu.duke.data.lesson.Lesson;
import seedu.duke.data.module.Module;
import seedu.duke.exception.AnswerTooLongException;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.FileFormatException;
import seedu.duke.exception.InvalidQuestionNumberException;
import seedu.duke.exception.NumbersMisalignException;
import seedu.duke.exception.StudentNotFoundException;
import seedu.duke.storage.Storage;
import seedu.duke.data.Data;
import seedu.duke.exception.LessonNotFoundException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.logging.Logger;

public class DeleteModuleTimetableCommand extends Command {
    private final int lessonIndex;
    private final String moduleCode;
    private static final Logger logger = Logger.getLogger(Parser.class.getName());

    /**
     * Constructor for DeleteModuleTimetableCommand Class.
     *
     * @param lessonIndex int specifying index of lesson to be removed.
     * @param moduleCode current module.
     * @throws ModuleNotSelectedException Thrown when user is not currently working in any module.
     */
    public DeleteModuleTimetableCommand(int lessonIndex, String moduleCode) throws ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.lessonIndex = lessonIndex;
        this.moduleCode = moduleCode;
    }

    /**
     * Deletes a lesson from the current module.
     * Prints output confirming deletion to user.
     *
     * @param data keeps track of module information.
     * @param ui prints messages to the console.
     * @param storage saves and retrieves information from database.
     * @throws ModuleNotFoundException Thrown when module is not found.
     * @throws LessonNotFoundException Thrown when lesson is not found.
     */
    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException, LessonNotFoundException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException("Module directory not selected.");
        }
        assert module != null : "module should not be null";
        ArrayList<Lesson> lessons = data.find(moduleCode).getLessons();
        try {
            Lesson lesson = lessons.get(lessonIndex);
            lessons.remove(lessonIndex);
            ui.deleteModuleTimetable(moduleCode, lesson);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            throw new LessonNotFoundException();
        }
    }
}

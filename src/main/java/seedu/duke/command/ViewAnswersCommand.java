package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.exception.AnswerTooLongException;
import seedu.duke.exception.InvalidQuestionNumberException;
import seedu.duke.exception.MarkTooLargeException;
import seedu.duke.exception.MissingAnswerException;
import seedu.duke.exception.MissingMarksException;
import seedu.duke.storage.Storage;
import seedu.duke.data.assignment.Answer;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.FileFormatException;
import seedu.duke.exception.InvalidMcqOption;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.NumbersMisalignException;
import seedu.duke.ui.Ui;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewAnswersCommand extends Command {

    private String moduleCode;
    private String assignmentName;
    private static Logger logger = Logger.getLogger(ViewAnswersCommand.class.getName());

    /**
     * Constructor for ViewAnswersCommand Class.
     *
     * @param moduleCode current module
     * @param assignmentName name of assignment
     */
    public ViewAnswersCommand(String moduleCode, String assignmentName) {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName.trim();
    }

    /**
     * Retrieves answer key from the answers directory and displays it on the console.
     *
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModuleNotFoundException module not found
     * @throws AssignmentNotFoundException assignment not found
     * @throws DataFileNotFoundException answer key not found
     * @throws NumbersMisalignException question numbers do not match
     * @throws FileFormatException wrong format in answer key
     * @throws InvalidMcqOption mcq assignment has invalid options
     * @throws InvalidQuestionNumberException question number not integer
     * @throws MarkTooLargeException marks too large
     * @throws MissingAnswerException answer missing
     * @throws AnswerTooLongException answer more than 100 characters
     * @throws MissingMarksException marks missing
     */
    @Override
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException,
            AssignmentNotFoundException, DataFileNotFoundException, NumbersMisalignException, FileFormatException,
            InvalidMcqOption, InvalidQuestionNumberException, MarkTooLargeException, MissingAnswerException,
            AnswerTooLongException, MissingMarksException {
        Module module = data.find(moduleCode);
        if (module == null) {
            logger.log(Level.WARNING, "module not found in the list");
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";
        Assignment assignment = module.findAssignment(assignmentName);
        if (assignment == null) {
            logger.log(Level.WARNING, "assignment not found in the list");
            throw new AssignmentNotFoundException();
        }
        assert assignment != null : "assignment should not be null";
        Answer answer = storage.loadAnswer(assignmentName, moduleCode);
        assignment.setAnswers(answer);
        ui.printAnswers(answer, assignmentName);
    }

}

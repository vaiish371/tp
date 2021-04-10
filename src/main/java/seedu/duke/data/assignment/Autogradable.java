package seedu.duke.data.assignment;

import seedu.duke.exception.AnswerTooLongException;
import seedu.duke.exception.InvalidQuestionNumberException;
import seedu.duke.storage.Storage;
import seedu.duke.data.student.Student;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.FileFormatException;
import seedu.duke.exception.InvalidPercentageException;
import seedu.duke.exception.NumbersMisalignException;

import java.util.ArrayList;

public interface Autogradable {

    void autogradeAssignment(ArrayList<Student> students, String moduleCode, Storage storage)
            throws DataFileNotFoundException, NumbersMisalignException, FileFormatException, 
            InvalidPercentageException, InvalidQuestionNumberException, AnswerTooLongException;
}

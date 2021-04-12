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

    /**
     * Grades all the students' scripts found in the scripts directory and sets the grade of each student.
     *
     * @param students ArrayList of students enrolled in the module
     * @param moduleCode String current module
     * @param storage Storage object to retrieve students' scripts
     *
     * @throws DataFileNotFoundException student script not found
     * @throws NumbersMisalignException number of questions in answer and script do not match
     * @throws FileFormatException wrong format in student script
     * @throws InvalidPercentageException percentage not in the range 0 to 100
     * @throws InvalidQuestionNumberException question number not integers in sequence
     * @throws AnswerTooLongException answer exceed 100 characters
     */
    void autogradeAssignment(ArrayList<Student> students, String moduleCode, Storage storage)
            throws DataFileNotFoundException, NumbersMisalignException, FileFormatException, 
            InvalidPercentageException, InvalidQuestionNumberException, AnswerTooLongException;
}

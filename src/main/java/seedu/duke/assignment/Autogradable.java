package seedu.duke.assignment;

import seedu.duke.Storage;
import seedu.duke.Student;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.NumbersMisalignException;

import java.util.ArrayList;

public interface Autogradable {

    void autogradeAssignment(ArrayList<Student> students, String moduleCode, Storage storage)
            throws DataFileNotFoundException, NumbersMisalignException;

}

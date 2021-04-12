package seedu.duke.command;

import seedu.duke.data.module.Module;
import seedu.duke.exception.DuplicateStudentException;
import seedu.duke.exception.EmptyParameterException;
import seedu.duke.storage.Storage;
import seedu.duke.data.student.Student;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.ui.Ui;

/**
 * Class for adding a student into the database
 */
public class AddStudentCommand extends Command {
    public String moduleCode;
    public String studentName;
    public String studentNumber;
    public String email;

    /**
     * Constructor for adding a student into the database
     * @param moduleCode module code of the module the student belongs to
     * @param studentName name of the student
     * @param studentNumber student number of the student
     * @param email email address of the student
     * @throws ModuleNotSelectedException if the user has not selected any module yet
     * @throws EmptyParameterException if any of the parameters are empty (null or 0)
     */
    public AddStudentCommand(String moduleCode, String studentName,
                             String studentNumber, String email) throws ModuleNotSelectedException,
            EmptyParameterException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.moduleCode = moduleCode;
        this.studentName = studentName.trim();
        this.studentNumber = studentNumber.trim();
        this.email = email.trim();
        if (this.studentName.length() == 0) {
            throw new EmptyParameterException();
        }
        if (this.studentNumber.length() == 0) {
            throw new EmptyParameterException();
        }
        if (this.email.length() == 0) {
            throw new EmptyParameterException();
        }
    }

    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException, DuplicateStudentException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        for (Student student : module.getStudents()) {
            if (student.getStudentNumber().equals(studentNumber) || student.getName().equals(studentName)
                    || student.getEmail().equals(email)) {
                throw new DuplicateStudentException();
            }
        }
        Student student = new Student(studentName, studentNumber, email);
        module.addStudent(student);
        ui.printNewStudent(module, student);
    }
}

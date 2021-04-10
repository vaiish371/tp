package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.Student;
import seedu.duke.data.Data;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.ui.Ui;

public class AddStudentCommand extends Command {
    public String moduleCode;
    public String studentName;
    public String studentNumber;
    public String email;

    public AddStudentCommand(String moduleCode, String studentName,
                             String studentNumber, String email) throws ModuleNotSelectedException {
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        this.moduleCode = moduleCode;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.email = email;
    }

    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        Student student = new Student(studentName, studentNumber, email);
        module.addStudent(student);
        ui.printNewStudent(module, student);
    }
}

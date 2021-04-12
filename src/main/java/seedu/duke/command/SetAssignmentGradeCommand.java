package seedu.duke.command;

import seedu.duke.storage.Storage;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.module.Module;
import seedu.duke.data.student.Student;
import seedu.duke.data.Data;
import seedu.duke.exception.AssignmentNotFoundException;
import seedu.duke.exception.InvalidPercentageException;
import seedu.duke.exception.ModuleNotFoundException;
import seedu.duke.exception.ModuleNotSelectedException;
import seedu.duke.exception.StudentNotFoundException;
import seedu.duke.exception.EmptyParameterException;
import seedu.duke.ui.Ui;

public class SetAssignmentGradeCommand extends Command {
    public String moduleCode;
    public String assignmentName;
    public String studentName;
    public String grade;

    /**
     * Constructor for SetAssignmentGradeCommand Class.
     *
     * @param moduleCode current module
     * @param assignmentName name of assignment
     * @param studentName name of student
     * @param grade grade for that assignment
     * @throws ModuleNotSelectedException not working in any module
     * @throws EmptyParameterException insufficient parameters
     */
    public SetAssignmentGradeCommand(String moduleCode, String assignmentName, String studentName,
                                     String grade) throws ModuleNotSelectedException, EmptyParameterException {
        this.moduleCode = moduleCode;
        this.assignmentName = assignmentName.trim();
        this.studentName = studentName.trim();
        this.grade = grade.trim();
        if (moduleCode == null) {
            throw new ModuleNotSelectedException();
        }
        if (grade.length() == 0) {
            throw new EmptyParameterException();
        }
    }

    /**
     * Sets the grade a student received for an assigment.
     *
     * @param data keeps track of module information
     * @param ui prints messages to the console
     * @param storage saves and retrieves information from database
     * @throws ModuleNotFoundException module not found
     * @throws AssignmentNotFoundException assignment not found
     * @throws StudentNotFoundException student not found
     * @throws InvalidPercentageException invalid grade percentage
     */
    public void execute(Data data, Ui ui, Storage storage) throws ModuleNotFoundException,
            AssignmentNotFoundException, StudentNotFoundException, InvalidPercentageException {
        Module module = data.find(moduleCode);
        if (module == null) {
            throw new ModuleNotFoundException();
        }
        assert module != null : "module should not be null";
        Assignment assignment = module.findAssignment(assignmentName);
        if (assignment == null) {
            throw new AssignmentNotFoundException();
        }
        assert assignment != null : "assignment should not be null";
        Student student = module.findStudent(studentName);
        if (student == null) {
            throw new StudentNotFoundException();
        }
        assignment.setStudentGrade(student, grade);
        ui.printSetAssignmentGrade(moduleCode, assignmentName, studentName, grade);
    }
}

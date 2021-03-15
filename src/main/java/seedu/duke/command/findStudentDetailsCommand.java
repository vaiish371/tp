package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.Student;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

import java.util.ArrayList;


public class findStudentDetailsCommand extends Command{

    public String studentName;
    public String moduleCode;

    public findStudentDetailsCommand (String studentName, String moduleCode) {
        this.studentName = studentName;
        this.moduleCode = moduleCode;
    }

    public void execute (Data data, Ui ui){
        Module module = data.find(moduleCode);
        ui.findStudentDetails(module, studentName);
    }
}

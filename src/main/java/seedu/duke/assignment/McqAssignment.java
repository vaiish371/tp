package seedu.duke.assignment;

import seedu.duke.Storage;
import seedu.duke.Student;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.NumbersMisalignException;

import java.util.ArrayList;

public class McqAssignment extends Assignment implements Autogradable {

    private Answer answer;

    public McqAssignment(String name) {
        super(name);
    }

    public void setAnswers(Answer answer) {
        this.answer = answer;
    }

    public Answer getAnswers() {
        return this.answer;
    }

    public int getTotalMarks() {
        ArrayList<Integer> marks = answer.getMarks();
        int total = 0;
        for (Integer mark : marks) {
            total += mark.intValue();
        }
        return total;
    }

    public void autogradeAssignment(ArrayList<Student> students, String moduleCode, Storage storage)
            throws DataFileNotFoundException, NumbersMisalignException {
        int score = 0;
        for (Student student : students) {
            String studentNumber = student.getStudentNumber();
            if (!storage.findStudentScript(name, moduleCode, studentNumber)) {
                continue;
            } else {
                ArrayList<String> script = storage.loadScript(name, moduleCode, studentNumber);
                score = answer.compareScript(script);
            }
            int total = getTotalMarks();
            float grade = (float)score * (float)100 / (float)total;
            setStudentGrade(student, grade);
        }
    }
}

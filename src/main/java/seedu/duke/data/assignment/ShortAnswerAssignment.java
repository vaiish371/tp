package seedu.duke.data.assignment;

import seedu.duke.storage.Storage;
import seedu.duke.data.student.Student;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.FileFormatException;
import seedu.duke.exception.InvalidPercentageException;
import seedu.duke.exception.NumbersMisalignException;

import java.util.ArrayList;

public class ShortAnswerAssignment extends Assignment implements Autogradable {

    private Answer answer;

    public ShortAnswerAssignment(String name) {
        super(name);
        this.typeOfAssignment = "ShortAnswerAssignment";
    }

    @Override
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
            throws DataFileNotFoundException, NumbersMisalignException, FileFormatException,
            InvalidPercentageException {
        int score = 0;
        for (Student student : students) {
            String studentNumber = student.getStudentNumber();
            if (!storage.findStudentScript(name, moduleCode, studentNumber)) {
                continue;
            } else {
                ArrayList<String> script = storage.loadScript(name, moduleCode, studentNumber);
                if (script.size() != this.answer.getNumberOfQuestions()) {
                    throw new NumbersMisalignException();
                }
                score = answer.compareScript(script);
            }
            int total = getTotalMarks();
            float grade = (float)score / (float)total;
            setStudentGrade(student, grade);
        }
    }
}

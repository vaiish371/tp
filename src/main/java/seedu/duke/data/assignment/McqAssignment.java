package seedu.duke.data.assignment;

import seedu.duke.exception.AnswerTooLongException;
import seedu.duke.exception.InvalidQuestionNumberException;
import seedu.duke.storage.Storage;
import seedu.duke.data.student.Student;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.FileFormatException;
import seedu.duke.exception.InvalidMcqOption;
import seedu.duke.exception.InvalidPercentageException;
import seedu.duke.exception.NumbersMisalignException;

import java.util.ArrayList;

public class McqAssignment extends Assignment implements Autogradable {

    private Answer answer;

    public McqAssignment(String name) {
        super(name);
        this.typeOfAssignment = "McqAssignment";
    }

    public void setAnswers(Answer answer) throws InvalidMcqOption {
        ArrayList<String> answersArray = answer.getAnswers();
        for (String ans : answersArray) {
            if (!ans.equals("A") && !ans.equals("B") && !ans.equals("C") && !ans.equals("D") && !ans.equals("E")
                    && !ans.equals("1") && !ans.equals("2") && !ans.equals("3")
                    && !ans.equals("4") && !ans.equals("5")) {
                throw new InvalidMcqOption();
            }
        }
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
            InvalidPercentageException, InvalidQuestionNumberException, AnswerTooLongException {
        int score = 0;
        for (Student student : students) {
            String studentNumber = student.getStudentNumber();
            if (!storage.findStudentScript(name, moduleCode, studentNumber)) {
                continue;
            } else {
                ArrayList<String> script = storage.loadScript(name, moduleCode, studentNumber);
                if (script.size() != this.answer.getNumberOfQuestions()) {
                    throw new NumbersMisalignException(studentNumber);
                }
                score = answer.compareScript(script);
            }
            int total = getTotalMarks();
            float grade = (float)score * (float)100 / (float)total;
            setStudentGrade(student, grade);
        }
    }
}

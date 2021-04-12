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

public class ShortAnswerAssignment extends Assignment implements Autogradable {

    private Answer answer;

    /**
     * Constructor for ShortAnswerAssignment Class.
     *
     * @param name name of assignment
     */
    public ShortAnswerAssignment(String name) {
        super(name);
        this.typeOfAssignment = "ShortAnswerAssignment";
    }

    /**
     * Sets the answer for the assignment.
     *
     * @param answer answer for the assignment
     */
    @Override
    public void setAnswers(Answer answer) {
        this.answer = answer;
    }

    /**
     * Returns the answer key for the assignment.
     *
     * @return answer key for the assignment
     */
    public Answer getAnswers() {
        return this.answer;
    }

    /**
     * Returns the maximum attainable score for the assignment.
     *
     * @return maximum score for assignment
     */
    public int getTotalMarks() {
        ArrayList<Integer> marks = answer.getMarks();
        int total = 0;
        for (Integer mark : marks) {
            total += mark.intValue();
        }
        return total;
    }

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
            float grade = (float)score / (float)total;
            setStudentGrade(student, grade);
        }
    }
}

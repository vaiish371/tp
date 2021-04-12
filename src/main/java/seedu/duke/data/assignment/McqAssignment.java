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

    /**
     * Constructor for McqAssignment Class.
     *
     * @param name name of assignment
     */
    public McqAssignment(String name) {
        super(name);
        this.typeOfAssignment = "McqAssignment";
    }

    /**
     * Sets the answer for the assignment.
     *
     * @param answer answer for the assignment
     *
     * @throws InvalidMcqOption answer for MCQ assignment not within A to E or 1 to 5
     */
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
            float grade = (float)score * (float)100 / (float)total;
            setStudentGrade(student, grade);
        }
    }
}

package seedu.duke.data.assignment;

import org.junit.jupiter.api.Test;
import seedu.duke.exception.InvalidMcqOption;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class McqAssignmentTest {

    @Test
    void testSetAnswer_ValidOptions_noException() throws InvalidMcqOption {
        ArrayList<String> answers = new ArrayList<>();
        answers.add("A");
        answers.add("1");
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(Integer.valueOf("2"));
        marks.add(Integer.valueOf("4"));
        int numberOfQuestions = 2;
        Assignment assignmentOne = new McqAssignment("quiz1");
        assignmentOne.setAnswers(new Answer(answers, marks, numberOfQuestions));
        assertEquals(2, assignmentOne.getAnswers().getNumberOfQuestions());
    }

    @Test
    void testSetAnswer_InvalidOptions_ExceptionThrows() {
        ArrayList<String> answers = new ArrayList<>();
        answers.add("A");
        answers.add("ASHUASA");
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(Integer.valueOf("2"));
        marks.add(Integer.valueOf("4"));
        int numberOfQuestions = 2;
        Assignment assignmentOne = new McqAssignment("quiz1");
        assertThrows(InvalidMcqOption.class, () ->
                assignmentOne.setAnswers(new Answer(answers, marks, numberOfQuestions)));
    }

    @Test
    void testGetTotalMarks_noMarks_Zero() throws InvalidMcqOption {
        ArrayList<String> answers = new ArrayList<>();
        answers.add("A");
        answers.add("1");
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(Integer.valueOf("0"));
        marks.add(Integer.valueOf("0"));
        int numberOfQuestions = 2;
        Assignment assignmentOne = new McqAssignment("quiz1");
        assignmentOne.setAnswers(new Answer(answers, marks, numberOfQuestions));
        assertEquals(0, ((McqAssignment) assignmentOne).getTotalMarks());
    }

    @Test
    void testGetTotalMarks_Marks_Six() throws InvalidMcqOption {
        ArrayList<String> answers = new ArrayList<>();
        answers.add("A");
        answers.add("1");
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(Integer.valueOf("2"));
        marks.add(Integer.valueOf("4"));
        int numberOfQuestions = 2;
        Assignment assignmentOne = new McqAssignment("quiz1");
        assignmentOne.setAnswers(new Answer(answers, marks, numberOfQuestions));
        assertEquals(6, ((McqAssignment) assignmentOne).getTotalMarks());
    }

}
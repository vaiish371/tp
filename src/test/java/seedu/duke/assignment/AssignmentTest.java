package seedu.duke.assignment;

import org.junit.jupiter.api.Test;
import seedu.duke.exception.DateTimeFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AssignmentTest {

    @Test
    void testAssignment_AssignmentOne_convertedToString() {
        assertEquals("AssignmentOne", new McqAssignment("AssignmentOne").toString());
    }

    @Test
    void testAssignment_AssignmentOne_falseAsserted() {
        Assignment assignmentCheck = new LongAnswerAssignment("Assignment One");
        assertFalse("AssignmentOne" == assignmentCheck.toString());
    }

    @Test
    void testAssignment_AssignmentOne_dateParseTestOne() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        Assignment assignmentTest = new McqAssignment("Magic Sequence");
        assignmentTest.setDeadline(LocalDate.parse("01 01 2021", formatter));
        String deadlineString = assignmentTest.getDeadline().toString();
        assertTrue(deadlineString.equals("2021-01-01"));
    }

    @Test
    void testAssignment_AssignmentOne_dateParseTestTwo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        Assignment assignmentTest = new McqAssignment("Magic Sequence");
        assignmentTest.setDeadline(LocalDate.parse("01 01 2021", formatter));
        String deadlineString = assignmentTest.getDeadline().toString();
        assertFalse(deadlineString.equals("2021 01 01"));
    }

    @Test
    void testAssignment_AssignmentOne_dateParseTestThree() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        Assignment assignmentTest = new McqAssignment("Magic Sequence");
        assignmentTest.setDeadline(LocalDate.parse("01 01 2021", formatter));
        LocalDate deadline = assignmentTest.getDeadline();
        String deadlineString = deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        assertTrue(deadlineString.equals("Jan 1 2021"));
    }

    @Test
    void testAssignment_AssignmentOne_dateParseTestFour() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        Assignment assignmentTest = new McqAssignment("Magic Sequence");
        assignmentTest.setDeadline(LocalDate.parse("01 01 2021", formatter));
        LocalDate deadline = assignmentTest.getDeadline();
        String deadlineString = deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        assertFalse(deadlineString.equals("01 01 2021"));
    }

}
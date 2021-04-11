package seedu.duke.data.assignment;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AssignmentTest {

    @Test
    void testAssignment_AssignmentOne_convertedToString() {
        assertEquals("AssignmentOne (McqAssignment) - due date not specified.",
                new McqAssignment("AssignmentOne").toString());
    }

    @Test
    void testAssignment_AssignmentOne_falseAsserted() {
        Assignment assignmentCheck = new LongAnswerAssignment("Assignment One");
        assertFalse("AssignmentOne".equals(assignmentCheck.toString()));
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

    @Test
    void testCompareTo_bothNull_noChangeZero() {
        Assignment assignmentNullOne = new McqAssignment("quiz1");
        Assignment assignmentNullTwo = new McqAssignment("quiz2");
        assertEquals(0, assignmentNullOne.compareTo(assignmentNullTwo));
    }

    @Test
    void testCompareTo_TwoNull_negative() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        Assignment assignmentNullOne = new McqAssignment("quiz1");
        assignmentNullOne.setDeadline(LocalDate.parse("01 01 2021", formatter));
        Assignment assignmentNullTwo = new McqAssignment("quiz2");
        assertEquals(-1, assignmentNullOne.compareTo(assignmentNullTwo));
    }

    @Test
    void testCompareTo_OneNull_positive() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        Assignment assignmentNullOne = new McqAssignment("quiz1");
        Assignment assignmentNullTwo = new McqAssignment("quiz2");
        assignmentNullTwo.setDeadline(LocalDate.parse("01 01 2021", formatter));
        assertEquals(1, assignmentNullOne.compareTo(assignmentNullTwo));
    }

    @Test
    void testCompareTo_OneBeforeTwo_negative() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        Assignment assignmentNullOne = new McqAssignment("quiz1");
        assignmentNullOne.setDeadline(LocalDate.parse("01 01 2021", formatter));
        Assignment assignmentNullTwo = new McqAssignment("quiz2");
        assignmentNullTwo.setDeadline(LocalDate.parse("02 01 2021", formatter));
        assertEquals(-1, assignmentNullOne.compareTo(assignmentNullTwo));
    }

    @Test
    void testCompareTo_TwoBeforeOne_positive() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        Assignment assignmentNullOne = new McqAssignment("quiz1");
        assignmentNullOne.setDeadline(LocalDate.parse("02 01 2021", formatter));
        Assignment assignmentNullTwo = new McqAssignment("quiz2");
        assignmentNullTwo.setDeadline(LocalDate.parse("01 01 2021", formatter));
        assertEquals(1, assignmentNullOne.compareTo(assignmentNullTwo));
    }

    @Test
    void testCompareTo_OneEqualsTwo_zero() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        Assignment assignmentNullOne = new McqAssignment("quiz1");
        assignmentNullOne.setDeadline(LocalDate.parse("01 01 2021", formatter));
        Assignment assignmentNullTwo = new McqAssignment("quiz2");
        assignmentNullTwo.setDeadline(LocalDate.parse("01 01 2021", formatter));
        assertEquals(0, assignmentNullOne.compareTo(assignmentNullTwo));
    }




}
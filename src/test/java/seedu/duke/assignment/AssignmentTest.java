package seedu.duke.assignment;

import org.junit.jupiter.api.Test;

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
        assertFalse("AssignmentOne" == assignmentCheck.toString());
    }

}
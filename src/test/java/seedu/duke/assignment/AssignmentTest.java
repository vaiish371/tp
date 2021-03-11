package seedu.duke.assignment;

import org.junit.jupiter.api.Test;
import seedu.duke.Assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AssignmentTest {

    @Test
    void testAssignment_AssignmentOne_convertedToString() {
        assertEquals("AssignmentOne", new Assignment("AssignmentOne").toString());
    }

    @Test
    void testAssignment_AssignmentOne_falseAsserted() {
        Assignment assignmentCheck = new Assignment("Assignment One");
        assertFalse("AssignmentOne" == assignmentCheck.toString());
    }

}
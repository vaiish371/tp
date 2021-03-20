package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class ModuleTest {
    @Test
    void testGetModuleCode() {
        assertEquals("CS2113T", new Module("CS2113T").getModuleCode());
    }

    //    @Test
    //    void testPrintAssignments() {
    //        Module testModule = new Module("CS2113T");
    //        testModule.addAssignment(new Assignment("tP"));
    //        String output = tapSystemOut(() -> {testModule.printAssignments();});
    //        assertEquals("Here are your assignments for CS2113T:\n" + "tP\n", output);
    //    }

    @Test
    void testGetAssignmentAtIndex() {
        Module testModule = new Module("CS2113T");
        testModule.addAssignment(new Assignment("tP"));
        assertEquals("tP", testModule.getAssignmentAtIndex(0).toString());
    }

    @Test
    void getAssignmentAtIndex_indexNonExistent_exceptionThrown() {
        Module testModule = new Module("CS2113T");
        testModule.addAssignment(new Assignment("tP"));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            testModule.getAssignmentAtIndex(1);
        });
    }

    @Test
    void testFindAssignment_AssignmentExists_AssignmentFound() {
        String moduleCode = "CS2113T";
        String assignmentName = "quiz1";
        Module testModule = new Module(moduleCode);
        testModule.addAssignment(new Assignment(assignmentName));
        assertEquals("quiz1", testModule.findAssignment(assignmentName).getName());
    }

    @Test
    void testFindAssignment_AssignmentDoesNotExists_AssignmentNull() {
        String moduleCode = "CS2113T";
        String assignmentName = "quiz1";
        String assignmentToBeFound = "quiz2";
        Module testModule = new Module(moduleCode);
        testModule.addAssignment(new Assignment(assignmentName));
        assertEquals(null, testModule.findAssignment(assignmentToBeFound));
    }
}
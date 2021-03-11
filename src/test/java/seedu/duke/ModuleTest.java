package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
//        assertEquals("Here are your assignments for CS2113T:\n" + "tP\n", systemOutRule.getLog());
//    }

    @Test
    void testGetAssignmentAtIndex() {
        Module testModule = new Module("CS2113T");
        testModule.addAssignment(new Assignment("tP"));
        assertEquals("tP", testModule.getAssignmentAtIndex(0).toString());
    }

    @Test
    void getAssignmentAtIndex_indexNonExistent_exceptionThrown() {
        try {
            Module testModule = new Module("CS2113T");
            testModule.addAssignment(new Assignment("tP"));
            assertEquals("tP", testModule.getAssignmentAtIndex(1));
            fail();
        } catch (IndexOutOfBoundsException e) {
            // Expected outcome, IndexOutOfBoundsException thrown
        }
    }
}
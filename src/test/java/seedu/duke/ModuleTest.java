package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.assignment.Assignment;
import seedu.duke.assignment.LongAnswerAssignment;
import seedu.duke.assignment.McqAssignment;
import seedu.duke.assignment.ShortAnswerAssignment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class ModuleTest {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");

    @Test
    void testGetModuleCode() {
        assertEquals("CS2113T", new Module("CS2113T").getModuleCode());
    }

    @Test
    void testGetAssignmentAtIndex() {
        Module testModule = new Module("CS2113T");
        testModule.addAssignment(new McqAssignment("tP"));
        assertEquals("tP", testModule.getAssignmentAtIndex(0).toString());
    }

    @Test
    void getAssignmentAtIndex_indexNonExistent_exceptionThrown() {
        Module testModule = new Module("CS2113T");
        testModule.addAssignment(new LongAnswerAssignment("tP"));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            testModule.getAssignmentAtIndex(1);
        });
    }

    @Test
    void testFindAssignment_AssignmentExists_AssignmentFound() {
        String moduleCode = "CS2113T";
        String assignmentName = "quiz1";
        Module testModule = new Module(moduleCode);
        testModule.addAssignment(new ShortAnswerAssignment(assignmentName));
        assertEquals("quiz1", testModule.findAssignment(assignmentName).getName());
    }

    @Test
    void testFindAssignment_AssignmentDoesNotExists_AssignmentNull() {
        String moduleCode = "CS2113T";
        String assignmentName = "quiz1";
        String assignmentToBeFound = "quiz2";
        Module testModule = new Module(moduleCode);
        testModule.addAssignment(new McqAssignment(assignmentName));
        assertNull(testModule.findAssignment(assignmentToBeFound));
    }

    @Test
    void testFindStudent_StudentExists_StudentFound() {
        String moduleCode = "CS2113T";
        String studentName = "Bryan";
        String studentNumber = "A0123456X";
        String email = "hello@u.nus.edu";
        Module testModule = new Module(moduleCode);
        Student testStudent = new Student(studentName, studentNumber, email);
        testModule.addStudent(testStudent);
        assertEquals(testStudent, testModule.findStudent(studentName));
    }

    @Test
    void testFindStudent_StudentDoesNotExists_StudentNull() {
        String moduleCode = "CS2113T";
        String studentName = "Bryan";
        String studentNumber = "A0123456X";
        String email = "hello@u.nus.edu";
        String studentToBeFound = "Jianning";
        Module testModule = new Module(moduleCode);
        Student testStudent = new Student(studentName, studentNumber, email);
        testModule.addStudent(testStudent);
        assertNull(testModule.findStudent(studentToBeFound));
    }

    @Test
    void testGetAssignments() {
        String moduleCode = "CS2113T";
        String assignmentName = "quiz1";
        Module testModule = new Module(moduleCode);
        Assignment testAssignment = new McqAssignment(assignmentName);
        testModule.addAssignment(testAssignment);
        ArrayList<Assignment> expectedOutput = new ArrayList<>();
        expectedOutput.add(testAssignment);
        assertEquals(expectedOutput, testModule.getAssignments());
    }

    @Test
    void testGetStudents() {
        String moduleCode = "CS2113T";
        String studentName = "Bryan";
        String studentNumber = "A0123456X";
        String email = "hello@u.nus.edu";
        Module testModule = new Module(moduleCode);
        Student testStudent = new Student(studentName, studentNumber, email);
        testModule.addStudent(testStudent);
        ArrayList<Student> expectedOutput = new ArrayList<>();
        expectedOutput.add(testStudent);
        assertEquals(expectedOutput, testModule.getStudents());
    }

    @Test
    void testGetLessons() {
        String moduleCode = "CS2113T";
        String day = "FRIDAY";
        LocalTime startTime = LocalTime.parse("1600", formatter);
        LocalTime endTime = LocalTime.parse("1800", formatter);
        String venue = "Zoom";
        String lessonType = "Lecture";
        Module testModule = new Module(moduleCode);
        Lesson testLesson = new Lesson(day, startTime, endTime, venue, lessonType);
        testModule.addLesson(testLesson);
        ArrayList<Lesson> expectedOutput = new ArrayList<>();
        expectedOutput.add(testLesson);
        assertEquals(expectedOutput, testModule.getLessons());
    }

    @Test
    void testToStorage() {
        String moduleCode = "CS2113T";
        Module testModule = new Module(moduleCode);
        String assignmentName = "quiz1";
        Assignment testAssignment = new McqAssignment(assignmentName);
        testModule.addAssignment(testAssignment);
        String studentName = "Bryan";
        String studentNumber = "A0123456X";
        String email = "hello@u.nus.edu";
        Student testStudent = new Student(studentName, studentNumber, email);
        testModule.addStudent(testStudent);
        String day = "FRIDAY";
        LocalTime startTime = LocalTime.parse("1600", formatter);
        LocalTime endTime = LocalTime.parse("1800", formatter);
        String venue = "Zoom";
        String lessonType = "Lecture";
        Lesson testLesson = new Lesson(day, startTime, endTime, venue, lessonType);
        testModule.addLesson(testLesson);
        String expectedOutput = "CS2113T | 1 | 1 | 1\n";
        expectedOutput += testAssignment.toStorage();
        expectedOutput += testLesson.toStorage();
        expectedOutput += testStudent.toStorage();
        assertEquals(expectedOutput, testModule.toStorage());
    }
}
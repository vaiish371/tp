package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    void getStudentNumber() {
        String studentName = "Bryan";
        String studentNumber = "A0123456X";
        String email = "hello@u.nus.edu";
        Student testStudent = new Student(studentName, studentNumber, email);
        assertEquals(studentNumber, testStudent.getStudentNumber());
    }

    @Test
    void getEmail() {
        String studentName = "Bryan";
        String studentNumber = "A0123456X";
        String email = "hello@u.nus.edu";
        Student testStudent = new Student(studentName, studentNumber, email);
        assertEquals(email, testStudent.getEmail());
    }

    @Test
    void testToString() {
        String studentName = "Bryan";
        String studentNumber = "A0123456X";
        String email = "hello@u.nus.edu";
        Student testStudent = new Student(studentName, studentNumber, email);
        assertEquals("Bryan, A0123456X, hello@u.nus.edu", testStudent.toString());
    }

    @Test
    void testToStorage() {
        String studentName = "Bryan";
        String studentNumber = "A0123456X";
        String email = "hello@u.nus.edu";
        Student testStudent = new Student(studentName, studentNumber, email);
        assertEquals("Bryan | A0123456X | hello@u.nus.edu\n", testStudent.toStorage());
    }
}
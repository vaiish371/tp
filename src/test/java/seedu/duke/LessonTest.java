package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.exception.InvalidStartTimeException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LessonTest {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");

    @Test
    void testSetStartTime_positiveTest() throws InvalidStartTimeException {
        String day = "FRIDAY";
        LocalTime startTime = LocalTime.parse("1600", formatter);
        LocalTime endTime = LocalTime.parse("1800", formatter);
        String venue = "Zoom";
        String lessonType = "Lecture";
        Lesson testLesson = new Lesson(day, startTime, endTime, venue, lessonType);
        testLesson.setStartTime(LocalTime.parse("1700", formatter));
        assertEquals(LocalTime.parse("1700", formatter), testLesson.getStartTime());
    }

    @Test
    void testSetStartTime_negativeTest_exceptionThrown() {
        String day = "FRIDAY";
        LocalTime startTime = LocalTime.parse("1600", formatter);
        LocalTime endTime = LocalTime.parse("1800", formatter);
        String venue = "Zoom";
        String lessonType = "Lecture";
        Lesson testLesson = new Lesson(day, startTime, endTime, venue, lessonType);
        assertThrows(InvalidStartTimeException.class, () -> {
            testLesson.setStartTime(LocalTime.parse("1800", formatter));
        });
    }

    @Test
    void testSetEndTime_positiveTest() throws InvalidStartTimeException {
        String day = "FRIDAY";
        LocalTime startTime = LocalTime.parse("1600", formatter);
        LocalTime endTime = LocalTime.parse("1800", formatter);
        String venue = "Zoom";
        String lessonType = "Lecture";
        Lesson testLesson = new Lesson(day, startTime, endTime, venue, lessonType);
        testLesson.setEndTime(LocalTime.parse("1700", formatter));
        assertEquals(LocalTime.parse("1700", formatter), testLesson.getEndTime());
    }

    @Test
    void testSetEndTime_negativeTest_exceptionThrown() {
        String day = "FRIDAY";
        LocalTime startTime = LocalTime.parse("1600", formatter);
        LocalTime endTime = LocalTime.parse("1800", formatter);
        String venue = "Zoom";
        String lessonType = "Lecture";
        Lesson testLesson = new Lesson(day, startTime, endTime, venue, lessonType);
        assertThrows(InvalidStartTimeException.class, () -> {
            testLesson.setEndTime(LocalTime.parse("1600", formatter));
        });
    }

    @Test
    void testSetVenue() {
        String day = "FRIDAY";
        LocalTime startTime = LocalTime.parse("1600", formatter);
        LocalTime endTime = LocalTime.parse("1800", formatter);
        String venue = "Zoom";
        String lessonType = "Lecture";
        Lesson testLesson = new Lesson(day, startTime, endTime, venue, lessonType);
        testLesson.setVenue("COM2");
        assertEquals("COM2", testLesson.getVenue());
    }

    @Test
    void testSetLessonType() {
        String day = "FRIDAY";
        LocalTime startTime = LocalTime.parse("1600", formatter);
        LocalTime endTime = LocalTime.parse("1800", formatter);
        String venue = "Zoom";
        String lessonType = "Lecture";
        Lesson testLesson = new Lesson(day, startTime, endTime, venue, lessonType);
        testLesson.setLessonType("Tutorial");
        assertEquals("Tutorial", testLesson.getLessonType());
    }

    @Test
    void testToString() {
        String day = "FRIDAY";
        LocalTime startTime = LocalTime.parse("1600", formatter);
        LocalTime endTime = LocalTime.parse("1800", formatter);
        String venue = "Zoom";
        String lessonType = "Lecture";
        Lesson testLesson = new Lesson(day, startTime, endTime, venue, lessonType);
        assertEquals("FRIDAY, 16:00-18:00", testLesson.toString());
    }
}
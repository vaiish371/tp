package seedu.duke;

import java.time.LocalTime;

public class Lesson {
    private String day;
    private LocalTime startTime;
    private LocalTime endTime;
    private String venue;
    private String lessonType;

    public Lesson(String day, LocalTime startTime, LocalTime endTime, String venue, String lessonType) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.venue = venue;
        this.lessonType = lessonType;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getVenue() {
        return venue;
    }

    public String getLessonType() {
        return lessonType;
    }

    @Override
    public String toString() {
        return day + ", " + startTime.toString() + "-" + endTime.toString();
    }
}

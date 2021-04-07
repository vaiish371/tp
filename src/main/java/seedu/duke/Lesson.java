package seedu.duke;

import seedu.duke.exception.InvalidStartTimeException;

import java.time.LocalTime;

public class Lesson implements Storable {
    private Day day;
    private LocalTime startTime;
    private LocalTime endTime;
    private String venue;
    private String lessonType;

    public Lesson(String day, LocalTime startTime, LocalTime endTime, String venue, String lessonType) {
        this.day = Day.valueOf(day);
        this.startTime = startTime;
        this.endTime = endTime;
        this.venue = venue;
        this.lessonType = lessonType;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public void setStartTime(LocalTime startTime) throws InvalidStartTimeException {
        if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
            throw new InvalidStartTimeException();
        }
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) throws InvalidStartTimeException {
        if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
            throw new InvalidStartTimeException();
        }
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

    @Override
    public String toStorage() {
        String storageString = "";
        storageString += this.day;
        storageString += " | ";
        storageString += this.startTime.toString();
        storageString += " | ";
        storageString += this.endTime.toString();
        storageString += " | ";
        storageString += this.venue;
        storageString += " | ";
        storageString += this.lessonType;
        storageString += "\n";
        return storageString;
    }
}

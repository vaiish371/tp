package seedu.duke.data.lesson;

import seedu.duke.storage.Storable;
import seedu.duke.exception.InvalidStartTimeException;

import java.time.LocalTime;

public class Lesson implements Storable {
    private Day day;
    private LocalTime startTime;
    private LocalTime endTime;
    private String venue;
    private String lessonType;

    /**
     * Constructor for Lesson object.
     *
     * @param day Lesson day
     * @param startTime Lesson start time
     * @param endTime Lesson end time
     * @param venue Lesson venue
     * @param lessonType Lesson type
     */
    public Lesson(String day, LocalTime startTime, LocalTime endTime, String venue, String lessonType) {
        this.day = Day.valueOf(day);
        this.startTime = startTime;
        this.endTime = endTime;
        this.venue = venue;
        this.lessonType = lessonType;
    }

    /**
     * Copy constructor for Lesson object.
     *
     * @param another Another lesson object to copy attributes from
     */
    public Lesson(Lesson another) {
        this.day = another.day;
        this.startTime = another.startTime;
        this.endTime = another.endTime;
        this.venue = another.venue;
        this.lessonType = another.lessonType;
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

    public Day getDay() {
        return day;
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

    /**
     * Equality check for all attributes between two Lesson objects.
     *
     * @param o Lesson object to compare with
     * @return true if all attributes match, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Lesson)) {
            return false;
        }

        Lesson lesson = (Lesson) o;

        return (this.day.equals(lesson.day) && this.startTime.equals(lesson.startTime)
                && this.endTime.equals(lesson.endTime) && this.venue.equals(lesson.venue)
                && this.lessonType.equals(lesson.lessonType));
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

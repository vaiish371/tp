package seedu.duke;

import java.util.HashMap;

public class Assignment {
    protected String name;
    protected String deadline; // Optional field, null can be thrown
    protected float percentageOfOverallGrade; // Optional field, null can be thrown
    protected HashMap<String, Float> studentGrades;

    public Assignment(String name) {
        this.name = name;
        this.studentGrades = new HashMap<>();

        assert this.name != null: "Assignment name cannot be null";
        assert this.studentGrades != null: "studentGrades cannot be null";
    }

    public HashMap<String, Float> getStudentGrades() {
        return studentGrades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public float getPercentage() {
        return percentageOfOverallGrade;
    }

    public void setPercentage(float percentage) {
        this.percentageOfOverallGrade = percentage;
    }

    @Override
    public String toString() {
        return name;
    }
}


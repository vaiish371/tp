package seedu.duke.assignment;

import seedu.duke.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Assignment implements Comparable<Assignment> {
    protected String name;
    protected LocalDate deadline; // Optional field, null can be thrown
    protected float percentageOfOverallGrade; // Optional field, null can be thrown
    protected HashMap<String, Float> studentGrades;

    public Assignment(String name) {
        this.name = name;
        this.studentGrades = new HashMap<>();

        assert this.name != null : "Assignment name cannot be null";
        assert this.studentGrades != null : "studentGrades cannot be null";
    }

    public HashMap<String, Float> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrade(Student student, String grade) {
        String studentNumber = student.getStudentNumber();
        Float gradeFloat = Float.parseFloat(grade);
        studentGrades.put(studentNumber, gradeFloat);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public float getPercentage() {
        return percentageOfOverallGrade;
    }

    public void setPercentage(float percentage) {
        this.percentageOfOverallGrade = percentage;
    }

    @Override
    public int compareTo(Assignment a) {
        if (this.getDeadline() == null) {
            return 1;
        } else if (a.getDeadline() == null) {
            return -1;
        }
        return this.getDeadline().compareTo(a.getDeadline());
    }

    @Override
    public String toString() {
        if (deadline == null) {
            return name;
        }
        return name + " (due by: " + deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    public abstract void setAnswers(ArrayList<String> answers);
}


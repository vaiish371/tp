package seedu.duke;

public class Student {
    private String name;
    private String studentNumber;

    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        assert this.name != null : "Student name cannot be null";
        assert this.studentNumber != null : "Student number cannot be null";
    }

    @Override
    public String toString() {
        return getName() + ", " + getStudentNumber();
    }
}

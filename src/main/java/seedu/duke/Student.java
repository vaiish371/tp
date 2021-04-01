package seedu.duke;

public class Student implements Storable {
    private String name;
    private String studentNumber;
    private String email;

    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getEmail() {
        return email;
    }

    public Student(String name, String studentNumber, String email) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.email = email;

        assert this.name != null : "Student name cannot be null";
        assert this.studentNumber != null : "Student number cannot be null";
        assert this.email != null : "Student email cannot be null";

    }

    @Override
    public String toString() {
        return (getName() + ", " + getStudentNumber() + ", " + getEmail());
    }

    @Override
    public String toStorage() {
        String storageString = "";
        storageString += this.name;
        storageString += " | ";
        storageString += this.studentNumber;
        storageString += " | ";
        storageString += this.email;
        storageString += "\n";
        return storageString;
    }
}

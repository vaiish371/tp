package seedu.duke;

public class Student {
    private String name;
    private String studentNumber;
    private String email;
    private String contactNumber;

    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getEmail() {
        return email;
    }

    private String getContactNumber () {
        return contactNumber;
    }

    public Student(String name, String studentNumber, String contactNumber, String email) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.contactNumber = contactNumber;
        this.email = email;

        assert this.name != null : "Student name cannot be null";
        assert this.studentNumber != null : "Student number cannot be null";
        assert this.contactNumber != null : "Student contact number cannot be null";
        assert this.email != null : "Student email cannot be null";

    }

    @Override
    public String toString() {
        return (getName() + ", " + getStudentNumber() +", " + getContactNumber() +", " + getEmail());
    }
}

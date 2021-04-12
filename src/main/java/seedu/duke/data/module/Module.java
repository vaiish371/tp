package seedu.duke.data.module;

import seedu.duke.storage.Storable;
import seedu.duke.data.student.Student;
import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.lesson.Lesson;

import java.util.ArrayList;
import java.util.Collections;

public class Module implements Storable {
    private String moduleCode;
    private ArrayList<Assignment> assignments;
    private ArrayList<Lesson> lessons;
    private ArrayList<Student> students;

    /**
     * Constructor for Module object.
     *
     * @param moduleCode Module code of module
     */
    public Module(String moduleCode) {
        this.moduleCode = moduleCode;
        this.assignments = new ArrayList<>();
        this.lessons = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Assignment getAssignmentAtIndex(int index) {
        return assignments.get(index);
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    /**
     * Find and return assignment in module.
     *
     * @param assignmentName name of assignment
     * @return Assignment object; null if assignment not found
     */
    public Assignment findAssignment(String assignmentName) {
        Assignment assignmentToBeQueried = null;
        for (Assignment assignment : assignments) {
            if (assignment.getName().equals(assignmentName)) {
                assignmentToBeQueried = assignment;
                break;
            }
        }
        return assignmentToBeQueried;
    }

    /**
     * Find and return student in module.
     *
     * @param studentName name of student
     * @return Student object; null if student not found
     */
    public Student findStudent(String studentName) {
        Student studentToBeFound = null;
        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                studentToBeFound = student;
                break;
            }
        }
        return studentToBeFound;
    }

      
    public Student getStudentAtIndex(int index) {
        return students.get(index);
    }

    /**
     * Sort assignments by deadline.
     */
    public void sortAssignments() {
        Collections.sort(assignments);
    }

    @Override
    public String toStorage() {
        String storageString = "";
        storageString += moduleCode;
        storageString += " | ";
        storageString += this.assignments.size();
        storageString += " | ";
        storageString += this.lessons.size();
        storageString += " | ";
        storageString += this.students.size();
        storageString += "\n";
        for (int i = 0; i < this.assignments.size(); i++) {
            Assignment assignment = this.assignments.get(i);
            storageString += assignment.toStorage();
        }
        for (int i = 0; i < this.lessons.size(); i++) {
            Lesson lesson = this.lessons.get(i);
            storageString += lesson.toStorage();
        }
        for (int i = 0; i < this.students.size(); i++) {
            Student student = this.students.get(i);
            storageString += student.toStorage();
        }
        return storageString;
    }
}


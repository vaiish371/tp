package seedu.duke;

import java.util.ArrayList;

public class Module {
    private String moduleCode;
    private ArrayList<Assignment> assignments;
    private ArrayList<Lesson> lessons;

    public Module(String moduleCode) {
        this.moduleCode = moduleCode;
        this.assignments = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
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

    public void printAssignments() {
        System.out.println("Here are your assignments for " + moduleCode + ":");
        for (Assignment a: assignments) {
            System.out.println(a);
        }
    }
}


package seedu.duke;

import java.util.ArrayList;

public class Module {
    private String moduleCode;
    private ArrayList<Assignment> assignments;


    public Module(String moduleCode) {
        this.moduleCode = moduleCode;
        this.assignments = new ArrayList<>();
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public Assignment getAssignmentAtIndex(int index) {
        return assignments.get(index);
    }

}


package seedu.duke.ui;

import seedu.duke.Assignment;
import seedu.duke.Lesson;
import seedu.duke.Module;
import seedu.duke.Student;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;

public class Ui {
    private final Scanner in;
    private static final String exceptionGreeting = "OOPS!!! ";

    public Ui() {
        in = new Scanner(System.in);
    }

    public static void showLine() {
        System.out.println("\t---------------------------------------------------------------------");
    }

    public void showExitMessage() {
        System.out.println("\tBye. Hope to see you again soon!");
    }

    public void showWelcomeMessage() {
        String logo = " __  __           _   __  __\n"
                + "|  \\/  |         | | |  \\/  |\n"
                + "| \\  / | ___   __| | | \\  / | __ _ _ __\n"
                + "| |\\/| |/ _ \\ / _  | | |\\/| |/ _  |  _ \\\n"
                + "| |  | | (_) | (_| | | |  | | (_| | | | |\n"
                + "|_|  |_|\\___/ \\__'_| |_|  |_|\\__'_|_| |_|\n";
        System.out.println("Hello from\n" + logo);
    }

    public String readCommand() {
        String fullCommand = in.nextLine();
        return fullCommand;
    }

    public void showError(String message) {
        System.out.println("\t" + exceptionGreeting + message);
    }

    public void printNewAssignment(Module module, Assignment assignment) {
        System.out.println("\t I have added a new assignment to " + module.getModuleCode() + ":");
        System.out.println("\t " + assignment);
    }

    public void printNewStudent(Module module, Student student) {
        System.out.println("\t I have assigned a new student to " + module.getModuleCode() + ":");
        System.out.println("\t " + student);
    }

    public void printEditAssignment(Module module, String oldName, String newName) {
        System.out.println("\t I have edited your assignment in " + module.getModuleCode() + " from:");
        System.out.println("\t - " + oldName);
        System.out.println("\t to");
        System.out.println("\t + " + newName);
    }

    public void printNewModule(Module module) {
        System.out.println("\t I have added a new module: " + module.getModuleCode());
    }

    public void printNewTimetable(String moduleCode, Lesson lesson) {
        System.out.println("Success! I have added the following timetable for the module - " + moduleCode);
        System.out.println("\t" + lesson.getLessonType() + ": " + lesson.toString() 
                           + " (" + lesson.getVenue() + ")");
    }
  
    public void listModuleAssignments(Module module) {
        ArrayList<Assignment> assignments = module.getAssignments();
        if (assignments.size() == 0) {
            System.out.println("\t You have not added any assignments to " + module.getModuleCode() + " yet.");
        } else {
            assert assignments.size() > 0 : "size of assignments should be greater than zero";
            System.out.println("\t Here are the assignments in " + module.getModuleCode() + ":");
            for (int i = 1; i <= assignments.size(); i++) {
                System.out.println("\t " + i + ". " + assignments.get(i - 1).toString());
            }
        }
    }

    public void listModuleStudents(Module module) {
        ArrayList<Student> students = module.getStudents();
        if (students.size() == 0) {
            System.out.println("\t You have not added any students to " + module.getModuleCode() + " yet.");
        } else {
            assert students.size() > 0 : "size of students should be greater than zero";
            System.out.println("\t Here are the students in " + module.getModuleCode() + ":");
            for (int i = 1; i <= students.size(); i++) {
                System.out.println("\t " + i + ". " + students.get(i - 1).getName());
            }
        }
    }

    public void listModuleStudentsDetails(Module module) {
        ArrayList<Student> students = module.getStudents();
        if (students.size() == 0) {
            System.out.println("\t Here are the details of all students enrolled in "
                    + module.getModuleCode() + ":");
        } else {
            assert students.size() > 0 : "size of students should be greater than zero";
            for (int i = 1; i <= students.size(); i++) {
                System.out.println("\t " + i + ". " + students.get(i - 1).toString());
            }
        }
    }

    public void listAssignmentStudentGrades(Assignment assignment) {
        System.out.println("\t Here are the students' grades for the " + assignment.toString() + " assignment:");
        HashMap<String, Float> studentGrades = assignment.getStudentGrades();
        Iterator it = studentGrades.entrySet().iterator();
        int index = 1;
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            System.out.println("\t " + index + ". " + pair.getKey() + " - " + pair.getValue());
            index++;
        }
    }
}

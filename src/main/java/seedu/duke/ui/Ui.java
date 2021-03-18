package seedu.duke.ui;

import seedu.duke.Assignment;
import seedu.duke.Module;
import seedu.duke.Student;

import java.util.ArrayList;
import java.util.Scanner;


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

    public void printNewModule(Module module) {
        System.out.println("\t I have added a new module: " + module.getModuleCode());
    }

    public void listModuleAssignments(Module module) {
        System.out.println("\t Here are the assignments in " + module.getModuleCode() + ":");
        ArrayList<Assignment> assignments = module.getAssignments();
        for (int i = 1; i <= assignments.size(); i++) {
            System.out.println("\t " + i + ". " + assignments.get(i - 1).toString());
        }
    }

    public void listModuleStudents(Module module) {
        System.out.println("\t Here are the students in " + module.getModuleCode() + ":");
        ArrayList<Student> students = module.getStudents();
        for (int i = 1; i <= students.size(); i++) {
            System.out.println("\t " + i + ". " + students.get(i - 1).getName());
        }
    }

    public void listModuleStudentsDetails(Module module) {
        System.out.println("\t Here are the details of all students enrolled in "
                + module.getModuleCode() + ":");
        ArrayList<Student> students = module.getStudents();
        for (int i = 1; i <= students.size(); i++) {
            System.out.println("\t " + i + ". " + students.get(i - 1).toString());
        }
    }

    public void findStudentDetails(Module module, String studentName) {
        System.out.println("\t Finding details of ~ " + studentName + " ~ in "
                + module.getModuleCode() + ": ");
        ArrayList<Student> students = module.getStudents();
        for (Student student: students) {
            if (student.getName().contains(studentName)) {
                System.out.println("\t >>" + student.toString());
            }
        }

    }
}
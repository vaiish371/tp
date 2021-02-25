package seedu.duke.ui;

import java.util.Scanner;

public class Ui {
    private final Scanner in;
    private static final String exceptionGreeting = "\ud83d\ude16 OOPS!!! ";

    public Ui() {
        in = new Scanner(System.in);
    }

    private static void showLine() {
        System.out.println("\t---------------------------------------------------------------------");
    }

    private void showExitMessage() {
        showLine();
        System.out.println("\tBye. Hope to see you again soon!");
        showLine();
    }

    private void showWelcomeMessage() {
        String logo = " __  __           _   __  __\n"
                + "|  \\/  |         | | |  \\/  |\n"
                + "| \\  / | ___   __| | | \\  / | __ _ _ __\n"
                + "| |\\/| |/ _ \\ / _  | | |\\/| |/ _  |  _ \\\n"
                + "| |  | | (_) | (_| | | |  | | (_| | | | |\n"
                + "|_|  |_|\\___/ \\__'_| |_|  |_|\\__'_|_| |_|\n";
        System.out.println("Hello from\n" + logo);
    }

    private String readCommand() {
        String fullCommand = in.nextLine();
        return fullCommand;
    }

    private void showError(String message) {
        System.out.println("\t" + exceptionGreeting + message);
    }
}

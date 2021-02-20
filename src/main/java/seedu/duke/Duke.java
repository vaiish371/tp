package seedu.duke;

import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = " __  __           _   __  __     \n"
                + "|  \\/  |         | | |  \\/  |\n"
                + "| \\  / | ___   __| | | \\  / | __ _ _ __\n"
                + "| |\\/| |/ _ \\ / _  | | |\\/| |/ _  |  _ \\\n"
                + "| |  | | (_) | (_| | | |  | | (_| | | | |\n"
                + "|_|  |_|\\___/ \\__ _| |_|  |_|\\__ _|_| |_|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
    }
}

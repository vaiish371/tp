package seedu.duke;

public class Modman {

    private Data data;
    private Ui ui;

    public Modman() {
        ui = new Ui();
        data = new Data();
    }

    public void run() {
        ui.showWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(data, ui);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine;
            }
        }
        ui.showExitMessage();
    }

    public static void main(String[] args) {
        new Modman().run();
    }
}

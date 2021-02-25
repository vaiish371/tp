package seedu.duke.command;

public class ExitCommand extends Command{

    public ExitCommand() {
        this.setExit();
    }

    public String execute(Data data) {
        return "Bye! Hope to see you again.";
    }

}
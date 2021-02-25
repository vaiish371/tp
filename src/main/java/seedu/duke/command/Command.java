package seedu.duke.command;

public abstract class Command {

    private boolean isExit = false;

    public abstract String execute(Data data);

    public boolean isExit() {
        return isExit;
    }

    public void setExit() {
        this.isExit = true;
    }


}

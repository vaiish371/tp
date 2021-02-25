package seedu.duke;

public class Parser {

    public static Command parse(String line) throws ModManException {
        Command command = null;
        String[] words = line.split(" ");
        switch (words[0]){
        case "bye":
            command = new ExitCommand();
            break;
        default:
            throw new InvalidCommandException();
        }
        return command;

    }
}

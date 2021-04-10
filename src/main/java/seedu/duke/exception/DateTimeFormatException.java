package seedu.duke.exception;

public class DateTimeFormatException extends ModManException {
    public DateTimeFormatException() {
        this.errorMessage = "Date/Time Format is wrong!\n"
                + "\t Please re-enter the Date/Time in the following format: dd MM yyyy\n"
                + "\t Note that only year 2021 to 2030 is accepted.";
    }
}

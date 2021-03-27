package seedu.duke;

import seedu.duke.command.ViewAnswersCommand;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.NumbersMisalignException;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Storage {

    private static final String ROOT = System.getProperty("user.dir");
    private static final Path ANSWER_DIR_PATH = Paths.get(ROOT, "answers");
    private static final Path SCRIPT_DIR_PATH = Paths.get(ROOT, "scripts");
    private static final String ANSWER_DIVIDER = "|";
    private static final int LINE_START = 0;
    private static final int DIVIDER_LENGTH = 2;
    private static final String UNDERSCORE = "_";
    private static final String TXTFILE = ".txt";
    private static Logger logger = Logger.getLogger(Storage.class.getName());

    public Storage() {
        logger.setLevel(Level.INFO);
        logger.log(Level.INFO, "current directory: " + ROOT);
        File answerDirectory = new File(ANSWER_DIR_PATH.toString());
        if (!answerDirectory.exists()) {
            answerDirectory.mkdir();
        }
        File scriptDirectory = new File(SCRIPT_DIR_PATH.toString());
        if (!scriptDirectory.exists()) {
            scriptDirectory.mkdir();
        }
    }

    public ArrayList<String> loadAnswer(String assignmentName, String moduleCode) throws DataFileNotFoundException,
            NumbersMisalignException {
        ArrayList<String> answersArray = new ArrayList<>();
        try {
            logger.log(Level.INFO, "current directory: " + ROOT);
            String fileName = moduleCode + UNDERSCORE + assignmentName + TXTFILE;
            Path filePath = Paths.get(ROOT, "answers", fileName);
            File answerFile = new File(filePath.toString());
            Scanner scanner = new Scanner(answerFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                int answerDividerIndex = line.indexOf(ANSWER_DIVIDER);
                String questionNumberString = line.substring(LINE_START, answerDividerIndex).trim();
                int questionNumber = Integer.parseInt(questionNumberString);
                String answer = line.substring(answerDividerIndex + DIVIDER_LENGTH).trim();
                answersArray.add(answer);
                if (questionNumber != answersArray.size()) {
                    throw new NumbersMisalignException();
                }
            }
        } catch (FileNotFoundException e) {
            throw new DataFileNotFoundException();
        }
        return answersArray;
    }

    public ArrayList<String> loadScript(String assignmentName, String moduleCode, String studentNumber) throws
            DataFileNotFoundException, NumbersMisalignException {
        ArrayList<String> answersArray = new ArrayList<>();
        try {
            logger.log(Level.INFO, "current directory: " + ROOT);
            String fileName = moduleCode + UNDERSCORE + assignmentName + UNDERSCORE + studentNumber + TXTFILE;
            Path filePath = Paths.get(ROOT, "scripts", fileName);
            File scriptFile = new File(filePath.toString());
            Scanner scanner = new Scanner(scriptFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                int answerDividerIndex = line.indexOf(ANSWER_DIVIDER);
                String questionNumberString = line.substring(LINE_START, answerDividerIndex).trim();
                int questionNumber = Integer.parseInt(questionNumberString);
                String answer = line.substring(answerDividerIndex + DIVIDER_LENGTH).trim();
                answersArray.add(answer);
                if (questionNumber != answersArray.size()) {
                    throw new NumbersMisalignException();
                }
            }
        } catch (FileNotFoundException e) {
            throw new DataFileNotFoundException();
        }
        return answersArray;
    }
}

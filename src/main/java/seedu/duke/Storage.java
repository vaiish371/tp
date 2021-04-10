package seedu.duke;

import seedu.duke.assignment.Assignment;
import seedu.duke.assignment.LongAnswerAssignment;
import seedu.duke.assignment.ShortAnswerAssignment;
import seedu.duke.assignment.McqAssignment;
import seedu.duke.assignment.Answer;
import seedu.duke.data.Data;
import seedu.duke.exception.DataFileCorruptedException;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.FileNotSavedException;
import seedu.duke.exception.FileFormatException;
import seedu.duke.exception.NumbersMisalignException;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Storage {

    private static final String ROOT = System.getProperty("user.dir");
    private static final Path ANSWER_DIR_PATH = Paths.get(ROOT, "answers");
    private static final Path SCRIPT_DIR_PATH = Paths.get(ROOT, "scripts");
    private static final Path DATABASE_DIR_PATH = Paths.get(ROOT, "Database");
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
        File databaseDirectory = new File(DATABASE_DIR_PATH.toString());
        if (!databaseDirectory.exists()) {
            databaseDirectory.mkdir();
        }
    }

    public void saveData(Data data) throws FileNotSavedException {
        try {
            logger.log(Level.INFO, "current directory: " + ROOT);
            String fileName = "Database" + TXTFILE;
            Path filePath = Paths.get(ROOT, "Database", fileName);
            File databaseFile = new File(filePath.toString());
            databaseFile.createNewFile();
            String databaseString = "";
            ArrayList<Module> modules = data.getModules();
            databaseString += modules.size();
            databaseString += "\n";
            for (int i = 0; i < modules.size(); i++) {
                Module module = modules.get(i);
                databaseString += module.toStorage();
            }
            FileWriter fileWriter = new FileWriter(databaseFile);
            fileWriter.write(databaseString);
            fileWriter.close();
        } catch (IOException e) {
            throw new FileNotSavedException();
        }
    }

    private Module loadModule(Scanner scanner, int numberOfModules) throws DataFileCorruptedException {
        String moduleLine = scanner.nextLine();
        Scanner moduleScan = new Scanner(moduleLine);
        moduleScan.useDelimiter("\\s*\\|\\s*");
        String moduleName = moduleScan.next().trim();
        Module module = new Module(moduleName);
        String rawNumberOfAssignments = moduleScan.next().trim();
        int numberOfAssignments = Integer.parseInt(rawNumberOfAssignments);
        String rawNumberOfLessons = moduleScan.next().trim();
        int numberOfLessons = Integer.parseInt(rawNumberOfLessons);
        String rawNumberOfStudents = moduleScan.next().trim();
        int numberOfStudents = Integer.parseInt(rawNumberOfStudents);
        for (int j = 0; j < numberOfAssignments; j++) {
            Assignment assignment = loadAssignment(scanner);
            module.addAssignment(assignment);
        }
        for (int j = 0; j < numberOfLessons; j++) {
            Lesson lesson = loadLesson(scanner);
            module.addLesson(lesson);
        }
        for (int j = 0; j < numberOfStudents; j++) {
            Student student = loadStudent(scanner);
            module.addStudent(student);
        }
        return module;
    }

    private Assignment loadAssignment(Scanner scanner) throws DataFileCorruptedException {
        String assignmentLine = scanner.nextLine();
        Scanner assignmentScan = new Scanner(assignmentLine);
        assignmentScan.useDelimiter("\\|");
        String assignmentName = assignmentScan.next().trim();
        String typeOfAssignment = assignmentScan.next().trim();
        Assignment assignment = null;
        switch (typeOfAssignment) {
        case "McqAssignment": {
            assignment = new McqAssignment(assignmentName);
            break;
        }
        case "LongAnswerAssignment": {
            assignment = new LongAnswerAssignment(assignmentName);
            break;
        }
        case "ShortAnswerAssignment": {
            assignment = new ShortAnswerAssignment(assignmentName);
            break;
        }
        default: {
            throw new DataFileCorruptedException();
        }
        }
        String rawDeadline = assignmentScan.next().trim();
        if (rawDeadline.equals("null")) {
            assignment.setDeadline(null);
        } else {
            LocalDate deadline = LocalDate.parse(rawDeadline);
            assignment.setDeadline(deadline);
        }
        String rawPercentage = assignmentScan.next().trim();
        float percentage = Float.parseFloat(rawPercentage);
        assignment.setPercentage(percentage);
        String comments = assignmentScan.next().trim();
        if (comments.equals("null")) {
            assignment.setComments(null);
        } else {
            assignment.setComments(comments);
        }
        String rawNumberOfStudentGrades = assignmentScan.next().trim();
        int numberOfStudentGrades = Integer.parseInt(rawNumberOfStudentGrades);
        for (int k = 0; k < numberOfStudentGrades; k++) {
            String gradeLine = scanner.nextLine();
            Scanner gradeScan = new Scanner(gradeLine);
            gradeScan.useDelimiter("\\|");
            String studentNumber = gradeScan.next().trim();
            String rawStudentGrade = gradeScan.next().trim();
            float studentGrade = Float.parseFloat(rawStudentGrade);
            assignment.getStudentGrades().put(studentNumber, studentGrade);
        }
        return assignment;
    }

    private Lesson loadLesson(Scanner scanner) {
        String lessonLine = scanner.nextLine();
        Scanner lessonScan = new Scanner(lessonLine);
        lessonScan.useDelimiter("\\|");
        String day = lessonScan.next().trim();
        String rawStartTime = lessonScan.next().trim();
        LocalTime startTime = LocalTime.parse(rawStartTime);
        String rawEndTime = lessonScan.next().trim();
        LocalTime endTime = LocalTime.parse(rawEndTime);
        String venue = lessonScan.next().trim();
        String lessonType = lessonScan.next().trim();
        Lesson lesson = new Lesson(day, startTime, endTime, venue, lessonType);
        return lesson;
    }

    private Student loadStudent(Scanner scanner) {
        String studentLine = scanner.nextLine();
        Scanner studentScan = new Scanner(studentLine);
        studentScan.useDelimiter("\\|");
        String studentName = studentScan.next().trim();
        String studentNumber = studentScan.next().trim();
        String studentEmail = studentScan.next().trim();
        Student student = new Student(studentName, studentNumber, studentEmail);
        return student;
    }

    public Data loadData() throws DataFileNotFoundException, FileFormatException, DataFileCorruptedException {
        try {
            logger.log(Level.INFO, "current directory: " + ROOT);
            ArrayList<Module> modules = new ArrayList<>();
            String fileName = "Database" + TXTFILE;
            Path filePath = Paths.get(ROOT, "Database", fileName);
            File databaseFile = new File(filePath.toString());
            Scanner scanner = new Scanner(databaseFile);
            int numberOfModules = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numberOfModules; i++) {
                Module module = loadModule(scanner, numberOfModules);
                modules.add(module);
            }
            Data data = new Data(modules);
            return data;
        } catch (FileNotFoundException e) {
            throw new DataFileNotFoundException();
        } catch (StringIndexOutOfBoundsException e) {
            throw new FileFormatException();
        }
    }

    public Answer loadAnswer(String assignmentName, String moduleCode) throws DataFileNotFoundException,
            NumbersMisalignException, FileFormatException {
        Answer answerKey;
        ArrayList<String> answersArray = new ArrayList<>();
        ArrayList<Integer> marksArray = new ArrayList<>();
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
                String answerAndMarks = line.substring(answerDividerIndex + DIVIDER_LENGTH);
                int marksDividerIndex = answerDividerIndex + DIVIDER_LENGTH + answerAndMarks.indexOf(ANSWER_DIVIDER);
                String answer = line.substring(answerDividerIndex + DIVIDER_LENGTH, marksDividerIndex).trim();
                String marksString = line.substring(marksDividerIndex + DIVIDER_LENGTH).trim();
                answersArray.add(answer);
                if (marksString.equals("")) {
                    marksArray.add(0);
                } else {
                    Integer marks = Integer.valueOf(marksString);
                    marksArray.add(marks);
                }
                if (questionNumber != answersArray.size()) {
                    throw new NumbersMisalignException();
                }
            }
        } catch (FileNotFoundException e) {
            throw new DataFileNotFoundException();
        } catch (StringIndexOutOfBoundsException e) {
            throw new FileFormatException();
        } catch (NumberFormatException e) {
            throw new FileFormatException();
        }
        answerKey = new Answer(answersArray, marksArray, answersArray.size());
        return answerKey;
    }

    public ArrayList<String> loadScript(String assignmentName, String moduleCode, String studentNumber) throws
            DataFileNotFoundException, NumbersMisalignException, FileFormatException {
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
        } catch (StringIndexOutOfBoundsException e) {
            throw new FileFormatException();
        }
        return answersArray;
    }

    public boolean findStudentScript(String assignmentName, String moduleCode, String studentNumber) {
        String fileName = moduleCode + UNDERSCORE + assignmentName + UNDERSCORE + studentNumber + TXTFILE;
        Path filePath = Paths.get(ROOT, "scripts", fileName);
        File scriptFile = new File(filePath.toString());
        boolean exists = scriptFile.exists();
        return exists;
    }
}

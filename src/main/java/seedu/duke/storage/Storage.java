package seedu.duke.storage;

import seedu.duke.data.assignment.Assignment;
import seedu.duke.data.assignment.LongAnswerAssignment;
import seedu.duke.data.assignment.ShortAnswerAssignment;
import seedu.duke.data.assignment.McqAssignment;
import seedu.duke.data.assignment.Answer;
import seedu.duke.data.Data;
import seedu.duke.data.lesson.Lesson;
import seedu.duke.data.module.Module;
import seedu.duke.data.student.Student;
import seedu.duke.exception.AnswerTooLongException;
import seedu.duke.exception.DataFileCorruptedException;
import seedu.duke.exception.DataFileNotFoundException;
import seedu.duke.exception.FileNotSavedException;
import seedu.duke.exception.FileFormatException;
import seedu.duke.exception.InvalidQuestionNumberException;
import seedu.duke.exception.MarkTooLargeException;
import seedu.duke.exception.MissingAnswerException;
import seedu.duke.exception.MissingMarksException;
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

/**
 * Storage class which interfaces with the database .txt files of the program.
 */
public class Storage {

    private static final String ROOT = System.getProperty("user.dir");
    private static final Path ANSWER_DIR_PATH = Paths.get(ROOT, "answers");
    private static final Path SCRIPT_DIR_PATH = Paths.get(ROOT, "scripts");
    private static final Path DATABASE_DIR_PATH = Paths.get(ROOT, "Database");
    private static final String ANSWER_DIVIDER = "|";
    private static final int LINE_START = 0;
    private static final int DIVIDER_LENGTH = 1;
    private static final String UNDERSCORE = "_";
    private static final String TXTFILE = ".txt";
    private static Logger logger = Logger.getLogger(Storage.class.getName());

    /**
     * Constructor method for storage.
     * Makes a Database.txt file if one is not found in the project directory.
     */
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

    /**
     * Saves the user's existing data for the current session into the database.
     * @param data object from the user's existing session
     * @throws FileNotSavedException if an error is encountered during the saving process
     */
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

    /**
     * Loads a module from database.
     * @param scanner to be scanned for a module
     * @return a module that was previously stored in the database
     * @throws DataFileCorruptedException if the data file is not being loaded successfully
     */
    private Module loadModule(Scanner scanner) throws DataFileCorruptedException {
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
            for (Assignment checkAssignment: module.getAssignments()) {
                if (assignment.getName().equals(checkAssignment.getName())) {
                    throw new DataFileCorruptedException();
                }
            }
            module.addAssignment(assignment);
        }
        for (int j = 0; j < numberOfLessons; j++) {
            Lesson lesson = loadLesson(scanner);
            for (Lesson checkLesson : module.getLessons()) {
                if (lesson.equals(checkLesson)) {
                    throw new DataFileCorruptedException();
                }
            }
            module.addLesson(lesson);
        }
        for (int j = 0; j < numberOfStudents; j++) {
            Student student = loadStudent(scanner);
            for (Student checkStudent : module.getStudents()) {
                if (student.getName().equals(checkStudent.getName())
                        || student.getStudentNumber().equals(checkStudent.getStudentNumber())
                        || student.getEmail().equals(checkStudent.getEmail())) {
                    throw new DataFileCorruptedException();
                }
            }
            module.addStudent(student);
        }
        return module;
    }

    /**
     * Loads an assignment from database.
     * @param scanner to be scanned for a module
     * @return an assignment that was previously stored in the database
     * @throws DataFileCorruptedException if the data file is not being loaded successfully
     */
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

    /**
     * Loads a lesson from database.
     * @param scanner to be scanned for a module
     * @return a lesson that was previously stored in the database
     * @throws DataFileCorruptedException if the data file is not being loaded successfully
     */
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

    /**
     * Loads a student from the database.
     * @param scanner to be scanned for a module
     * @return a student that was previously stored in the database
     */
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

    /**
     * Loads all data from a database.
     * @return Data object containing all data saved from the previous session
     * @throws DataFileNotFoundException if the data file cannot be found
     * @throws FileFormatException if there are issues with loading the file format
     * @throws DataFileCorruptedException if the data file is corrupted with unexpected inputs or formatting
     */
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
                Module module = loadModule(scanner);
                for (Module checkModule : modules) {
                    if (module.getModuleCode().equals(checkModule.getModuleCode())) {
                        throw new DataFileCorruptedException();
                    }
                }
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

    /**
     * Loads answer for a particular assignment from the database.
     * @param assignmentName name of the assignment
     * @param moduleCode module code of the module with this assignment
     * @return Answer object containing information of answers to an assignment
     * @throws DataFileNotFoundException if the data file cannot be found
     * @throws NumbersMisalignException if the numbers misalign is found
     * @throws FileFormatException if an error is encountered when loading the file
     * @throws InvalidQuestionNumberException if the question number is invalid
     * @throws MarkTooLargeException if the marks for a student is larger than the threshold
     * @throws MissingMarksException if there are missing marks for an assignment
     * @throws MissingAnswerException if there are missing answers for an assignment
     * @throws AnswerTooLongException if the answer set is too long
     */
    public Answer loadAnswer(String assignmentName, String moduleCode) throws DataFileNotFoundException,
            NumbersMisalignException, FileFormatException, InvalidQuestionNumberException,
            MarkTooLargeException, MissingMarksException, MissingAnswerException, AnswerTooLongException {
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
                String answerAndMarks = line.substring(answerDividerIndex + DIVIDER_LENGTH);
                int marksDividerIndex = answerDividerIndex + DIVIDER_LENGTH + answerAndMarks.indexOf(ANSWER_DIVIDER);
                String answer = line.substring(answerDividerIndex + DIVIDER_LENGTH, marksDividerIndex).trim();
                if (answer.equals("")) {
                    throw new MissingAnswerException(assignmentName);
                }
                if (answer.length() > 100) {
                    throw new AnswerTooLongException(assignmentName);
                }
                String marksString = line.substring(marksDividerIndex + DIVIDER_LENGTH).trim();
                answersArray.add(answer);
                if (marksString.equals("")) {
                    throw new MissingMarksException(assignmentName);
                } else {
                    if (marksString.length() > 5) {
                        throw new MarkTooLargeException(assignmentName);
                    }
                    Integer marks = Integer.valueOf(marksString);
                    if (marks < 0) {
                        throw new MarkTooLargeException(assignmentName);
                    }
                    marksArray.add(marks);
                }
                String questionNumberString = line.substring(LINE_START, answerDividerIndex).trim();
                int questionNumber = Integer.parseInt(questionNumberString);
                if (questionNumber != answersArray.size()) {
                    throw new NumbersMisalignException(assignmentName);
                }
            }
        } catch (FileNotFoundException e) {
            throw new DataFileNotFoundException(assignmentName);
        } catch (StringIndexOutOfBoundsException e) {
            throw new FileFormatException(assignmentName);
        } catch (NumberFormatException e) {
            throw new InvalidQuestionNumberException(assignmentName);
        }
        answerKey = new Answer(answersArray, marksArray, answersArray.size());
        return answerKey;
    }

    /**
     * Loads a student's script from the project directory.
     * @param assignmentName name of assignment for student's script to be loaded
     * @param moduleCode module code of the module for assignment to be graded
     * @param studentNumber student number of the student whose script is to be loaded
     * @return an arraylist of answers
     * @throws DataFileNotFoundException if the data file cannot be found
     * @throws NumbersMisalignException if the numbers misalign is found
     * @throws FileFormatException if an error is encountered when loading the file
     * @throws InvalidQuestionNumberException if the question number is invalid
     * @throws AnswerTooLongException if the answer set is too long
     */
    public ArrayList<String> loadScript(String assignmentName, String moduleCode, String studentNumber) throws
            DataFileNotFoundException, NumbersMisalignException, FileFormatException, InvalidQuestionNumberException,
            AnswerTooLongException {
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
                if (answer.length() > 100) {
                    throw new AnswerTooLongException(studentNumber);
                }
                answersArray.add(answer);
                if (questionNumber != answersArray.size()) {
                    throw new NumbersMisalignException(studentNumber);
                }
            }
        } catch (FileNotFoundException e) {
            throw new DataFileNotFoundException(studentNumber);
        } catch (StringIndexOutOfBoundsException e) {
            throw new FileFormatException(studentNumber);
        } catch (NumberFormatException e) {
            throw new InvalidQuestionNumberException(studentNumber);
        }
        return answersArray;
    }

    /**
     * Finds the student's script for the project's directory.
     * @param assignmentName name of assignment
     * @param moduleCode module code of module containing the assignment
     * @param studentNumber student number of student whose script is to be loaded
     * @return a boolean indicating whether the student's script has been found or not
     */
    public boolean findStudentScript(String assignmentName, String moduleCode, String studentNumber) {
        String fileName = moduleCode + UNDERSCORE + assignmentName + UNDERSCORE + studentNumber + TXTFILE;
        Path filePath = Paths.get(ROOT, "scripts", fileName);
        File scriptFile = new File(filePath.toString());
        boolean exists = scriptFile.exists();
        return exists;
    }
}

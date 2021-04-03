# Developer Guide

## Design

### Architecture

The **Architecture Design** given above explains the high-level design of the App.
Given below is a quick overview of each component. </br>

`Modman` is the main class of the application, and handles the app launch,
initializing the appropriate classes to be used. </br>

The rest of the app consists of four components:

* Logic
* UI
* Storage
* Data

**How the four architecture components interact with each other and the ModMan class**

The *Sequence diagram* below shows the interaction between components for when the user issues the command `add module CS2113T`

![](uml/ArchitectureSequenceDiagram.png)

The sections below give more details of each component.


## Logic Component 

![logic](uml/ParserAndCommandComponent.png)

1. `Logic` uses the `Parser` class to parse the user command.
2. This creates a `Command` object which is executed in `Modman`.
3. The command execution can affect the state of the `Data` and `Storage` components. For example, the `AddModuleCommand` adds a new `Module` object in `Data`.
4. The `Command` object can also instruct the `Ui` to list and display information to the user.

Given below is the sequence diagram for creating the corresponding `Command` object from user input via `Parser`. </br>
The sequence diagram also acts as a reference frame for `getCommand` which is common across most `Command` objects.

![getCommand](uml/getCommand.png)

If a `Command` does not use the reference frame, another sequence diagram would be used to describe how the `Command` object was created.

## UI Component
The UI Component consists of one class - `Ui` which provides all the functions
required to print different kinds of messages on te console.

1. `Ui` is class with a `Scanner` object that reads input from console.
1. `Modman` has `Ui` object as an attribute which is instantiated
   when we enter the program.
1. `Ui` object reads input from screen and returns it which will then be passed to the Parser so that it can
   parse the command.
1. Depending on the parsed command, the corresponding
   `execute()` function of the  `Command` abstract class
   runs. It accepts `Ui` object as a parameter and calls the relevant `Ui` methods
   that prints the messages.
   <br>
   <br>

Given below is the Sequence Diagram for the Storage class. The storage class interacts with the database file, storing our data into the database or loading our data from the database. </br>
## Storage Component (Bryan)
![Storage](uml/StorageClassDiagram.png)

1. The `Storage` class is used to interact with the database.txt file by calling loadData() at the start of the program and calling saveData() at the end of the program.
2. The `Storage` class will collect the data of all classes that implements the Storable interface so that these data can be saved to the database.
3. The `toStorage()` method of the Storable interface will return a string representing the object instance's data. 
4. This string will then be appended to the database.txt file.

## Data Component

![Data](uml/Data.png)

The `Data`,
* stores an `ArrayList` of `Module` objects that represents the modules.
* Each `Module` object contains `ArrayLists` of `Assignment`, `Lesson`, and `Student` objects.

## Implementation

### Editing Assignment Information (Jianning and Bryan)

This section provides details on the implementation of the various commands that modify the `Assignment` object.

There are 4 attributes of the `Assignment` object in which the User can interact with:

1. Deadline - `LocalDate` representing the date which assignment should be graded by.
2. Percentage - `float` of the percentage of the overall grade which the assignment carries.
3. Students' Grades - `HashMap<String, Float>` of the students' grades for the assignment, where the key is the Student/Matric Number and the value is the Grade out of 100%.
4. Comments - `String` representing comments for particular questions and/or the overall assignment.

### `SetAssignmentDeadlineCommand`

The `SetAssignmentDeadlineCommand` is used to set or update the deadline which the `Assignment` has to be graded by. 
The deadline can then be used to sort the assignments based on the urgency of the grading.

Given below is the sequence diagram for the `SetAssignmentDeadlineCommand`:

![DeadlineCommand](uml/SetDeadline.png)

| :information_source: |  deadline passed into the setDeadline() function is of type `LocalDate` |
|----------------------|-------------------------------------|

Implementation considerations for using `LocalDate` for deadline attribute in `Assignment`:

* `LocalDate` is an immutable class that represents dates with a default format of yyyy-MM-dd
* `LocalDate` allows for standardisation of format and representation of deadlines
* `LocalDate` has a built in compareTo() method that allows us to compare two dates
* `LocalDate` allows us to easily sort `Assignment` objects by the deadline attribute

### `SetAssignmentGradeCommand`

The `SetAssignmentGradeCommand` is used to 

Given below is the sequence diagram for the `SetAssignmentGradeCommand`:

Implementation considerations for using `HashMap<String, Float>` to store students'grades:


### Sorting Assignments by Deadline (Jianning)

The `SortAssignmentByDeadlineCommand` is used to reorder the ArrayList of `Assignment` objects stored in the current `Module`. </br>

The `Assignment` objects will be sorted based on their deadline attribute, which is of type `LocalDate`. 
The deadline of an `Assignment` object can be `null`, in which case the `Assignment` will be sorted after other `Assignment` objects with valid `LocalDate` deadlines.
The sorting is also stable, and will retain the initial order of when the `Assignment` was added to the `Module`. </br> 

The code snippet for the compareTo() function which allows `Assignment` to implement the `Comparable` interface is as follows:

````
    @Override
    public int compareTo(Assignment other) {
        if (this.getDeadline() == null && other.getDeadline() == null) {
            return 0;
        } else if (this.getDeadline() == null) {
            return 1;
        } else if (other.getDeadline() == null) {
            return -1;
        }
        return this.getDeadline().compareTo(other.getDeadline());
    }
````
| :information_source: | Modifying the compareTo() function allows you to easily change the natural ordering of the objects of the `Assignment` Class. </br> Other attributes can also be added to `Assignment`objects in the future to be used for comparing. |
|----------------------|-------------------------------------|


Given below is the sequence diagram for the `SortAssignmentsByDeadlineCommand`:

![sortCommand](uml/SortAssignmentsSeq.png)


### Listing Student Grades for  (Jianning)


### Autograding Assignments (Jianning)

The `AutogradeAssignmentCommand` is used to automatically grade all current students' scripts and save the grades </br>
Also used to keep track of which students have not submitted assignments

![AutogradeCommand](uml/Autograde.png)


[Coming soon] Get statistics from Autograde



### Adding Lesson to Module Timetable



## Product scope
### Target user profile:
* Teaching assistants who: 
    * have a need to manage their module(s), students and assignments
    * are comfortable using CLI apps
{Describe the target user profile}

### Value proposition

Just to keep track of all informaiton pertaining to a module teaching assistants (at NUS) have to make use of multiple platforms:
* LumiNUS
* NUSMods 
* Module websites 
* Spreadsheets 

With the help of ModMan, users will be able to add, edit, and store all information on one platform, simplifying the process. In addition, features such as autograding and saving comments for assignments will free up time, allowing TAs to focus on teaching!



## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

1. The application should work on any *mainstream* operating system (e.g. Windows, Linux, macOS) 
   with `Java 11` installed.
1. The application should be responsive and users should not face any sluggish performance.
1. Users who are above average in typing speed (in English) should be able to easily issue commands faster than using a mouse.


## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

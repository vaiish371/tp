# ModMan User Guide

## Introduction
````
 __  __           _   __  __ 
|  \/  |         | | |  \/  |
| \  / | ___   __| | | \  / | __ _ _ __
| |\/| |/ _ \ / _  | | |\/| |/ _  |  _ \
| |  | | (_) | (_| | | |  | | (_| | | | |
|_|  |_|\___/ \__'_| |_|  |_|\__'_|_| |_|
````
ModMan, short for Module Manager, is a desktop app designed to help Teaching Assistants (TAs) manage their module(s).
It is optimized for use via a Command Line Interface (CLI). ModMan helps to track module details as well as students’ progress and data, all in one platform. It can also perform autograding for MCQ assignments.

### What is a CLI?
A command line interface (CLI) is a text-based user interface used to view and manage computer files.

These include operating system CLIs like the Command Prompt on Windows, which can be used to run and interact with the ModMan application.

## How to use the User Guide
Welcome to the User Guide for ModMan!

Regardless if you are a teaching assistant, student or lecturer, this guide would be helpful for you in picking up and using ModMan.

* You may navigate to any subsection from the [Table of contents](#table-of-contents).
* Scroll down or click [here](#1-quick-start) for the Quick Start guide to get started now.
* [FAQ](#3-faq) and [Command Summary](#4-command-summary) are available for quick queries or reference.

### Legend
A short description of the icons that are used in this User Guide.

Icon | Purpose
------ | ----------------
| :information_source: | Explainers on how to use and interpret the User Guide |
| :warning: | Warnings on usage of ModMan |

## Table of contents
1. [Quick start](#1-quick-start)
1. [Features](#2-features) <br>
    2.1 [`help` - Listing Basic Commands](#21-listing-basic-commands-help) <br>
    2.2 [`add module` - Adding a Module](#22-adding-a-module-add-module) <br>
    2.3 [`remove module` - Removing a Module](#23-removing-a-module-remove-module) <br>
    2.4 [`select` - Selecting a Module](#24-selecting-a-module-select) <br>
    2.5 [`current` - Viewing Current Module](#25-viewing-current-module-current) <br>
    2.6 [`list module` - Listing Modules](#26-listing-modules-list-module) <br>
    2.7 [`add student` - Adding a Student](#27-adding-a-student-add-student) <br>
    2.8 [`list student details` - Listing Students Details](#28-listing-students-details-list-student-details) <br>
    2.9 [`list student` - Listing Students in Module](#29-listing-students-in-module-list-student-) <br>
    2.10 [`add timetable` - Adding a Lesson](#210-adding-a-lesson-add-timetable) <br>
    2.11 [`list timetable` - Listing Timetable Lessons](#211-listing-timetable-lessons-list-timetable) <br>
    2.12 [`delete timetable` - Removing Timetable Lessons](#212-removing-timetable-lessons-delete-timetable) <br>
    2.13 [`edit timetable` - Editing a Timetable Lesson](#213-editing-timetable-lessons-edit-timetable) <br>
    2.14 [`add assignment` - Adding an Assignment](#214-adding-an-assignment-add-assignment) <br>
    2.21 [`set deadline` - Setting Assignment Deadline](#221-setting-assignment-deadline--set-deadline) <br>
    2.15 [`list assignments` - Listing Module Assignments](#215-listing-module-assignments--list-assignments) <br>
    2.16 [`sort assignments by deadline` - Sorting Module Assignments](#216-sorting-module-assignments--sort-assignments-by-deadline) <br>
    2.17 [`edit assignment` - Editing an Assignment Name](#217-editing-an-assignment-name-edit-assignment-name) <br> 
    2.18 [`set assignment percentage` - Setting Assignment Percentage of Overall Grade](#218-setting-assignment-percentage-set-assignment-percentage) <br>
    2.19 [`set assignment comments` - Setting Assignment Comments](#219-setting-assignment-comments-set-assignment-comments) <br>
    2.20 [`get assignment comments` - Getting Assignment Percentage](#220-getting-assignment-comments-get-assignment-comments) <br>
    2.22 [`list grades` - Listing Assignment Grades](#222-listing-assignment-grades--list-grades) <br>
    2.23 [`autograde` - Auto-Grading Assignments](#223-auto-grading-assignments--autograde) <br>
    2.24 [`bye` - Exiting ModMan](#224-exiting-modman--bye) <br>
1. [FAQ](#3-faq)
1. [Command summary](#4-command-summary)

## 1. Quick Start

1. Ensure you have Java 11 installed on your computer or install it from [here](https://www.oracle.com/sg/java/technologies/javase-jdk11-downloads.html).
1. Download the latest `ModMan.jar` release from [here](https://github.com/AY2021S2-CS2113T-F08-1/tp/releases/tag/v2.0).
1. Open a command window in the folder containing the `.jar` file.
1. Run the command `java -jar {filename}.jar` <br> If you haven't changed the filename, run the command `java -jar ModMan.jar`


## 2. Features 

| :information_source: | Inputs in `UPPER_CASE` are parameters to be supplied by the user. |
|----------------------|-------------------------------------|

***
### 2.1 Listing Basic Commands: `help`
This command is available for you to get a quick reference of all the basic commands available in ModMan, and their usages.
You can invoke `help` any time you are unsure of the basic commands and their formats.

Format: `help`

Expected output:

```` 
--------------------------------------------------------------------------
    Here are the list of basic commands you can use:
 
	1. add module MODULE_NAME - to add a module
	2. select MODULE_NAME - to select a module directory from the list of modules.
	3. add student /s STUDENT_NAME /# STUDENT_NUMBER /e STUDENT_EMAIL - to add a student to a module
	4. add timetable /t TYPE /v VENUE /d DAY /s START_TIME /e END_TIME - to add a lesson
	5. add assignment /t TYPE_OF_ASSIGNMENT /a ASSIGNMENT_NAME - to add an assignment
	6. set deadline /a ASSIGNMENT_NAME /d DEADLINE - to set deadline for an assignment
	7. autograde /a ASSIGNMENT_NAME - to auto-grade all student scripts for assignment
	8. set assignment comments /a ASSIGNMENT_NAME /c COMMENT - to set feedback for an assignment
	9. remove module MODULE_NAME - to remove a module off the list
	10. bye - to exit the program and save all your information

    For the full list of commands, check out the User Guide at: https://ay2021s2-cs2113t-f08-1.github.io/tp/UserGuide.html

-------------------------------------------------------------------------- 
`````
Please note that it does not display the full list of commands (due to there being so many!). 
You may open this User Guide for a comprehensive list.

### 2.2 Adding a Module: `add module`

Adds a new module to the list of modules.

Format: `add module MODULE_NAME`

Example of usage:

`add module CS2113T`

Expected output:

```` 
--------------------------------------------------------------------------
    I have added a new module: CS2113T
-------------------------------------------------------------------------- 
````
***

### 2.3 Removing a Module: `remove module`

Removes a module from the list of modules.

Format: `remove module MODULE_NAME`

Example of usage:

`remove module CS2113T`

Expected output:

```` 
--------------------------------------------------------------------------
    You have successfully removed module: CS2113T
-------------------------------------------------------------------------- 
````
***

### 2.4 Selecting a Module: `select`

Select the module you want to currently work in.

Format: `select MODULE_NAME`

Example of usage:

`select CS2113T`

Expected output:

```` 
--------------------------------------------------------------------------
    Success! You are now working in: CS2113T
-------------------------------------------------------------------------- 
````

| :information_source: | All commands onwards assumes we are working in the module CS2113T |
|----------------------|-------------------------------------|
***
### 2.5 Viewing Current Module: `current`

View the current module you are working in. Also obtain an overview of the current module.

Format: `current`

Expected output:

```` 
--------------------------------------------------------------------------
    You are currently working in: CS2113T

	Here's an overview of CS2113T
	    - You have not added any lessons yet.

		- You currently have 0 students in your class

		- You have not added any assignments to yet.
-------------------------------------------------------------------------- 
````
***
### 2.6 Listing Modules: `list module`

Lists all the modules you have added, and specifies the current module (if any).

Format: `list module`

Expected output:

```` 
--------------------------------------------------------------------------
    Here are your modules: 
	1. CS2113T (current)
-------------------------------------------------------------------------- 
````
***
### 2.7 Adding a student: `add student`

Assigns a new student to the current module you have selected.

Format: `add student /s STUDENT_NAME /# STUDENT_NUMBER /e STUDENT_EMAIL`

Example of usage:

`add student /s Bryan Wong /# A0123456Y /e e0123456@u.nus.edu`

Expected output:
```
---------------------------------------------------------------------
    I have assigned a new student to CS2113T:
    Bryan Wong, A0123456Y, e0123456@u.nus.edu
---------------------------------------------------------------------
```
***

### 2.8 Listing Students Details: `list student details`

Lists the details of all students enrolled in a particular module.

Format: `list student details`

Example of usage:

`list student details`

Expected output:

```` 
--------------------------------------------------------------------------
    Here are the students of all students enrolled in CS2113T:
    1. Bryan Wong, A0123456Y, e0123456@u.nus.edu
-------------------------------------------------------------------------- 
````
***

### 2.9 Listing Students in Module: `list student `
Lists the names of students assigned to the current module you have selected.

Format: `list student`

Example of usage:

`list student`

Expected output:
```
---------------------------------------------------------------------
    Here are the students in CS2113T:
    1. Bryan
---------------------------------------------------------------------
```
***

### 2.10 Adding a Lesson: `add timetable`
Adds a new lesson to the list (timetable) of lessons for the module you have selected.

Format: `add timetable /t TYPE /v VENUE /d DAY /s START_TIME /e END_TIME`

* The `TYPE` and `VENUE` can be in a natural language format.
* The `DAY` must be a valid day spelt out fully in caps eg. `MONDAY`.  
* The `START_TIME` and `END_TIME` must be in the format `HHmm` eg. `1800`.
* `START_TIME` must be before `END_TIME`

:warning: All flags (`/t`, `/v` etc.) must be included in the order specified above.

:warning: Note the spacing before and after each flag eg. `/t TYPE /v ...`; Input would be truncated if spaces are not present.</br>
For example :
* `/t /v...`: Only one space between flags, second flag would not be recognised. Incorrect number of parameter error may be thrown.
* `.../s 1600/e 1800`: `START_TIME` will be parsed as `160` and wrong time error may be thrown.

:warning: Input `2400` for `START_TIME` and `END_TIME` would be interpreted as `00:00`.

Example of usage:

`add timetable /t Lecture /v Zoom /d FRIDAY /s 1600 /e 1800`

Expected output:
```
---------------------------------------------------------------------
    Success! I have added the following timetable for the module - CS2113T
    Lecture: FRIDAY, 16:00-18:00 (Zoom)
---------------------------------------------------------------------
```
***

### 2.11 Listing Timetable Lessons: `list timetable`
Lists the lessons in the timetable for the module you have selected.

Format: `list timetable`

* The `START_TIME` and `END_TIME` will be listed in the format `HH:mm` eg. `18:00`.

Expected output:
```
---------------------------------------------------------------------
    Here are the lessons in CS2113T:
    1. Lecture: FRIDAY, 16:00-18:00 (Zoom)
---------------------------------------------------------------------
```
***

### 2.12 Removing Timetable Lessons: `delete timetable`
Deletes the lessons in the timetable corresponding to the index for the module you have selected.

Format: `delete timetable LESSON_INDEX`

Example usage:

`delete timetable 1`

Expected output:
```
---------------------------------------------------------------------
    You have successfully removed lesson: FRIDAY, 16:00-18:00 from CS2113T
---------------------------------------------------------------------
```
***

### 2.13 Editing Timetable Lessons: `edit timetable`
Edits the lessons in the timetable corresponding to the index for the module you have selected.

Format: `edit timetable LESSON_INDEX /t TYPE /v VENUE /d DAY /s START_TIME /e END_TIME`

* You may enter `-` for the field(s) you do not wish to change.
  * `-` input would be trimmed for whitespaces.
* The `TYPE` and `VENUE` can be in a natural language format.
* The `DAY` must be a valid day spelt out fully in caps eg. `MONDAY`.
* The `START_TIME` and `END_TIME` must be in the format `HHmm` eg. `1800` if specified.
* `START_TIME` must be before `END_TIME`
* The parameters cannot be empty or whitespaces.

:warning: All flags (`/t`, `/v` etc.) must be included in the order specified above.

:warning: Note the spacing before and after each flag eg. `/t TYPE /v ...`; Input would be truncated if spaces are not present.</br>
For example:
* `/t /v...`: Only one space between flags, second flag would not be recognised. Incorrect number of parameter error may be thrown.
* `.../s 1600/e 1800`: `START_TIME` will be parsed as `160` and wrong time error may be thrown.

:warning: Input `2400` for `START_TIME` and `END_TIME` would be interpreted as `00:00`.

Example of usage:

Changing the day to Monday: `edit timetable 1 /t - /v - /d MONDAY /s - /e -`

Expected output:
```
---------------------------------------------------------------------
    You have successfully edited the lesson to:
    Lecture: MONDAY, 16:00-18:00 (Zoom)
---------------------------------------------------------------------
```
***

### 2.14 Adding an Assignment: `add assignment`

Adds an assignment to the module that is current selected by the user. 

:warning: The parameter /t allows for only 3 types of assignment: "la" (which stands for Long Assignments), "sa" (which stands for Short Assignments) and "mcq" (which stands for Multiple Choice Question Assignments).

Format: `add assignment /t TYPE_OF_ASSIGNMENT /a ASSIGNMENT_NAME`

Examples of usage:
* `add assignment /t mcq /a Magic Sequence`
* `add assignment /t la /a recursion`

Expected output:

```
---------------------------------------------------------------------
    I have added a new assignment to CS2113T:
    Magic Sequence
---------------------------------------------------------------------
```
***

### 2.15 Listing Module Assignments : `list assignments` 

Lists out all assignments in the module along with the due date if the deadline was set.

Format: `list assignment`

Expected output:
```
---------------------------------------------------------------------
    Here are the assignments in CS2113T:
    1. quiz1 (due by: Aug 17 2021)
    2. quiz2 (due by: Aug 16 2021)
    3. quiz3 (due by: Aug 20 2021)
---------------------------------------------------------------------
```
***
### 2.16 Sorting Module Assignments : `sort assignments by deadline` 

Sorts all assignments in the module by their deadline. <br/>
If no deadline was set, the assignment will be sorted after those with deadlines.

Format: `sort assignments by deadline`

Expected output:
```
---------------------------------------------------------------------
    Here are the assignments in CS2113T:
    1. quiz2 (due by: Aug 16 2021)
    2. quiz1 (due by: Aug 17 2021)
    3. quiz3 (due by: Aug 20 2021)
---------------------------------------------------------------------
```

Given below is an example usage scenario and how the sorting mechanism behaves.

Step 1. The user launches the application. The CS2113T module has an assignment quiz1 due on 17 Aug 2021.
Step 2. The user adds 2 more assignments quiz2 and quiz3
Step 3. The user only sets the deadline for quiz3 to be 16 Aug 2021.
Step 4. The user executes `sort by deadline` which reorders the assignments in CS2113T to be quiz3, quiz1 and quiz2.
Assignments with null as deadline are sorted behind assignments with deadlines.

***

### 2.17 Editing an Assignment Name: `edit assignment name`

Edits the assignment name of an existing assignment

Format: `edit assignment name /a OLD_ASSIGNMENT_NAME /n NEW_ASSIGNMENT_NAME`

Examples of usage:
* `edit assignment name /a Magic Sequence /n Forest Fruits`
* `edit assignment name /a recursion /n iteration`

Expected output:

```
---------------------------------------------------------------------
    I have updated your assignment name:
    Forest Fruits
---------------------------------------------------------------------
```

***

### 2.18 Setting Assignment Percentage: `set assignment percentage`

Sets the assignment percentage of an existing assignment

Format: `set assignment percentage /a ASSIGNMENT_NAME /p PERCENTAGE`

Examples of usage:
* `set assignment percentage /a Magic Sequence /p 15`
* `set assignment percentage /a Forest Fruits /p 25.0`

Expected output:

```
---------------------------------------------------------------------
    I have set Magic Sequence's percentage to 15.0 in CS2113T
---------------------------------------------------------------------
```

***

### 2.19 Setting Assignment Comments: `set assignment comments`

Sets the assignment comments of an existing assignment

Format: `set assignment comments /a ASSIGNMENT_NAME /c COMMENTS`

Examples of usage:
* `set assignment comments /a Magic Sequence /p This assignment is well done.`
* `set assignment comments /a Forest Fruits /p Most people did not solve this assignment in full.`

Expected output:

```
---------------------------------------------------------------------
    I have added a comment to Magic Sequence:
        This assignment is well done.
---------------------------------------------------------------------
```

***

### 2.20 Getting Assignment Comments: `get assignment comments`

Gets the assignment comments of an existing assignment and prints it out for the user.

Format: `get assignment comments /a ASSIGNMENT_NAME`

Example of usage:

`get assignment comments /a Magic Sequence`

Expected output:

```
---------------------------------------------------------------------
    Your previous comments for Magic Sequence are as follows:
        1. This assignment is well done.
---------------------------------------------------------------------
```

***

### 2.21 Setting Assignment Deadline : `set deadline` 

Sets the deadline the assignment has to be graded by. 
If a deadline had previously been set, it will be updated by the new deadline.

Format: `set deadline /a ASSIGNMENT_NAME /d DEADLINE`

The DEADLINE must be in the format dd MM yyyy eg. 16 08 2021.

Examples of usage:
* `set deadline /a quiz1 /d 17 08 2021`
* `set deadline /a quiz2 /d 16 08 2021`

Expected output:
```
---------------------------------------------------------------------
    I have set quiz1's deadline to Aug 17 2021 in CS2113T
---------------------------------------------------------------------
```
***

### 2.22 Listing Assignment Grades : `list grades` 

Lists the students' grades for a particular assignment.
The students listed are sorted by grades.

Format: `list student assignment grades /a ASSIGNMENT_NAME`

Examples of usage:
* `list student assignment grades /a quiz1`
* `list student assignment grades /a quiz3`

Expected output:
```
---------------------------------------------------------------------
    Here are the students' grades for the quiz1 assignment:
    1. A0214561M - 100.0
    2. A0215114X - 101.0
---------------------------------------------------------------------
```
***

### 2.23 Auto-Grading Assignments : `autograde` 

Auto-grades all student scripts for a particular assignment by comparing against solutions.
Automatically updates student's grades for that assignment.

Format: `autograde /a ASSIGNMENT_NAME`

Example of usage:

`autograde /a quiz1`

Expected output:
```
---------------------------------------------------------------------
    Here are the students' grades for the quiz1 assignment:
    1. A0214561M - 100.0
    2. A0215114X - 101.0
---------------------------------------------------------------------
```
***

### 2.24 Exiting ModMan : `bye`

Auto-saves all your changes and exits the program. ModMan will have all your data ready the next time you load it.

Format: `bye`

Expected output:
```
---------------------------------------------------------------------
    Bye. Hope to see you again soon!
---------------------------------------------------------------------
```
***

## 3. FAQ

**Q**: How do I delete a particular student/assignment? 

**A**: The feature of deletion is still in progress and will be released in our upcoming versions. 


**Q**: When is the data saved to the database?

**A**: It is only saved when you exit the program using the `bye` command.

## 4. Command Summary

Action | Format, Examples
------ | ----------------
help | `help` <br>
add module | `add module MODULE_NAME` <br> e.g. `add module CS2113T`
remove module | `remove module MODULE_NAME` <br> e.g. `remove module CS2113T`
select module | `select MODULE_NAME` <br> e.g. `select CS2113T`
view current module | `current` <br>
list module | `list module` <br>
add student | `add student /s STUDENT_NAME /# STUDENT_NUMBER /e STUDENT_EMAIL` <br> e.g. `add student /s John Doe /# A0123456Y /e e0123456@u.nus.edu`
list student details | `list student details <br> e.g. `list student details`
list student | `list student` <br> 
add timetable | `add timetable /t TYPE /v VENUE /d DAY /s START_TIME /e END_TIME` <br> e.g. `add timetable /t Lecture /v Zoom /d FRIDAY /s 1600 /e 1800`
list timetable | `list timetable` <br> 
delete timetable | `delete timetable LESSON_INDEX` <br> e.g. `delete timetable 1`
edit timetbale | `edit timetable LESSON_INDEX /t TYPE /v VENUE /d DAY /s START_TIME /e END_TIME` <br> e.g. `edit timetable 1 /t - /v COM2 /d - /s 1600 /e 1800` 
add assignment | `add assignment /t TYPE_OF_ASSIGNMENT /a ASSIGNMENT_NAME` <br> e.g. `add assignment /t mcq /a Magic Sequence`
list assignments | `list assignment` <br>
sort assignments | `sort assignments by deadline` <br>
edit assignment | `edit assignment /a OLD_ASSIGNMENT_NAME /n NEW_ASSIGNMENT_NAME` <br> e.g. `edit assignment /t mcq /a Magic Sequence /n Forest Fruits`
set assignment percentage | `set assignment percentage /a ASSIGNMENT_NAME /p PERCENTAGE` <br> e.g. `set assignment percentage /a Magic Sequence /p 15`
set assignment comments | `set assignment comments /a ASSIGNMENT_NAME /c COMMENTS` <br> e.g. `set assignment comments /a Magic Sequence /p This assignment is well done.`
get assignment comments | `get assignment comments /a ASSIGNMENT_NAME` <br> e.g. `get assignment comments /a Magic Sequence`
set deadline | `set deadline /a ASSIGNMENT_NAME /d DEADLINE` <br> e.g. `set deadline /a quiz1 /d 17 08 2021`
list grades | `list student assignment grades /a ASSIGNMENT_NAME` <br> e.g. `list student assignment grades /a quiz1`
autograde | `autograde /a ASSIGNMENT_NAME` <br> e.g. `autograde /a quiz1`
bye | `bye` <br>



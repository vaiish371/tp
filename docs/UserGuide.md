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

## Table of contents
1. [Quick start](#1-quick-start)
1. [Features](#2-features)
    1. [`add module` - Adding a Module](#i-adding-a-module-add-module)
    1. [`remove module` - Removing a Module](#ii-removing-a-module-remove-module)
    1. [`select` - Selecting a Module](#iii-selecting-a-module-select)
    1. [`current` - Viewing Current Module](#iv-viewing-current-module-current)
    1. [`add student` - Adding a Student](#v-adding-a-student-add-student)
    1. [`list student details` - Listing Students Details](#vi-listing-students-details-list-student-details)
    1. [`list student` - Listing Students in Module](#vii-listing-students-in-module-list-student-)    
    1. [`add timetable` - Adding a Lesson](#viii-adding-a-lesson-add-timetable)
    1. [`list timetable` - Listing Timetable Lessons](#ix-listing-timetable-lessons-list-timetable)
    1. [`delete timetable` - Removing Timetable Lessons](#x-removing-timetable-lessons-delete-timetable)
    1. [`edit timetable` - Editing a Timetable Lesson](#xi-editing-timetable-lessons-edit-timetable)
    1. [`add assignment` - Adding an Assignment](#xii-adding-an-assignment-add-assignment)
    1. [`list assignments` - Listing Module Assignments](#xiii-listing-module-assignments--list-assignments)
    1. [`sort assignments` - Sorting Module Assignments](#xiv-sorting-module-assignments--sort-assignments)
    1. [`edit assignment` - Editing an Assignment Name](#xv-editing-an-assignment-name-edit-assignment) 
    1. [`set deadline` - Setting Assignment Deadline](#xvi-setting-assignment-deadline--set-deadline)
    1. [`list grades` - Listing Assignment Grades](#xvii-listing-assignment-grades--list-grades)
    1. [`autograde` - Auto-Grading Assignments](#xviii-auto-grading-assignments--autograde)
 
  
3. [FAQ](#3-faq)
4. [Command summary](#4-command-summary)


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

## 1. Quick Start

1. Ensure you have Java 11 installed on your computer or install it from [here](https://www.oracle.com/sg/java/technologies/javase-jdk11-downloads.html).
1. Download the latest `ModMan.jar` release from [here](https://github.com/AY2021S2-CS2113T-F08-1/tp/releases/tag/v2.0).
1. Open a command window in the folder containing the `.jar` file.
1. Run the command `java -jar {filename}.jar` <br> If you haven't changed the filename, run the command `java -jar ModMan.jar`


## 2. Features 

| :information_source: | Inputs in `UPPER_CASE` are parameters to be supplied by the user. |
|----------------------|-------------------------------------|

***
### i. Adding a Module: `add module`

Adds a new module to the list of modules.

Format: `add module MODULE_NAME`

Example of usage:

`add module CS2113T`

`add module CS2101`

Expected output :

```` 
--------------------------------------------------------------------------
    I have added a new module: CS2113T
-------------------------------------------------------------------------- 
````
***
### ii. Removing a Module: `remove module`

Removes a module from the list of modules.

Format: `remove module MODULE_NAME`

Example of usage:

`remove module CS2113T`

Expected output :

```` 
--------------------------------------------------------------------------
    You have successfully removed module: CS2113T
-------------------------------------------------------------------------- 
````
***
### iii. Selecting a Module: `select`

Select the module you want to currently work in.

Format: `select MODULE_NAME`

Example of usage:

`select CS2113T`

Expected output :

```` 
--------------------------------------------------------------------------
    Success! You are now working in: CS2113T
-------------------------------------------------------------------------- 
````

| :information_source: | All commands onwards assumes we are working in the module CS2113T |
|----------------------|-------------------------------------|
***
### iv. Viewing Current Module: `current`

View the current module you are working in.

Format: `current`

Expected output :

```` 
--------------------------------------------------------------------------
    You are currently working in: CS2113T
-------------------------------------------------------------------------- 
````
***
### v. Adding a student: `add student`

Assigns a new student to the current module you have selected.

Format: `add student /s STUDENT_NAME /# STUDENT_NUMBER /e STUDENT_EMAIL`

Example of usage:

`add student /s John Doe /# A0123456Y /e e0123456@u.nus.edu`

Expected output :
```
---------------------------------------------------------------------
I have assigned a new student to CS2113T:
John Doe, A0123456Y, e0123456@u.nus.edu
---------------------------------------------------------------------
```
***

### vi. Listing Students Details: `list student details`

Lists the details of all students enrolled in a particular module.

Format: `list student details`

Example of usage:

`list student details`

Expected output :

```` 
--------------------------------------------------------------------------
    Here are the students of all students enrolled in CS2113T:
    1. Vaishnavi, A0208551J, vaiish371@gmail.com
    2. Emily, A0888888J, emily@gmail.com
-------------------------------------------------------------------------- 
````
***

### vii. Listing Students in Module: `list student `
Lists the names of students assigned to the current module you have selected.

Format: `list student`

Example of usage:

`list student`

Expected output :
```
---------------------------------------------------------------------
 Here are the students in CS2113T:
 1. Vaishnavi
 2. Emily
---------------------------------------------------------------------
```
***

### viii. Adding a Lesson: `add timetable`
Adds a new lesson to the list (timetable) of lessons for the module you have selected.

Format: `add timetable /t TYPE /v VENUE /d DAY /s START_TIME /e END_TIME`

* The `TYPE` and `VENUE` can be in a natural language format.
* The `DAY` must be a valid day spelt out fully in caps eg. `MONDAY`.  
* The `START_TIME` and `END_TIME` must be in the format `HHmm` eg. `1800`.
* `START_TIME` must be before `END_TIME`

:warning: All flags (`/t`, `/v` etc.) must be included in the order specified above.

:warning: Note the spacing before and after each flag eg. `/t TYPE /v`; Input would be truncated if spaces are not present.

:warning: Input `2400` for `START_TIME` and `END_TIME` would be interpreted as `00:00`.

Examples:
* `add timetable /t Lecture /v Zoom /d FRIDAY /s 1600 /e 1800`

Expected output :
```
---------------------------------------------------------------------
Success! I have added the following timetable for the module - CS2113T
Lecture: FRIDAY, 16:00-18:00 (Zoom)
---------------------------------------------------------------------
```
***

### ix. Listing Timetable Lessons: `list timetable`
Lists the lessons in the timetable for the module you have selected.

Format: `list timetable`

* The `START_TIME` and `END_TIME` will be listed in the format `HH:mm` eg. `18:00`.

Expected output :
```
---------------------------------------------------------------------
Here are the lessons in CS2113T:
1. Lecture: FRIDAY, 16:00-18:00 (Zoom)
2. Tutorial: FRIDAY, 08:00-09:00 (Zoom)
---------------------------------------------------------------------
```
***

### x. Removing Timetable Lessons: `delete timetable`
Deletes the lessons in the timetable corresponding to the index for the module you have selected.

Format: `delete timetable LESSON_INDEX`

Example usage:

`delete timetable 1`

Expected output :
```
---------------------------------------------------------------------
You have successfully removed lesson: FRIDAY, 16:00-18:00 from CS2113T
---------------------------------------------------------------------
```
***

### xi. Editing Timetable Lessons: `edit timetable`
Edits the lessons in the timetable corresponding to the index for the module you have selected.

Format: `edit timetable LESSON_INDEX /t TYPE /v VENUE /d DAY /s START_TIME /e END_TIME`

* You may enter `-` for the field(s) you do not wish to change.
* The `TYPE` and `VENUE` can be in a natural language format.
* The `DAY` must be a valid day spelt out fully in caps eg. `MONDAY`.
* The `START_TIME` and `END_TIME` must be in the format `HHmm` eg. `1800` if specified.
* `START_TIME` must be before `END_TIME`
* The parameters cannot be empty or whitespaces.

:warning: All flags (`/t`, `/v` etc.) must be included in the order specified above.

:warning: Note the spacing before and after each flag eg. `/t TYPE /v`; Input would be truncated if spaces are not present.

:warning: Input `2400` for `START_TIME` and `END_TIME` would be interpreted as `00:00`.

Example usage:

Changing the day to Monday: `edit timetable 1 /t - /v - /d MONDAY /s - /e -`

Expected output :
```
---------------------------------------------------------------------
You have successfully edited the lesson to:
Lecture: MONDAY, 16:00-18:00 (Zoom)
---------------------------------------------------------------------
```
***
//@@author bryanwhl
### xii. Adding an Assignment: `add assignment`

Adds an assignment

Format: `add assignment /t TYPE_OF_ASSIGNMENT /a ASSIGNMENT_NAME`

Example usage:

`add assignment /t mcq /a Magic Sequence`

`add assignment /t la /a recursion`

Expected output :

```
---------------------------------------------------------------------
I have added a new assignment to CS2113T:
Magic Sequence
---------------------------------------------------------------------
```
***
//@@author jianningzhuang
### xiii. Listing Module Assignments : `list assignments` 

Lists out all assignments in the module along with the due date if the deadline was set.

Format: `list assignment`

Expected output :
```
---------------------------------------------------------------------
Here are the assignments in CS2113T:
1. quiz1 (due by: Aug 17 2021)
2. quiz2 (due by: Aug 16 2021)
3. quiz3 (due by: Aug 20 2021)
---------------------------------------------------------------------
```
***
### xiv. Sorting Module Assignments : `sort assignments` 

Sorts all assignments in the module by their deadline. <br/>
If no deadline was set, the assignment will be sorted after those with deadlines.

Format: `sort assignments by deadline`

Expected output :
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
//@@author bryanwhl

### xv. Editing an Assignment Name: `edit assignment`

Edits the assignment name of an existing assignment

Format: `edit assignment /t TYPE_OF_ASSIGNMENT /a OLD_ASSIGNMENT_NAME /n NEW_ASSIGNMENT_NAME`

Example usage:

`edit assignment /t mcq /a Magic Sequence /n Forest Fruits`

`edit assignment /t la /a recursion /n iteration`

Expected output :

```
---------------------------------------------------------------------
I have updated your assignment name:
Forest Fruits
---------------------------------------------------------------------
```

***
//@@author jianningzhuang
### xvi. Setting Assignment Deadline : `set deadline` 

Sets the deadline the assignment has to be graded by. 
If a deadline had previously been set, it will be updated by the new deadline.

Format: `set deadline /a ASSIGNMENT_NAME /d DEADLINE`

The DEADLINE must be in the format dd MM yyyy eg. 16 08 2021.

Examples:
* `set deadline /a quiz1 /d 17 08 2021`
* `set deadline /a quiz2 /d 16 08 2021`

Expected output :
```
---------------------------------------------------------------------
I have set quiz1's deadline to Aug 17 2021 in CS2113T
---------------------------------------------------------------------
```
***
//@@author bryanwhl
### xvii. Listing Assignment Grades : `list grades` 

Lists the students' grades for a particular assignment.
The students listed are sorted by grades.

Format: `list student assignment grades /a ASSIGNMENT_NAME`

Examples:
* `list student assignment grades /a quiz1`
* `list student assignment grades /a quiz3`

Expected output :
```
---------------------------------------------------------------------
Here are the students' grades for the quiz1 assignment:
1. A0214561M - 100.0
2. A0215114X - 101.0
---------------------------------------------------------------------
```
***

### xviii. Auto-Grading Assignments : `autograde` 

Auto-grades all student scripts for a particular assignment by comparing against solutions.
Automatically updates student's grades for that assignment.

Format: `autograde /a ASSIGNMENT_NAME`

Examples:
* `autograde /a quiz1`

Expected output :
```
---------------------------------------------------------------------
Here are the students' grades for the quiz1 assignment:
1. A0214561M - 100.0
2. A0215114X - 101.0
---------------------------------------------------------------------
```
***

//@@author

### xix. Exiting ModMan : `bye`

Auto-saves all your changes and exits the program. ModMan will have all your data ready the next time you load it.

Format: `bye`

Expected output :
```
---------------------------------------------------------------------
Bye. Hope to see you again soon!
---------------------------------------------------------------------
```
***

## 3. FAQ

**Q**: How do I delete a particular module/assignment? 

**A**: The feature of deletion is still in progress and will be released in our upcoming versions. 


**Q**: When is the data saved to the database?

**A**: It is only saved when you exit the program using the `bye` command.

## 4. Command Summary

Action | Format, Examples
------ | ----------------
add module | `add module MODULE_NAME` <br> e.g. `add module CS2113T`
remove module | `remove module MODULE_NAME` <br> e.g. `remove module CS2113T`
select module | `select MODULE_NAME` <br> e.g. `select CS2113T`
view current module | `current` <br>
add student | `add student /s STUDENT_NAME /# STUDENT_NUMBER /e STUDENT_EMAIL` <br> e.g. `add student /s John Doe /# A0123456Y /e e0123456@u.nus.edu`
list student details | `list student details <br> e.g. `list student details`
list student | `list student` <br> 
add timetable | `add timetable /t TYPE /v VENUE /d DAY /s START_TIME /e END_TIME` <br> e.g. `add timetable /t Lecture /v Zoom /d Fri /s 1600 /e 1800`
list timetable | `list timetable` <br> 
add assignment | `add assignment /t TYPE_OF_ASSIGNMENT /a ASSIGNMENT_NAME` <br> e.g. `add assignment /t mcq /a Magic Sequence`
list assignments | `list assignment` <br>
sort assignments | `sort by deadline` <br>
edit assignment | `edit assignment /t TYPE_OF_ASSIGNMENT /a OLD_ASSIGNMENT_NAME /n NEW_ASSIGNMENT_NAME` <br> e.g. `edit assignment /t mcq /a Magic Sequence /n Forest Fruits`
set deadline | `set deadline /a ASSIGNMENT_NAME /d DEADLINE` <br> e.g. `set deadline /a quiz1 /d 17 08 2021`
list grades | `list student assignment grades /a ASSIGNMENT_NAME` <br> e.g. `list student assignment grades /a quiz1`
autograde | `autograde /a ASSIGNMENT_NAME` <br> e.g. `autograde /a quiz1`



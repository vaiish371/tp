# ModMan User Guide

## Introduction

ModMan, short for Module Manager, is a desktop app designed to help teaching assistants manage their module(s). 
It is optimized for use via a Command Line Interface (CLI). Mod Man helps to track module details as well as students’ progress and data, all in one platform. It can also perform autograding for MCQ assignments.

## Table of contents
1. [Quick start](#1-quick-start)
1. [Features](#2-features)
    1. [`add module` - Adding a Module](#i-adding-a-module-add-module)
    1. [`remove module` - Removing a Module](#ii-removing-a-module-remove-module)
    1. [`select` - Selecting a Module](#iii-selecting-a-module-select)
    1. [`current` - Viewing current Module](#iv-viewing-current-module-current)
    1. [`add student` - Adding a Student](#v-adding-a-student-add-student)
    1. [`add assignment` - Adding an Assignment](#vi-adding-an-assignment-add-assignment)
    1. [`add timetable` - Adding a Lesson](#vii-adding-a-lesson-add-timetable)
    1. [`list student details` - Listing Students Details](#vii-listing-students-details-list-student-details)
    1. [`list student` - Listing Students in Module](#ix-listing-students-in-module-list-student-)
    1. [`list timetable` - Listing Timetable Lessons](#x-listing-timetable-lessons-list-timetable)
    1. [`list assignments` - Listing Module Assignments](#xi-listing-module-assignments--list-assignments)
    1. [`sort assignments` - Sorting Module Assignments](#xii-sorting-module-assignments--sort-assignments)
    1. [`edit assignment` - Editing an Assignment Name](#xiii-editing-an-assignment-name-edit-assignment) 
    1. [`set deadline` - Setting Assignment Deadline](#xiv-setting-assignment-deadline--set-deadline)
    1. [`list grades` - Listing Assignment Grades](#xv-listing-assignment-grades--list-grades)
    1. [`autograde` - Auto-Grading Assignments](#xvi-auto-grading-assignments--autograde)
 
  
3. [FAQ](#3-faq)
4. [Command summary](#4-command-summary)

## 1. Quick Start

1. Ensure you have Java `11` installed on your computer.
1. Download the latest `ModMan.jar` from [here]()
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

> Expected outcome:

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

Expected outcome:

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

Expected outcome:

```` 
--------------------------------------------------------------------------
    Success! You are now working in: CS2113T
-------------------------------------------------------------------------- 
````
***
### iv. Viewing current Module: `current`

View the current module you are working in.

Format: `current`

Expected outcome:

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

> Expected outcome (assuming the current module is "CS2113T") :
```
---------------------------------------------------------------------
I have assigned a new student to CS2113T:
John Doe, A0123456Y, e0123456@u.nus.edu
---------------------------------------------------------------------
```
***
### vi. Adding an Assignment: `add assignment`

Adds an assignment

Format: `add assignment /t TYPE_OF_ASSIGNMENT /a ASSIGNMENT_NAME`

Example usage:

`add assignment /t mcq /a Magic Sequence`

`add assignment /t la /a recursion`

> Expected Outcome (assuming the current module is "CS2040C") :

```
---------------------------------------------------------------------
I have added a new assignment to CS2040C:
Magic Sequence
---------------------------------------------------------------------
```
***
### vii. Adding a Lesson: `add timetable` 
Adds a new lesson to the list (timetable) of lessons for the module you have selected.

Format: `add timetable /t TYPE /v VENUE /d DAY /s START_TIME /e END_TIME`

* The `TYPE`, `VENUE` and `DAY` can be in a natural language format.
* The `START_TIME` and `END_TIME` must be in the format `HHmm` eg. `1800`.

Examples:
* `add timetable /t Lecture /v Zoom /d Fri /s 1600 /e 1800`

> Expected output :
```
---------------------------------------------------------------------
Success! I have added the following timetable for the module - CS2113T
Lecture: Fri, 16:00-18:00 (Zoom)
---------------------------------------------------------------------
```
***

### vii. Listing Students Details: `list student details`

Lists the details of all students enrolled in a particular module.

Format: `list student details MODULE_NAME`

Example of usage:

`list student details CS2113T`

`list student details CS2101`

> Expected outcome :

```` 
--------------------------------------------------------------------------
    Here are the students of all students enrolled in CS2113T:
    1. Vaishnavi, A0208551J, vaiish371@gmail.com
    2. Emily, A0888888J, emily@gmail.com
-------------------------------------------------------------------------- 
````
***

### ix. Listing Students in Module: `list student `
Lists the names of students assigned to the current module you have selected.

Format: `list student`

Example of usage:

`list student`

> Expected outcome (assuming the current module is "CS2113T") :
```
---------------------------------------------------------------------
 Here are the students in CS2113T:
 1. John Doe
---------------------------------------------------------------------
```
***

### x. Listing Timetable Lessons: `list timetable`
Lists the lessons in the timetable for the module you have selected.

Format: `list timetable`

* The `START_TIME` and `END_TIME` will be listed in the format `HH:mm` eg. `18:00`.

> Expected output :
```
---------------------------------------------------------------------
Here are the lessons in CS2113T:
1. Lecture: Fri, 16:00-18:00 (Zoom)
2. Tutorial: Fri, 08:00-09:00 (Zoom)
---------------------------------------------------------------------
```
***

### xi. Listing Module Assignments : `list assignments` 

Lists out all assignments in the module along with the due date if the deadline was set.

Format: `list assignment`

> Expected Outcome :
```
---------------------------------------------------------------------
Here are the assignments in CS2113T:
1. quiz1 (due by: Aug 17 2021)
2. quiz2 (due by: Aug 16 2021)
3. quiz3 (due by: Aug 20 2021)
---------------------------------------------------------------------
```
***

### xii. Sorting Module Assignments : `sort assignments` 

Sorts all assignments in the module by their deadline. <br/>
If no deadline was set, the assignment will be sorted after those with deadlines.

Format: `sort by deadline`

> Expected Outcome :
```
---------------------------------------------------------------------
Here are the assignments in CS2113T:
1. quiz2 (due by: Aug 16 2021)
2. quiz1 (due by: Aug 17 2021)
3. quiz3 (due by: Aug 20 2021)
---------------------------------------------------------------------
```

***

### xiii. Editing an Assignment Name: `edit assignment`

Edits the assignment name of an existing assignment

Format: `edit assignment /t TYPE_OF_ASSIGNMENT /a OLD_ASSIGNMENT_NAME /n NEW_ASSIGNMENT_NAME`

Example usage:

`edit assignment /t mcq /a Magic Sequence /n Forest Fruits`

`edit assignment /t la /a recursion /n iteration`

> Expected Outcome :

```
---------------------------------------------------------------------
I have updated your assignment name:
Forest Fruits
---------------------------------------------------------------------
```

***

### xiv. Setting Assignment Deadline : `set deadline` 

Sets the deadline the assignment has to be graded by. 
If a deadline had previously been set, it will be updated by the new deadline.

Format: `set deadline /a ASSIGNMENT_NAME /d DEADLINE`

The DEADLINE must be in the format dd MM yyyy eg. 16 08 2021.

Examples:
* `set deadline /a quiz1 /d 17 08 2021`
* `set deadline /a quiz2 /d 16 08 2021`

> Expected Outcome :
```
---------------------------------------------------------------------
Here are the assignments in CS2113T:
1. quiz1 (due by: Aug 17 2021)
2. quiz2 (due by: Aug 16 2021)
---------------------------------------------------------------------
```
***

### xv. Listing Assignment Grades : `list grades` 

Lists the students' grades for a particular assignment.
The students listed are sorted by grades.

Format: `list student assignment grades /a ASSIGNMENT_NAME`

Examples:
* `list student assignment grades /a quiz1`
* `list student assignment grades /a quiz3`

> Expected Outcome :
```
---------------------------------------------------------------------
Here are the students' grades for the quiz1 assignment:
1. A0214561M - 100.0
2. A0215114X - 101.0
---------------------------------------------------------------------
```
***

### xvi. Auto-Grading Assignments : `autograde` 

Auto-grades all student scripts for a particular assignment by comparing against solutions.
Automatically updates student's grades for that assignment.

Format: `autograde /a ASSIGNMENT_NAME`

Examples:
* `autograde /a quiz1`

> Expected Outcome :
```
---------------------------------------------------------------------
Here are the students' grades for the quiz1 assignment:
1. A0214561M - 100.0
2. A0215114X - 101.0
---------------------------------------------------------------------
```
***
## 3. FAQ

**Q**: How do I delete a particular module/assignment? 

**A**: The feature of deletion is still in progress and will be released in our upcoming versions. 

## 4. Command Summary

Action | Format, Examples
------ | ----------------
add module | `add module MODULE_NAME` <br> e.g. `add module CS2113T`
remove module | `remove module MODULE_NAME` <br> e.g. `remove module CS2113T`
select module | `select MODULE_NAME` <br> e.g. `select CS2113T`
view current module | `current` <br>
add student | `add student /s STUDENT_NAME /# STUDENT_NUMBER /e STUDENT_EMAIL` <br> e.g. `add student /s John Doe /# A0123456Y /e e0123456@u.nus.edu`
add assignment | `add assignment /t TYPE_OF_ASSIGNMENT /a ASSIGNMENT_NAME` <br> e.g. `add assignment /t mcq /a Magic Sequence`
add timetable | `add timetable /t TYPE /v VENUE /d DAY /s START_TIME /e END_TIME` <br> e.g. `add timetable /t Lecture /v Zoom /d Fri /s 1600 /e 1800`
list student details | `list student details MODULE_NAME` <br> e.g. `list student details CS2113T`
list student | `list student` <br> e.g. `list student` assuming current module is : CS2113T
list timetable | `list timetable` <br> e.g. `list timetable`
list assignments | `list assignment` <br> e.g. `list assignment`
sort assignments | `sort by deadline` <br> e.g. `sort by deadline`
edit assignment | `edit assignment /t TYPE_OF_ASSIGNMENT /a OLD_ASSIGNMENT_NAME /n NEW_ASSIGNMENT_NAME` <br> e.g. `edit assignment /t mcq /a Magic Sequence /n Forest Fruits`
set deadline | `set deadline /a ASSIGNMENT_NAME /d DEADLINE` <br> e.g. `set deadline /a quiz1 /d 17 08 2021`
list grades | `list student assignment grades /a ASSIGNMENT_NAME` <br> e.g. `list student assignment grades /a quiz1`
autograde | `autograde /a ASSIGNMENT_NAME` <br> e.g. `autograde /a quiz1`



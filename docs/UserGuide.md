# ModMan User Guide

## Introduction

ModMan, short for Module Manager, is a desktop app designed to help teaching assistants manage their module(s). 
It is optimized for use via a Command Line Interface (CLI). Mod Man helps to track module details as well as students’ progress and data, all in one platform. It can also perform autograding for MCQ assignments.

## Table of contents
* [Quick start](#quick-start)
* [Features](#features)
    * [`todo` - Add a Todo](#todo---add-a-todo)
    * [`deadline` - Add a Deadline](#deadline---add-a-deadline)
    * [`event` - Add an Event](#event---add-an-event)
    * [`list` - Display all tasks](#list---display-all-tasks)
    * [`done` - Mark a task as done](#done---mark-a-task-as-done)
    * [`delete` - ~~Delete~~ a task](#delete---delete-a-task)
    * [`find` - Find tasks](#find---find-tasks)
    * [`bye` - Exit Duke](#bye---exit-duke)
* [FAQ](#faq)
* [Command summary](#command-summary)

## Quick Start

1. Ensure you have Java `11` installed on your computer.
1. Download the latest `ModMan.jar` from [here]()
1. Open a command window in the folder containing the `.jar` file.
1. Run the command `java -jar {filename}.jar` <br> If you haven't changed the filename, run the command `java -jar ModMan.jar`


## Features 

| :information_source: | Inputs in `UPPER_CASE` are parameters to be supplied by the user. |
|----------------------|-------------------------------------|

### Adding a Module: `add module`

Adds a new module to the list of modules.

Format: `add module MODULE_NAME`

Example of usage:

`add module CS2113T`

`add module CS2101`

Expected outcome:

```` 
> add module CS2113T
--------------------------------------------------------------------------
    I have added a new module: CS2113T
-------------------------------------------------------------------------- 
````

### Removing a Module: `remove module`

Removes a module from the list of modules.

Format: `remove module MODULE_NAME`

Example of usage:

`remove module CS2113T`

Expected outcome:

```` 
> remove module CS2113T
--------------------------------------------------------------------------
    You have successfully removed module: CS2113T
-------------------------------------------------------------------------- 
````
### Selecting a Module: `select`

Select the module you want to currently work in.

Format: `select MODULE_NAME`

Example of usage:

`select CS2113T`

Expected outcome:

```` 
> select CS2113T
--------------------------------------------------------------------------
    Success! You are now working in: CS2113T
-------------------------------------------------------------------------- 
````

### Viewing current Module: `current`

View the current module you are working in.

Format: `current`

Expected outcome:

```` 
> current
--------------------------------------------------------------------------
    You are currently working in: CS2113T
-------------------------------------------------------------------------- 
````



### List Students Details: `list student details`

Lists the details of all students enrolled in a particular module.

Format: `list student details MODULE_NAME`

Example of usage:

`list student details CS2113T`

`list student details CS2101`

Expected outcome:

```` 
> list student details CS2113T
--------------------------------------------------------------------------
    Here are the students of all students enrolled in CS2113T:
    1. Vaishnavi, A0208551J, vaiish371@gmail.com
    2. Emily, A0888888J, emily@gmail.com
-------------------------------------------------------------------------- 
````

### Adding a student: `add student`
Assigns a new student to the current module you have selected.

Format: `add student /s STUDENT_NAME /# STUDENT_NUMBER /e STUDENT_EMAIL`

Example of usage:

`add student /s John Doe /# A0123456Y /e e0123456@u.nus.edu`

Expected outcome (assuming the current module is "CS2113T"):
```
---------------------------------------------------------------------
I have assigned a new student to CS2113T:
John Doe, A0123456Y, e0123456@u.nus.edu
---------------------------------------------------------------------
```
### Listing students: `list student `
Lists the names of students assigned to the current module you have selected.

Format: `list student`

Example of usage:

`list student`

Expected outcome (assuming the current module is "CS2113T"):
```
---------------------------------------------------------------------
 Here are the students in CS2113T:
 1. John Doe
---------------------------------------------------------------------
```

### Adding a lesson: `add timetable` (Zihan)
Adds a new lesson to the list (timetable) of lessons for the module you have selected.

Format: `add timetable /t TYPE /v VENUE /d DAY /s START_TIME /e END_TIME`

* The `TYPE`, `VENUE` and `DAY` can be in a natural language format.
* The `START_TIME` and `END_TIME` must be in the format `HHmm` eg. `1800`.  

Examples:
* `add timetable /t Lecture /v Zoom /d Fri /s 1600 /e 1800`

Expected output:
```
---------------------------------------------------------------------
Success! I have added the following timetable for the module - CS2113T
Lecture: Fri, 16:00-18:00 (Zoom)
---------------------------------------------------------------------
```

### Listing the timetable: `list timetable` (Zihan)
Lists the lessons in the timetable for the module you have selected.

Format: `list timetable`

* The `START_TIME` and `END_TIME` will be listed in the format `HH:mm` eg. `18:00`.

Expected output:
```
---------------------------------------------------------------------
Here are the lessons in CS2113T:
1. Lecture: Fri, 16:00-18:00 (Zoom)
2. Tutorial: Fri, 08:00-09:00 (Zoom)
---------------------------------------------------------------------
```

### Setting Assignment Deadline : `set deadline` (Jianning)

Sets the deadline the assignment has to be graded by. <br/>
If a deadline had previously been set, it will be updated by the new deadline.

Format: `set deadline /a ASSIGNMENT_NAME /d DEADLINE`

The DEADLINE must be in the format dd MM yyyy eg. 16 08 2021.

Examples:
* `set deadline /a quiz1 /d 17 08 2021`
* `set deadline /a quiz2 /d 16 08 2021`

Expected Outcome:
```
---------------------------------------------------------------------
Here are the assignments in CS2113T:
1. quiz1 (due by: Aug 17 2021)
2. quiz2 (due by: Aug 16 2021)
---------------------------------------------------------------------
```


### Listing Module Assignments : `list assignments` (Jianning)

Lists out all assignments in the module along with the due date if the deadline was set.

Format: `list assignment`

Expected Outcome:
```
---------------------------------------------------------------------
Here are the assignments in CS2113T:
1. quiz1 (due by: Aug 17 2021)
2. quiz2 (due by: Aug 16 2021)
3. quiz3 (due by: Aug 20 2021)
---------------------------------------------------------------------
```

### Sorting Module Assignments : `sort assignments` (Jianning)

Sorts all assignments in the module by their deadline. <br/>
If no deadline was set, the assignment will be sorted after those with deadlines.

Format: `sort by deadline`

Expected Outcome:
```
---------------------------------------------------------------------
Here are the assignments in CS2113T:
1. quiz2 (due by: Aug 16 2021)
2. quiz1 (due by: Aug 17 2021)
3. quiz3 (due by: Aug 20 2021)
---------------------------------------------------------------------
```

### Listing Student Grades : `list grades` (Jianning)

Lists the students' grades for a particular assignment. <br/>
The students listed are sorted by grades.

Format: `list student assignment grades /a ASSIGNMENT_NAME`

Examples:
* `list student assignment grades /a quiz1`
* `list student assignment grades /a quiz3`

Expected Outcome:
```
---------------------------------------------------------------------
Here are the students' grades for the quiz1 assignment:
1. A0214561M - 100.0
2. A0215114X - 101.0
---------------------------------------------------------------------
```


### Auto-Grading Assignments : `autograde` (Jianning)

Auto-grades all student scripts for a particular assignment by comparing against solutions. <br/>
Automatically updates student's grades for that assignment.

Format: `autograde /a ASSIGNMENT_NAME`

Examples:
* `autograde /a quiz1`

Expected Outcome:
```
---------------------------------------------------------------------
Here are the students' grades for the quiz1 assignment:
1. A0214561M - 100.0
2. A0215114X - 101.0
---------------------------------------------------------------------
```

### 3. Adding an assignment: `add assignment`

Adds an assignment

Format: `add assignment /t TYPE_OF_ASSIGNMENT /a ASSIGNMENT_NAME`

Example usage:

`add assignment /t mcq /a Magic Sequence`

`add assignment /t la /a recursion`

Expected Outcome (Assuming the current module is "CS2040C"):

```
---------------------------------------------------------------------
I have added a new assignment to CS2040C:
Magic Sequence
---------------------------------------------------------------------
```

### 4. Editing an assignment name: `edit assignment`

Edits the assignment name of an existing assignment

Format: `edit assignment /t TYPE_OF_ASSIGNMENT /a OLD_ASSIGNMENT_NAME /n NEW_ASSIGNMENT_NAME`

Example usage:

`edit assignment /t mcq /a Magic Sequence /n Forest Fruits`

`edit assignment /t la /a recursion /n iteration`

Expected Outcome:

```
---------------------------------------------------------------------
I have updated your assignment name:
Forest Fruits
---------------------------------------------------------------------
```

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

Action | Format, Examples
------ | ----------------
todo | `todo TASK_DESCRIPTION` <br> e.g. `todo wash the dishes`
deadline | `deadline TASK_DESCRIPTION /by DDMMYYYY HHMM` <br> e.g. `deadline finish project /by 02/04/2021 2359`
event | `event TASK_DESCRIPTION /at DDMMYYYY HHMM` <br> e.g. `event presentation /at 29/05/2021 1000`
list | `list`
done | `done INDEX` <br> e.g. `done 2`
delete | `delete INDEX` <br> e.g. `delete 2`
find | `find KEYWORD` <br> e.g. `find presentation`
bye | `bye`

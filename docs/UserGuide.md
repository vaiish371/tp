# User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features 

| :information_source: | Inputs in `UPPER_CASE` are parameters to be supplied by the user. |
|----------------------|-------------------------------------|

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

### Setting Assignment Deadline : `set deadline` (Jianning)

Sets the deadline the assignment has to be graded by. 
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

Sorts all assignments in the module by their deadline. 
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

Lists the students' grades for a particular assignment.
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

Auto-grades all student scripts for a particular assignment by comparing against solutions.
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
## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`


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
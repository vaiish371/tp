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

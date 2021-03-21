# User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features 

{Give detailed description of each feature}

### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

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
# User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features 

{Give detailed description of each feature}

### Adding a lesson: `add timetable` (Zihan)
Adds a new lesson to the list (timetable) of lessons for the module you have selected.

Format: `add timetable /t TYPE /v VENUE /d DAY /s START_TIME /e END_TIME`

* The `TYPE`, `VENUE` and `DAY` can be in a natural language format.
* The `START_TIME` and `END_TIME` must be in the format `HHmm` eg. `1800`.  

Example of usage: 

`add timetable /t Lecture /v Zoom /d Fri /s 1600 /e 1800`

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
## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`

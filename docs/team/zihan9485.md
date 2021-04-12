# Wang Zihan - Project Portfolio Page

### Project: ModMan
Short for Module Manager, ModMan is a desktop app designed to help teaching assistants manage their module(s).
It is optimized for use via a Command Line Interface (CLI).
ModMan helps to track module details as well as students’ progress and data, all in one platform.
It can also perform autograding for MCQ assignments.

Given below are my contributions to the project.


- **New Feature**: Added the ability to keep track of module lessons within the app.
    - What it does: Allows the user to add, view, edit, and delete lessons based on type, location, day, start time and end time.
    - Justification: Timetable tracking is one of the biggest issues for TAs who do not have a fast and convenient platform to check their module schedule.


- **New Feature**: Added the ability to keep track of multiple modules and select a current module to work in.
    - What it does: Add modules that user is teaching to a list. List all modules or select an individual module to work in.
    - Justification: TAs may need to track information and work for multiple modules. Separating these modules makes functions clearer and more focused.
    

- **Enhancements to existing features**:
    - Implemented the main `Modman` class that structures the high-level logic of the app: #15
    - Implemented `Day` in `Lesson` as an enumeration type, validating user input dates must match a valid date spelled fully in caps: #197
    - Ensure `startTime` is before `endTime` in `Lesson`: #204
    - Check for duplicate parameters in `add student`: #247, #267
    - Check for duplicate parameters in `add timetable` and `edit timetable`: #267
    - Implemented input validation for empty or whitespace parameters across commands in `Parser` class: #241, #245, #248
    - Implemented check when loading data from `Database.txt` for duplicates. #283

<div style="page-break-after: always;"></div>

- **Project management**:
    - Managed releases v1.0 - v2.1 (3 releases) on GitHub
    - Created and assigned issues to relevant members on the team to ensure we meet deadlines
    - Reviewed team members pull requests, and on occasion,
      helped them fix failing continuous integration issues before merging


- **Documentation**:
    - User Guide:
        - Added documentation for adding and listing Lesson: `add timetable` and `list timetable`: #87
        - Added documentation for editing and deleting Lessons from timetable `edit timetable` and `delete timetable`: #131
        - Added introduction, how to use and legend: #198
        - Added section on input format and trimming: #250
    - Developer Guide:
        - Added implementation details and class diagram for the Data classes in ModMan: #112
        - Added implementation details and sequence diagram for `SetAssignmentGradeCommand`: #254
        - Added implementation details and sequence diagram for `AddTimetableCommand`: #260
        - Added user stories: #198
        - Added glossary: #254
    - Javadoc:
        - Added Javadoc for List commands: #279
        - Added Javadoc for `Data`, `Module`, `Student` and `Lesson` classes: #279


- **Code contributed**: [*RepoSense* Link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=zihan9485).

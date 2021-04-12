 # Vaishnavi Ramanathan - Project Portfolio Page

### Project: ModMan
Short for Module Manager, ModMan is a desktop app designed to help teaching assistants manage their module(s).
It is optimized for use via a Command Line Interface (CLI).
ModMan helps to track module details as well as students’ progress and data, all in one platform.
It can also perform autograding for MCQ assignments.

Given below are my contributions to the project.


- **New Feature**: Added the ability to list students in a particular module and their details.
    - What it does: Allows the user to keep track of students enrolled in the various modules and their personal details.
    - Justification: Managing your students is something essential to any teaching individual and having access to 
    important details such as their phone number and email is very useful if we want to communicate with them.
      
      
- **New Feature**: Added the ability to set multiple comments to a particular assignment and retrieve them when needed.
    - What it does: Allows user to enter feedback for each assignment and edit previously written ones.
    - Justification: Sometimes instead of the provision of just one feedback box per assignment, it would be more conveninient
    to add multiple comments and even address it to different students. Being able to retrieve previous comments also prevents the need
      to have duplicate comments with just small differences.
      

- **Enhancements to existing features**:
    - Implemented many exceptions to the different `Command` classes and `Parser` class majorly.
    - Ensure that essential information is logged such as warnings and info about the commands entered by user.
    - Added the `edit assignment name` command method in `Parser` class
    - Added new exception classes and assertions
    - Added the `help` command that prints the list of important commands using the `Ui` class.
    
- **Project management**:
    - Managed releases v1.0 - v2.1 (3 releases) on GitHub
    - Helped team fix bugs that were reported during PE-Dry Run

- **Documentation**:
    - User Guide:
        - Added documentation for listing basic commands: `help`: 
        - Added documentation for listing module: `list module`:
        - Added documentation for listing students in a module and their details: `list student` and `list student details`
    - Developer Guide:
        - Added implementation details and class diagram for the `Ui` component.

- **Code contributed**: [*RepoSense* Link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=vaiish371).

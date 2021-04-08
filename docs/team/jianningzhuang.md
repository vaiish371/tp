# Jianning Zhuang's Project Portfolio Page

###Project: ModMan
Short for Module Manager, ModMan is a desktop app designed to help teaching assistants manage their module(s). 
It is optimized for use via a Command Line Interface (CLI). 
ModMan helps to track module details as well as students’ progress and data, all in one platform. 
It can also perform autograding for MCQ assignments.

Given below are my contributions to the project.

- **New Feature**: Added the ability to set deadlines for assignments and sort them by their deadlines.
    - What it does: Allows Teaching Assistants to set their own deadlines to grade assignments. Also allows them to sort the assignments in the module based on the deadline that they set.
    - Justification: Being able to set your own deadlines to grade assignments and sort them based on their urgency is crucial to help Teaching Assistants plan their time wisely and manage their workload.
    - Highlights: The Assignment Class implements the Comparable Interface to allow the natural ordering of assignments to change based on the compareTo() function.
      The sorting is also stable and accounts for assignments with null deadlines. If an assignment does not have a deadline, it would be sorted after other assignments with deadlines.
      
- **New Feature**: Added the ability to load and store answers for assignments.
    - What it does: Reads the answer key stored in a text file in the answers directory and stores it as an Answer object for the assignment.
    - Justification: Being able to load and store answers allow Teaching Assistants to easily retrieve and view the answer key to assignments. 
      Answers can also be accessed offline.

- **New Feature**: Added the ability to autograde assignments.
    - What it does: All students' scripts found in the scripts directory will be graded against the answer key. 
      The grade for each student will also be automatically saved and updated.
      Autograding also keeps track of which students have not submitted their assignment.
    - Justification: Being able to autograde assignments would drastically help Teaching Assistants manage their workload. 
      Autograding is also much faster and accurate than manual grading.
      
- Code contributed: [*RepoSense* Link](https://nus-cs2113-ay2021s2.github.io/tp-dashboard/?search=jianningzhuang).

- Project management:
    - Managed releases v1.0 - v2.1 (3 releases) on GitHub
- Enhancements to existing features:
    - Implemented Assignment class to enhance the functionality of the application.
    - Designed and added Storage class and methods that allow users' data to be saved automatically at the end of each session.
- Documentation:
    - User Guide:
        - Added documentation for listing assignment feature #89
        - Added documentation exit for adding Assignment feature #89
    - Developer Guide:
        - Added Class Diagrams for the Logic Component: #111
        - Added implementation details of the sorting feature: #115
        - Added implementation details of the Storage feature: #115
- Community:
    - PRs reviewed (with non-trivial review comments): #122

## Overview

After missing out on any prizes in the Spin the Wheel section of Lecture for the past 10 weeks, 


### Summary of Contributions

* Set deadline
* Sorting by deadline
* Storing and Retrieving Answer Key
* Storing and Retrieving Students'scripts
* Autograding

Corresponding section in UG and DG

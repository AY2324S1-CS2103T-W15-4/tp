---
  layout: page
  title: "Developer Guide"
  pageNav: 3
---

# CodeSphere Developer Guide

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## **Acknowledgements**

_{ list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well }_

--------------------------------------------------------------------------------------------------------------------

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------
## **Appendix: Requirements**

### Product scope

**Target user profile**:

* wants to be able to manage student information
* wants to be able to keep track of student performance
* prefer desktop apps over other types
* prefers typing to mouse interactions
* is reasonably comfortable using CLI apps

**Value proposition**: provides an easy way to manage students, allowing for customised support to keep tabs on each student.

### User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …​                               | I want to …​                     | So that I can…​                                                        |
| -------- | ------------------------------------- | ------------------------------ | ---------------------------------------------------------------------- |
| `* * *`  |user                                   | add student profiles          | keep track of the students in my class.                 |
| `* * *`  | user                                  | edit student profiles                 |  keep accurate and up-to-date information on each student.                                                                      |
| `* * *`  | user                                  | delete a student profile                | remove a student if the student is no longer in my class.                                  |
| `* * *`  | user                                  | tag students based on how well they are coping          | I can easily identify students who may need additional support. |
| `* *`    | user                                  | add remarks for individual students    | maintain a log of anything noteworthy.                |

*{More to be added}*

### Use cases

(For all use cases below, the **System** is the `CodeSphere` and the **Actor** is the `user`, unless specified otherwise)

**Use case: Edit student’s information**

**Preconditions**: The student has already been added into the app.

**Guarantees**: Unchanged fields during the edit will remain the same as before.

**MSS**

1. User chooses to edit a student’s information.
2. CodeSphere displays the student’s current information.
3. User edits the fields that need to be changed.
4. User saves the changes.
5. CodeSphere updates the student’s information.
    Use case ends.

**Extensions**

* 3a. CodeSphere detects incorrect format for the new changes.
    * 3a1. CodeSphere prompts the User to enter details in the correct format.
    * 3a2. User enters details again.</br>
    Use case resumes at step 4.

*  *a. At any time, the User chooses to cancel the edit.
    * *a1. CodeSphere requests to confirm the cancellation.
    * *a2. User confirms the cancellation.
    Use case ends.

**Use case: Delete a student**

**Preconditions**: The student has already been added into the app.

**MSS**

1. User chooses to delete a student.
2. CodeSphere displays the student’s current information.
3. CodeSphere prompts the user to confirm the deletion.
4. User confirms the deletion.
5. CodeSphere deletes the student.
   Use Case Ends.

**Extensions**

* 1a. Codesphere detects that the target student does not exist.
    * 1a1. CodeSphere prompts the user to choose an existing student to be deleted.
    * 1a2. User chooses an existing student to be deleted.</br>
    Use case resumes at step 4

*{More to be added}*

### Non-Functional Requirements

1.  Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2.  The application should be able to handle an increasing number of profiles and users without a significant degradation in performance.
3.  The application should gracefully handle errors, providing informative error messages to users in case of failures.
4.  Code should be organized into reusable and maintainable modules, making it easier to enhance and extend the application in the future.
5.  Maintain comprehensive documentation for developers.
6.  The application should run smoothly on different operating systems commonly used by the target users.
7.  Ensure that only authorized users can access and manipulate profile information.

*{More to be added}*

### Glossary

* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **CLI**: Command Line Interface. A way to interact with a computer or software by typing text-based commands, rather than using a mouse and graphical icons.

--------------------------------------------------------------------------------------------------------------------

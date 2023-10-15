---
layout: default.md
title: "User Guide"
pageNav: 3
---

# CodeSphere User Guide

CodeSphere is a **desktop contact management app, optimised for use via a Command Line Interface (CLI)** while still having the benefits of a Graphical User Interface (GUI). It is an app targeted at connecting Year 1 Computer Science students in the NUS School of Computing.

### Features
* Viewing help: `help`
* Adding a student: `add`
* Editing a student: `edit`
* Deleting student: `delete`
* Tagging a student: `tag`
* Exit the app: `exit`


--------------------------------------------------------------------------------------------------------------------

* Table of Contents
  {:toc}

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…` after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  </box>

### Adding a student : `add` [coming soon]

Adds a student to the list of students the user is overseeing.

Format: `add n/Name p/COURSE e/EMAIL`
* NAME: string
* COURSE: string that is a valid course in NUS SoC
* EMAIL: string ending with @u.nus.edu

Examples:
* `add n/Susan Tan c/CS1101S e/susantan@u.nus.edu`
* `add n/Ben Koh c/CS1231S e/benkoh@u.nus.edu`

Command succeeds: Success message shown to user, student successfully added and stored in database, change in GUI.

Command failure: Users enter the command with incorrect formatting, resulting in an error message shown to the user and the student is not added and stored into the database.

### Editing a student : `edit` [coming soon]

Edits an existing student that the user is currently overseeing.

Format: `edit INDEX [n/NAME] [c/COURSE] [e/EMAIL] [r/REMARK]...`
* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed students list.
* The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing t/ without specifying any tags after.

Examples:
* `edit 1 c/CS1101S e/susantan@u.nus.edu` Edits the course and email address of the 1st person to be CS1101S and susantan@u.nus.edu respectively.
* `edit 2 n/Alex Yeoh t/` Edits the name of the 2nd person to be Alex Yeoh and clears all existing tags.

Command succeeds: Success message shown to user, relevant fields of the specified student successfully updated and stored in database, change in GUI.

Command failure: Users enter the command with incorrect formatting, resulting in an error message shown to the user and the relevant fields of the specified student are not updated.

### Deleting a student: `delete` [coming soon]

Deletes the specified student from the list of students.

Format: `delete INDEX`
* Deletes the student at the specified `INDEX`. The index refers to the index number shown in the displayed students list.
* The index refers to the index number shown in the displayed students list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `delete 2` Deletes the student at index 2 of the displayed students list.


Command succeeds:
* Success message shown to user, the specified student is successfully deleted and removed from the database, change in GUI.

Command failure:
* Users enter the command with incorrect formatting, resulting in an error message shown to the user and the specified student is not deleted and removed from the database.

### Tagging a student `tag` [coming soon]

Adds a tag to the specified student from the list of students.

Format: `tag INDEX t/ [ENUM_TAG]`
* Adds a tag for the student at the specified `INDEX`. The index refers to the index number shown in the displayed students list.
* The index **must be a positive intege**r 1, 2, 3, …​
* `ENUM_TAG` must be from the pre-defined enumerated tag definitions _good, average, poor_.

Examples:
* `tag 1 t/AVERAGE` Tags the student at index 1 of the displayed students list to be AVERAGE.

Command succeeds:
* Success message shown to user, the specified student is successfully tagged as a ‘average performing student’, change in GUI.

Command failure:
* Users enter the command with incorrect formatting, resulting in an error message shown to the user and tag status (whether untagged / previously tagged) of the specified student remains as it was before.

### Adding a remark for a student: `remark` [coming soon]

Adds a tag to the specified student from the list of students.

Format: `remark INDEX r/REMARK`
* Adds a remark for the student at the specified `INDEX`. The index refers to the index number shown in the displayed students list.
* The index must be a **positive integer** 1, 2, 3, …

Examples:
* `remark 2 r/needs more help` Adds a remark to the student at index 2 of the displayed students list saying needs more help.

Command succeeds:
* Success message shown to user, a remark is added to the specified student and this information is updated to the database, change in GUI.

Command failure:
* Users enter the command with incorrect formatting, resulting in an error message shown to the user and no new remark is added to the specified student.

### Viewing help : `help` [coming soon]

Shows a message explaining how to access the help page.

Format: `help`


### Exiting the program : `exit` [coming soon]

Exits the program.

Format: `exit`

Command succeeds:
*  Success message shown to user, exit the GUI.

Command failure:
* Error message shown to user.

--------------------------------------------------------------------------------------------------------------------
## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME c/COURSE e/EMAIL` <br> e.g., `add n/Susan Tan c/CS1101S e/susantan@u.nus.edu`
**Edit** | `edit INDEX [n/NAME] [c/COURSE] [e/EMAIL] [r/REMARK]` <br> e.g., `edit 1 c/CS1101S e/susantan@u.nus.edu`
**Delete** | `delete INDEX`<br> e.g.,`delete 2`
**Tag** | `tag INDEX t/ [ENUM_TAG]`<br> e.g., `tag 1 t/AVERAGE`
**Remark** | `remark INDEX r/REMARK` <br> e.g., `remark 2 r/needs more help`
**Exit** | `exit`

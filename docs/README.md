# GoldenTrace User Guide

GoldenTrace is a desktop task tracker for users who prefer working through a Command Line Interface (CLI). It lets you manage to-dos, deadlines, and events quickly from the terminal, while automatically saving your tasks to disk.

## Quick start

1. Ensure you have Java `17` or above installed.
1. Download the latest `.jar` file from [here](https://github.com/kenpegrasio/ip/releases) to the folder you want to use as the app's home folder.
1. Open a terminal in that folder.
1. Run the application with:

```bash
java -jar goldentrace.jar
```

1. Type a command and press Enter to execute it.

Some example commands you can try:

- `list`
- `todo read book`
- `deadline submit report /by Friday`
- `event team meeting /from Monday 2pm /to Monday 4pm`
- `mark 1`
- `find report`
- `delete 1`
- `bye`

## Features

### Notes about the command format

- Commands are case-sensitive. Use lowercase command words such as `list`, `todo`, and `bye`.
- Text in `UPPER_CASE` below represents information you supply.
- Items in square brackets are placeholders, not literal characters to type.
- Indexes refer to the task number shown in the task list, starting from `1`.
- GoldenTrace expects each command in a specific format. For example, `list` must be entered exactly as `list`.
- For `deadline` and `event`, reserve `/by`, `/from`, and `/to` for their intended separators.

### Listing all tasks: `list`

Shows every task currently stored in GoldenTrace.

Format: `list`

Example:

```text
list
```

### Adding a to-do task: `todo`

Adds a basic to-do task.

Format: `todo DESCRIPTION`

Example:

```text
todo read software engineering notes
```

Expected result: a new `[T]` task is added to the list.

### Adding a deadline task: `deadline`

Adds a task with a deadline.

Format: `deadline DESCRIPTION /by DEADLINE`

Examples:

```text
deadline submit iP /by Friday
deadline pay school fees /by 2026-03-10
```

Expected result: a new `[D]` task is added and shown with its `by:` field.

### Adding an event task: `event`

Adds a task that has a start time and an end time.

Format: `event DESCRIPTION /from START_TIME /to END_TIME`

Examples:

```text
event project meeting /from Tuesday 2pm /to Tuesday 4pm
event hackathon /from 2026-03-20 0900 /to 2026-03-21 1800
```

Expected result: a new `[E]` task is added and shown with its `from:` and `to:` fields.

### Marking a task as done: `mark`

Marks the specified task as completed.

Format: `mark INDEX`

Example:

```text
mark 2
```

Expected result: task `2` is updated from `[ ]` to `[X]`.

### Marking a task as not done: `unmark`

Marks the specified task as not completed.

Format: `unmark INDEX`

Example:

```text
unmark 2
```

Expected result: task `2` is updated from `[X]` to `[ ]`.

### Deleting a task: `delete`

Deletes the specified task from the list.

Format: `delete INDEX`

Example:

```text
delete 3
```

Expected result: task `3` is removed from the list.

### Finding tasks: `find`

Finds tasks whose description contains the given text.

Format: `find TEXT`

Examples:

```text
find report
find team meeting
```

Expected result: GoldenTrace shows only the tasks whose descriptions contain the given text.

Note:

- Matching is based on whether the task description contains the exact text you entered.
- The current implementation performs a direct text match, so searches are case-sensitive.

### Exiting the program: `bye`

Closes the application.

Format: `bye`

Example:

```text
bye
```

## Saving the data

GoldenTrace saves your task list automatically to `data.txt` in the same folder as the jar file. There is no separate save command.

## Editing the data file

GoldenTrace stores tasks in a plain text file named `data.txt`.

Task records use these prefixes:

- `T` for to-do tasks
- `D` for deadline tasks
- `E` for event tasks

Examples:

```text
T | 0 | read book
D | 1 | submit report | Friday
E | 0 | team meeting | Monday 2pm | Monday 4pm
```

Edit this file manually only if you keep the format valid. If the format is invalid, GoldenTrace may fail to load the stored tasks correctly.

## Command summary

| Action | Format |
| --- | --- |
| List tasks | `list` |
| Add to-do | `todo DESCRIPTION` |
| Add deadline | `deadline DESCRIPTION /by DEADLINE` |
| Add event | `event DESCRIPTION /from START_TIME /to END_TIME` |
| Mark task | `mark INDEX` |
| Unmark task | `unmark INDEX` |
| Delete task | `delete INDEX` |
| Find tasks | `find TEXT` |
| Exit | `bye` |

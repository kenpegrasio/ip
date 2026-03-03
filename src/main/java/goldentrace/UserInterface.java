package goldentrace;

import goldentrace.type.TaskList;
import goldentrace.type.Task;

/**
 * Handles all user-facing console output for the application.
 */
public class UserInterface {
    public static final String LOGO = "       _____ _______\n"
            + "      / ____|__   __|\n"
            + "     | |  __   | |   \n"
            + "     | | |_ |  | |   \n"
            + "     | |__| |  | |   \n"
            + "     \\_____|  |_|   \n";

    /**
     * Creates the user interface helper.
     */
    public UserInterface() {
    }

    /**
     * Displays the greeting shown when the application starts.
     */
    public void greet() {
        System.out.println("    ____________________________________________________________\n");
        System.out.println("    Hello! I'm\n" + LOGO);
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________\n");
    }

    /**
     * Displays the farewell shown when the application exits.
     */
    public void sayGoodbye() {
        System.out.println("    ____________________________________________________________\n");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________\n");
    }

    /**
     * Displays an error message inside the standard output frame.
     *
     * @param message Error message to display.
     */
    public void sendError(String message) {
        System.out.println("    ____________________________________________________________\n");
        System.out.print("    " + message + "\n");
        System.out.println("    ____________________________________________________________\n");
    }

    /**
     * Displays the full task list.
     *
     * @param taskList Task list to display.
     */
    public void showTaskList(TaskList taskList) {
        System.out.println("    ____________________________________________________________\n");
        if (taskList.getSize() == 0) {
            System.out.print("    You have nothing to do! Enjoy while you can!\n");
        } else {
            System.out.print(taskList);
        }
        System.out.println("    ____________________________________________________________\n");
    }

    /**
     * Displays confirmation that a task has been added.
     *
     * @param taskList Task list after the new task has been inserted.
     */
    public void showAddTaskNotice(TaskList taskList) {
        System.out.println("    ____________________________________________________________\n");
        System.out.println("    Got it. I've added this task: ");
        System.out.println("        " + taskList.getLastTask());
        System.out.println("    Now you have " + taskList.getSize() + " tasks in the list.");
        System.out.println("    ____________________________________________________________\n");
    }

    /**
     * Displays tasks that matched a search query.
     *
     * @param taskList List of matching tasks.
     */
    public void showMatchedTasks(TaskList taskList) {
        System.out.println("    ____________________________________________________________\n");
        if (taskList.getSize() == 0) {
            System.out.println("    No matching tasks found!");
        } else {
            System.out.println("    Here are the matching tasks in your list: ");
            System.out.print(taskList);
        }
        System.out.println("    ____________________________________________________________\n");
    }

    /**
     * Displays confirmation that a task was marked or unmarked.
     *
     * @param task Task that was updated.
     * @param isMark Whether the task was marked rather than unmarked.
     */
    public void showMarkUnmarkNotice(Task task, boolean isMark) {
        System.out.println("    ____________________________________________________________\n");
        if (isMark) {
            System.out.println("    Nice! I've marked this task as done:\n");
        } else {
            System.out.println("    Nice! I've unmarked this task from done:\n");
        }
        System.out.println("        " + task);
        System.out.println("    ____________________________________________________________\n");
    }

    /**
     * Displays confirmation that a task was deleted.
     *
     * @param taskList Task list after deletion.
     * @param task Task that was removed.
     */
    public void showDeletedNotice(TaskList taskList, Task task) {
        System.out.println("    ____________________________________________________________\n");
        System.out.println("    Noted. I've removed this task: ");
        System.out.println("        " + task);
        System.out.println("    Now you have " + taskList.getSize() + " tasks in the list.");
        System.out.println("    ____________________________________________________________\n");
    }
}

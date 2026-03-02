package goldentrace;

import goldentrace.type.TaskList;
import goldentrace.type.Task;

public class UserInterface {

    public UserInterface() {
    }

    public static final String LOGO = "       _____ _______\n"
            + "      / ____|__   __|\n"
            + "     | |  __   | |   \n"
            + "     | | |_ |  | |   \n"
            + "     | |__| |  | |   \n"
            + "     \\_____|  |_|   \n";

    public void greet() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm\n" + LOGO);
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________\n");
    }

    public void sayGoodbye() {
        System.out.println("    ____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }

    public void sendError(String message) {
        System.out.println("    ____________________________________________________________\n");
        System.out.print("    " + message + "\n");
        System.out.println("    ____________________________________________________________\n");
    }

    public void showTaskList(TaskList taskList) {
        System.out.println("    ____________________________________________________________\n");
        if (taskList.getSize() == 0) {
            System.out.print("    You have nothing to do! Enjoy while you can!\n");
        } else {
            System.out.print(taskList);
        }
        System.out.println("    ____________________________________________________________\n");
    }

    public void showAddTaskNotice(TaskList taskList) {
        System.out.println("    ____________________________________________________________\n");
        System.out.println("    Got it. I've added this task: ");
        System.out.println("        " + taskList.getLastTask());
        System.out.println("    Now you have " + taskList.getSize() + " tasks in the list.");
        System.out.println("    ____________________________________________________________\n");
    }

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
}

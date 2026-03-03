package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.TaskList;

/**
 * Marks a task as not done.
 */
public class UnmarkCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private int index;

    /**
     * Creates a command that unmarks a task by index.
     *
     * @param taskList Task list to update.
     * @param ui User interface used for feedback.
     * @param index Zero-based index of the task to unmark.
     */
    public UnmarkCommand(TaskList taskList, UserInterface ui, int index) {
        this.taskList = taskList;
        this.ui = ui;
        this.index = index;
    }

    /**
     * Unmarks the task and shows the confirmation message.
     */
    @Override
    public void execute() {
        taskList.unmarkTask(index);
        ui.showMarkUnmarkNotice(taskList.getTask(index), false);
    }
}

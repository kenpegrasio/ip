package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.TaskList;

/**
 * Marks a task as done.
 */
public class MarkCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private int index;

    /**
     * Creates a command that marks a task by index.
     *
     * @param taskList Task list to update.
     * @param ui User interface used for feedback.
     * @param index Zero-based index of the task to mark.
     */
    public MarkCommand(TaskList taskList, UserInterface ui, int index) {
        this.taskList = taskList;
        this.ui = ui;
        this.index = index;
    }

    /**
     * Marks the task and shows the confirmation message.
     */
    @Override
    public void execute() {
        taskList.markTask(index);
        ui.showMarkUnmarkNotice(taskList.getTask(index), true);
    }
}

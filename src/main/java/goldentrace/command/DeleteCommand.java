package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.TaskList;
import goldentrace.type.Task;

/**
 * Removes a task from the task list.
 */
public class DeleteCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private int index;

    /**
     * Creates a command that deletes a task by index.
     *
     * @param taskList Task list to update.
     * @param ui User interface used for feedback.
     * @param index Zero-based index of the task to delete.
     */
    public DeleteCommand(TaskList taskList, UserInterface ui, int index) {
        this.taskList = taskList;
        this.ui = ui;
        this.index = index;
    }

    /**
     * Deletes the task and shows the confirmation message.
     */
    @Override
    public void execute() {
        Task deletedTask = taskList.deleteTask(index);
        ui.showDeletedNotice(taskList, deletedTask);
    }
}

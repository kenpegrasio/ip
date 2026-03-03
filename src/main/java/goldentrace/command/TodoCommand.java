package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.TaskList;
import goldentrace.type.ToDo;

/**
 * Adds a to-do task to the task list.
 */
public class TodoCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private String description;

    /**
     * Creates a command that adds a to-do task.
     *
     * @param taskList Task list to update.
     * @param ui User interface used for feedback.
     * @param description Task description.
     */
    public TodoCommand(TaskList taskList, UserInterface ui, String description) {
        this.taskList = taskList;
        this.ui = ui;
        this.description = description;
    }

    /**
     * Adds the to-do task and shows the confirmation message.
     */
    @Override
    public void execute() {
        taskList.addTask(new ToDo(this.description));
        ui.showAddTaskNotice(taskList);
    }
}

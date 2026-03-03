package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.Deadline;
import goldentrace.type.TaskList;

/**
 * Adds a deadline task to the task list.
 */
public class DeadlineCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private String description;
    private String deadline;

    /**
     * Creates a command that adds a deadline task.
     *
     * @param taskList Task list to update.
     * @param ui User interface used for feedback.
     * @param description Task description.
     * @param deadline Deadline associated with the task.
     */
    public DeadlineCommand(TaskList taskList, UserInterface ui, String description, String deadline) {
        this.taskList = taskList;
        this.ui = ui;
        this.description = description;
        this.deadline = deadline;
    }

    /**
     * Adds the deadline task and shows the confirmation message.
     */
    @Override
    public void execute() {
        taskList.addTask(new Deadline(description, deadline));
        ui.showAddTaskNotice(taskList);
    }
}

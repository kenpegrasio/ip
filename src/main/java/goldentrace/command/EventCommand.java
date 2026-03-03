package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.Event;
import goldentrace.type.TaskList;

/**
 * Adds an event task to the task list.
 */
public class EventCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private String description;
    private String startDate;
    private String finishDate;

    /**
     * Creates a command that adds an event task.
     *
     * @param taskList Task list to update.
     * @param ui User interface used for feedback.
     * @param description Task description.
     * @param startDate Event start time.
     * @param finishDate Event end time.
     */
    public EventCommand(TaskList taskList, UserInterface ui, String description, String startDate, String finishDate) {
        this.taskList = taskList;
        this.ui = ui;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    /**
     * Adds the event task and shows the confirmation message.
     */
    @Override
    public void execute() {
        taskList.addTask(new Event(description, startDate, finishDate));
        ui.showAddTaskNotice(taskList);
    }
}

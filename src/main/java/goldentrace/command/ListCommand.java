package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.TaskList;

/**
 * Displays the current task list.
 */
public class ListCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;

    /**
     * Creates a command that lists all tasks.
     *
     * @param taskList Task list to display.
     * @param ui User interface used for output.
     */
    public ListCommand(TaskList taskList, UserInterface ui) {
        this.taskList = taskList;
        this.ui = ui;
    }
    
    /**
     * Shows the current task list.
     */
    @Override
    public void execute() {
        ui.showTaskList(taskList);
    }
}

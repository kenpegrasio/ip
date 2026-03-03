package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.Task;
import goldentrace.type.TaskList;

/**
 * Searches the task list for tasks matching a keyword.
 */
public class FindCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private String description;

    /**
     * Creates a command that searches for matching tasks.
     *
     * @param taskList Task list to search.
     * @param ui User interface used for feedback.
     * @param description Keyword or phrase to search for.
     */
    public FindCommand(TaskList taskList, UserInterface ui, String description) {
        this.taskList = taskList;
        this.ui = ui;
        this.description = description;
    }

    /**
     * Finds matching tasks and displays them.
     */
    @Override
    public void execute() {
        TaskList matchedTasks = new TaskList();
        for (int i = 0; i < taskList.getSize(); i++) {
            Task currentTask = taskList.getTask(i);
            if (currentTask.checkMatch(this.description)) {
                matchedTasks.addTask(currentTask);
            }
        }
        ui.showMatchedTasks(matchedTasks);
    }
}

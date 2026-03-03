package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.Task;
import goldentrace.type.TaskList;

public class FindCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private String description;

    public FindCommand(TaskList taskList, UserInterface ui, String description) {
        this.taskList = taskList;
        this.ui = ui;
        this.description = description;
    }

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

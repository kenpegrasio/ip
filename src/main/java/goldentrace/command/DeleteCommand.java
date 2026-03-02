package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.TaskList;
import goldentrace.type.Task;

public class DeleteCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private int index;

    public DeleteCommand(TaskList taskList, UserInterface ui, int index) {
        this.taskList = taskList;
        this.ui = ui;
        this.index = index;
    }

    @Override
    public void execute() {
        Task deletedTask = taskList.deleteTask(index);
        ui.showDeletedNotice(taskList, deletedTask);
    }
}

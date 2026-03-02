package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.TaskList;
import goldentrace.type.ToDo;

public class TodoCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private String description;

    public TodoCommand(TaskList taskList, UserInterface ui, String description) {
        this.taskList = taskList;
        this.ui = ui;
        this.description = description;
    }

    @Override
    public void execute() {
        taskList.addTask(new ToDo(this.description));
        ui.showAddTaskNotice(taskList);
    }
}

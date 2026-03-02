package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.TaskList;

public class ListCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;

    public ListCommand(TaskList taskList, UserInterface ui) {
        this.taskList = taskList;
        this.ui = ui;
    }
    
    @Override
    public void execute() {
        ui.showTaskList(taskList);
    }
}

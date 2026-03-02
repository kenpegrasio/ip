package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.TaskList;

public class UnmarkCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private int index;

    public UnmarkCommand(TaskList taskList, UserInterface ui, int index) {
        this.taskList = taskList;
        this.ui = ui;
        this.index = index;
    }

    @Override
    public void execute() {
        taskList.unmarkTask(index);
        ui.showMarkUnmarkNotice(taskList.getTask(index), false);
    }
}

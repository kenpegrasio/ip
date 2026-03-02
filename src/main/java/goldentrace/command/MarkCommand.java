package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.TaskList;

public class MarkCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private int index;

    public MarkCommand(TaskList taskList, UserInterface ui, int index) {
        this.taskList = taskList;
        this.ui = ui;
        this.index = index;
    }

    @Override
    public void execute() {
        taskList.markTask(index);
        ui.showMarkUnmarkNotice(taskList.getTask(index), true);
    }
}

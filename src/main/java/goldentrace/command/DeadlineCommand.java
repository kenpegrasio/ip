package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.Deadline;
import goldentrace.type.TaskList;

public class DeadlineCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private String description;
    private String deadline;

    public DeadlineCommand(TaskList taskList, UserInterface ui, String description, String deadline) {
        this.taskList = taskList;
        this.ui = ui;
        this.description = description;
        this.deadline = deadline;
    }

    @Override
    public void execute() {
        taskList.addTask(new Deadline(description, deadline));
        ui.showAddTaskNotice(taskList);
    }
}

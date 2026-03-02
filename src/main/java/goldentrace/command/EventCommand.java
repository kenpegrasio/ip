package goldentrace.command;

import goldentrace.UserInterface;
import goldentrace.type.Event;
import goldentrace.type.TaskList;

public class EventCommand implements Command {
    private TaskList taskList;
    private UserInterface ui;
    private String description;
    private String startDate;
    private String finishDate;

    public EventCommand(TaskList taskList, UserInterface ui, String description, String startDate, String finishDate) {
        this.taskList = taskList;
        this.ui = ui;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    @Override
    public void execute() {
        taskList.addTask(new Event(description, startDate, finishDate));
        ui.showAddTaskNotice(taskList);
    }
}

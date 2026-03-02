package goldentrace.type;

public class TaskList {
    private Task[] tasks;
    private int numberOfTasks;

    public TaskList() {
        this.tasks = new Task[100];
        this.numberOfTasks = 0;
    }

    public int getSize() {
        return numberOfTasks;
    }

    public void addTask(Task task) {
        tasks[numberOfTasks] = task;
        numberOfTasks++;
    }

    public void markTask(int index) {
        tasks[index].mark();
    }

    public void unmarkTask(int index) {
        tasks[index].unmark();
    }

    public Task getTask(int index) {
        return tasks[index];
    }

    public Task getLastTask() {
        return tasks[numberOfTasks - 1];
    }    

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < numberOfTasks; i++) {
            res += "    " + (i + 1) + "." + tasks[i] + "\n";
        }
        return res;
    }
}

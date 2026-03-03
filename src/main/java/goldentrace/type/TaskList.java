package goldentrace.type;

import java.util.ArrayList;

/**
 * Stores and manages the collection of tasks in memory.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Creates an empty task list.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Returns the number of tasks currently stored.
     *
     * @return Number of tasks in the list.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Adds a task to the end of the list.
     *
     * @param task Task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Marks the task at the given index as done.
     *
     * @param index Zero-based index of the task to mark.
     */
    public void markTask(int index) {
        tasks.get(index).mark();
    }

    /**
     * Marks the task at the given index as not done.
     *
     * @param index Zero-based index of the task to unmark.
     */
    public void unmarkTask(int index) {
        tasks.get(index).unmark();
    }

    /**
     * Removes and returns the task at the given index.
     *
     * @param index Zero-based index of the task to delete.
     * @return Removed task.
     */
    public Task deleteTask(int index) {
        return tasks.remove(index);
    }

    /**
     * Returns the task at the given index.
     *
     * @param index Zero-based index of the requested task.
     * @return Task at the requested position.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Returns the most recently added task.
     *
     * @return Last task in the list.
     */
    public Task getLastTask() {
        return tasks.get(tasks.size() - 1);
    }

    /**
     * Returns the formatted text shown to the user.
     *
     * @return Display representation of the full task list.
     */
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < tasks.size(); i++) {
            res += "    " + (i + 1) + "." + tasks.get(i) + "\n";
        }
        return res;
    }
}

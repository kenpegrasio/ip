package goldentrace.type;

/**
 * Represents a generic task with a description and completion state.
 */
public class Task {
    private String description;
    private boolean isDone;

    /**
     * Creates an incomplete task.
     *
     * @param description Task description.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Creates a task with an explicit completion state.
     *
     * @param description Task description.
     * @param isDone Whether the task is completed.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Checks whether the task description contains the given keyword.
     *
     * @param keyword Keyword to match against the description.
     * @return {@code true} if the keyword is present, otherwise {@code false}.
     */
    public boolean checkMatch(String keyword) {
        return description.contains(keyword);
    }

    /**
     * Marks the task as completed.
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Marks the task as not completed.
     */
    public void unmark() {
        this.isDone = false;
    }

    /**
     * Converts the task into its storage representation.
     *
     * @return String representation used in the data file.
     */
    public String toDatabaseString() {
        return (this.isDone ? "1" : "0") + " | " + this.description;
    }

    /**
     * Returns the formatted text shown to the user.
     *
     * @return Display representation of the task.
     */
    @Override
    public String toString() {
        return (isDone ? "[X]" : "[ ]") + " " + this.description;
    }
}

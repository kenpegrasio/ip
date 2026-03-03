package goldentrace.type;

/**
 * Represents a basic to-do task.
 */
public class ToDo extends Task {
    /**
     * Creates an incomplete to-do task.
     *
     * @param description Task description.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Creates a to-do task with an explicit completion state.
     *
     * @param description Task description.
     * @param isDone Whether the task is already completed.
     */
    public ToDo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * Converts the to-do task into its storage representation.
     *
     * @return String representation used in the data file.
     */
    @Override
    public String toDatabaseString() {
        return "T | " + super.toDatabaseString();
    }

    /**
     * Returns the formatted text shown to the user.
     *
     * @return Display representation of the to-do task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

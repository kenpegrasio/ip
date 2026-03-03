package goldentrace.type;

/**
 * Represents a task with a deadline.
 */
public class Deadline extends Task {
    private String by;

    /**
     * Creates an incomplete deadline task.
     *
     * @param description Task description.
     * @param by Deadline value.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Creates a deadline task with an explicit completion state.
     *
     * @param description Task description.
     * @param isDone Whether the task is already completed.
     * @param by Deadline value.
     */
    public Deadline(String description, boolean isDone, String by) {
        super(description, isDone);
        this.by = by;
    }

    /**
     * Converts the deadline task into its storage representation.
     *
     * @return String representation used in the data file.
     */
    @Override
    public String toDatabaseString() {
        return "D | " + super.toDatabaseString() + " | " + this.by;
    }

    /**
     * Returns the formatted text shown to the user.
     *
     * @return Display representation of the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

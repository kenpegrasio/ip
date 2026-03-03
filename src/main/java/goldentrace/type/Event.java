package goldentrace.type;

/**
 * Represents a task scheduled between a start and end time.
 */
public class Event extends Task {
    private String from;
    private String to;

    /**
     * Creates an incomplete event task.
     *
     * @param description Task description.
     * @param from Event start time.
     * @param to Event end time.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Creates an event task with an explicit completion state.
     *
     * @param description Task description.
     * @param isDone Whether the task is already completed.
     * @param from Event start time.
     * @param to Event end time.
     */
    public Event(String description, boolean isDone, String from, String to) {
        super(description, isDone);
        this.from = from;
        this.to = to;
    }

    /**
     * Converts the event task into its storage representation.
     *
     * @return String representation used in the data file.
     */
    @Override
    public String toDatabaseString() {
        return "E | " + super.toDatabaseString() + " | " + this.from + " | " + this.to;
    }

    /**
     * Returns the formatted text shown to the user.
     *
     * @return Display representation of the event task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from + " to: " + this.to + ")";
    }
}

package goldentrace.type;

public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    public ToDo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String toDatabaseString() {
        return "T | " + super.toDatabaseString();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

package goldentrace;

/**
 * Represents an application-specific exception in GoldenTrace.
 */
public class GoldenTraceException extends Exception {
    /**
     * Creates an exception with the given error message.
     *
     * @param message Details about the error.
     */
    public GoldenTraceException(String message) {
        super(message);
    }
}

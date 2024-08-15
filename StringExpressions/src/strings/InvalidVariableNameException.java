package strings;

public class InvalidVariableNameException extends Exception {
    /**
     * Exception supervised for invalid variable name.
     * The variable can only be a lowercase Latin letter.
     * @param message to be displayed.
     */
    public InvalidVariableNameException(String message) {
        super(message);
    }
}

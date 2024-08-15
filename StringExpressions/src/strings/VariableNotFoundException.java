package strings;

public class VariableNotFoundException extends Exception {
    /**
     * Exception supervised in case a variable has no value
     * @param message to be displayed
     */
    public VariableNotFoundException(String message) {
        super(message);
    }
}

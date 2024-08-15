package strings;

public abstract class Operators extends StringExpression {
    // Attributes
    private int numberArguments;
    private final StringExpression[] arguments = new StringExpression[numberArguments];
    // Methods
    /**
     * Function that returns the symbol of a given operator.
     * @return the symbol representing the given operator.
     */
    public abstract String name();

}

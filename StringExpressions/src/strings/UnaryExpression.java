package strings;

public abstract class UnaryExpression extends Operators {
    // Attributes
    protected static final int numberArguments = 1;
    protected final StringExpression[] arguments = new StringExpression[numberArguments];

    // Technical
    /**
     * Constructor creating unary operator.
     * @param str1 Array contained arguments
     */
    public UnaryExpression(StringExpression str1) {
        arguments[0] = str1;
    }

    // Methods
    @Override
    public int priority() {
        return 1;
    }

    @Override
    public String toString() {
        String rightStr = arguments[0].toString();
        if (arguments[0].priority() > priority()) {
            rightStr = "(" + rightStr + ")";
        }
        return this.name() + rightStr;
    }

}

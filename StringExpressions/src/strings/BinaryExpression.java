package strings;

public abstract class BinaryExpression extends Operators {
    // Attributes
    protected static final int numberArguments = 2;
    protected final StringExpression[] arguments = new StringExpression[numberArguments];

    // Technical
    /**
     * Constructor creating binary operator.
     * @param str1 first StringExpression in arguments
     * @param str2 second StringExpression in arguments
     */
    public BinaryExpression(StringExpression str1, StringExpression str2) {
        arguments[0] = str1;
        arguments[1] = str2;
    }

    // Methods
    @Override
    public int priority() {
        return 2;
    }

    @Override
    public String toString() {
        String leftStr, rightStr;
        if (arguments[0].priority() <= priority()) {
            leftStr = arguments[0].toString();
        } else {
            leftStr = "(" + arguments[0].toString() + ")";
        }
        if (arguments[1].priority() <= priority()) {
            rightStr = arguments[1].toString();
        } else {
            rightStr = "(" + arguments[1].toString() + ")";
        }
        return leftStr + this.name() + rightStr;

    }

}

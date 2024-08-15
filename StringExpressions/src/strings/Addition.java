package strings;

public class Addition extends BinaryExpression {
    // Technical
    /**
     * Constructor that creates a concatenation of two strings.
     * * @param str1 first StringExpression
     * @param str2 second StringExpression to concatenate
     */
    public Addition(StringExpression str1, StringExpression str2) {
        super(str1, str2);
    }

    // Methods
    @Override
    public String name() {
        return "&";
    }

    @Override
    public String evaluateWithoutVariables() {
        if(arguments[0].evaluateWithoutVariables() == null ||
                arguments[1].evaluateWithoutVariables() == null) {
            return null;
        } else {
            return arguments[0].evaluateWithoutVariables() +
                    arguments[1].evaluateWithoutVariables();
        }
    }

    @Override
    public String evaluate( Valuation variables) throws VariableNotFoundException,
                                                    InvalidVariableNameException {
        return arguments[0].evaluate(variables) + arguments[1].evaluate(variables);
    }

}

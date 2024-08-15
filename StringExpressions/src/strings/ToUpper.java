package strings;

public class ToUpper extends UnaryExpression {
    // Technical
    /**
     * Constructor to create a lettering consisting of capital letters of the Latin alphabet.
     * * @param str1 caption that will be changed to uppercase.
     */
    public ToUpper(StringExpression str1) {
        super(str1);
    }

    // Methods
    @Override
    public String name() {
        return "^";
    }

    @Override
    public String evaluateWithoutVariables() {
        try {
            return arguments[0].evaluateWithoutVariables().toUpperCase();
        } catch(NullPointerException e) {
            return null;
        }
    }

    @Override
    public String evaluate(Valuation variables) throws VariableNotFoundException,
                                                    InvalidVariableNameException {
        return arguments[0].evaluate(variables).toUpperCase();
    }

}

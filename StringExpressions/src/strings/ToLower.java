package strings;

public class ToLower extends UnaryExpression {
    // Technical
    /**
     * Constructor to create a lettering consisting of lower case
     * letters of the Latin alphabet.
     * * @param str1 caption that will be changed to lowercase.
     */
    public ToLower(StringExpression str1) {
        super(str1);
    }

    // Methods
    @Override
    public String name() {
        return "_";
    }

    @Override
    public String evaluateWithoutVariables() {
        try {
            return arguments[0].evaluateWithoutVariables().toLowerCase();
        } catch(NullPointerException e) {
            return null;
        }
    }

    @Override
    public String evaluate(Valuation variables) throws VariableNotFoundException,
            InvalidVariableNameException {
        return arguments[0].evaluate(variables).toLowerCase();
    }

}

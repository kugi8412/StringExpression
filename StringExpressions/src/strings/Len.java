package strings;

public class Len extends UnaryExpression {
    // Technical
    /**
     * Constructor that creates the length of the subtitle.
     * * @param str1 subtitle of which the length will be counted
     */
    public Len(StringExpression str1) {
        super(str1);
    }

    // Methods
    @Override
    public String name() {
        return "#";
    }

    @Override
    public String evaluateWithoutVariables() {
        try {
            return Integer.toString(arguments[0].evaluateWithoutVariables().length());
        } catch(NullPointerException e) {
            return null;
        }

    }

    @Override
    public String evaluate(Valuation variables) throws VariableNotFoundException,
            InvalidVariableNameException {
        return Integer.toString(arguments[0].evaluate(variables).length());
    }

}

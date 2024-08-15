package strings;

public class Constant extends StringExpression {
    // Attributes
    private final String value;

    // Technical
    /**
     * Constructor creating a constant subtitle.
     * @param value string which will be Constant
     */
    public Constant(String value) {
        this.value = value;
    }

    // Methods
    @Override
    public String toString() {
        return "\"" + value + "\"";
    }

    @Override
    public String evaluateWithoutVariables() {
        return value;
    }

    @Override
    public String evaluate(Valuation variables) {
        return evaluateWithoutVariables();
    }

}

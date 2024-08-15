package strings;

public class Variable extends StringExpression {
    // Attributes
    private final char symbol;

    // Technical
    /**
     * Constructor to create variables
     * @param symbol that represents the variable
     * @throws InvalidVariableNameException if the symbol is not a lowercase
     *                                      letter of the Latin alphabet.
     */
    public Variable(char symbol) throws InvalidVariableNameException {
        if(symbol < 'a' || symbol > 'z') {
            throw new InvalidVariableNameException("The variable must be a lower case" +
                                                    "letter of the Latin alphabet");
        }
        this.symbol = symbol;
    }

    // Methods
    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    @Override
    public String evaluateWithoutVariables() {
        return null;
    }

    @Override
    public String evaluate(Valuation variables) throws VariableNotFoundException,
                                                    InvalidVariableNameException {
        return variables.valuate(this.symbol);
    }

}

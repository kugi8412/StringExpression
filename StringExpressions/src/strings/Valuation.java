package strings;

public class Valuation {
    // Attributes
    private final Constant[] listVariables;
    private static final int numberLetters = 26;

    // Technical
    /**
     * A parameter-free constructor that creates an empty array.
     */
    public Valuation() {
        this.listVariables = new Constant[numberLetters];
    }

    // Methods
    @Override
    public String toString() {
        boolean first = true;
        String subtitle = "Value(";
        for(int i = 0; i < numberLetters; i++) {
            if(listVariables[i] != null) {
                if(first) {
                    first = false;
                } else {
                    subtitle += ", ";
                }
                subtitle = subtitle + (char)('a'+ i) + "=" + listVariables[i];
            }
        }
        return subtitle + ")";
    }

    /**
     * Function that sets the value for a given symbol.
     * @param symbol for which we set Fixed subtitle
     * @param subtitle set Fixed subtitle
     */
    public void set(char symbol, String subtitle) throws InvalidVariableNameException {
        try {
            Variable nowySymbol = new Variable(symbol);
        } catch(InvalidVariableNameException e) {
            throw new InvalidVariableNameException("Invalid variable name (" + symbol + ")");
        }
        listVariables[symbol - 'a'] = new Constant(subtitle);
    }

    public String valuate(char symbol) throws VariableNotFoundException,
                                                InvalidVariableNameException {
        if(symbol > 'z' || symbol < 'a') {
            throw new InvalidVariableNameException("Variable must be a lower case letter" +
                                                    "of the Latin alphabet (" + symbol + ")");
        }
        if(listVariables[symbol - 'a'] == null) {
            throw new VariableNotFoundException("Variable not found " + symbol);
        }
        return listVariables[symbol - 'a'].evaluateWithoutVariables();
    }

}

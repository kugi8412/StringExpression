package strings;

public abstract class StringExpression {
    // Methods
    /** Method returns the caption as a result or the value
     * null, if it cannot be counted without the value
     */
    public abstract String evaluateWithoutVariables();
    /**
     * Method returns a subtitle as a result or signaling an error except.
     * @param variables Value containing variable assignment.
     * @throws VariableNotFoundException if variable is assigned null
     * @throws InvalidVariableNameException if the variable is not a lowercase Latin letter.
     */
    public abstract String evaluate(Valuation variables) throws VariableNotFoundException,
                                                            InvalidVariableNameException;

    /**
     * Method returns the priority of a given subtitle expression
     * @returns the largest possible number by default.
     */
    public int priority() {
        return -1;
    }
}

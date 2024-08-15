package strings;

public class Interlace extends BinaryExpression{
    // Technical
    /**
     * Constructor to create an interlacing from two StringExpressions.
     * @param str1 first StringExpression
     * @param str2 second StringExpression
     */
    public Interlace(StringExpression str1, StringExpression str2) {
        super(str1, str2);
    }

    // Metody
    @Override
    public String name() {
        return "@";
    }

    @Override
    public String evaluateWithoutVariables() {
        return this.interlace(arguments[0].evaluateWithoutVariables(),
                                arguments[1].evaluateWithoutVariables());
    }

    @Override
    public String evaluate(Valuation variables) throws VariableNotFoundException,
                                                        InvalidVariableNameException {
        return this.interlace(arguments[0].evaluate(variables),
                                arguments[1].evaluate(variables));
    }

    /**
     * The method alternates between the characters of the first and second subtitle,
     * appends the tail of the longer subtitle at the end.
     * @param str1 first string from which we start.
     * @param str2 second string
     * @return string which is the interlacing of two strings.
     */
    private String interlace(String str1, String str2) {
        if(str1 == null || str2 == null) {
            return null;
        }
        int lenStr1 = str1.length();
        int lenStr2 = str2.length();
        int min = Math.min(lenStr1, lenStr2);
        StringBuilder interlace = new StringBuilder();
        for(int i = 0; i < min; i++) {
            interlace.append(String.valueOf(str1.charAt(i)));
            interlace.append(String.valueOf(str2.charAt(i)));
        }
        if(lenStr1 > lenStr2) {
            interlace.append(str1.substring(min));
        } else {
            if (lenStr2 > lenStr1) {
                interlace.append(str2.substring(min));
            }
        }
        return interlace.toString();
    }

}

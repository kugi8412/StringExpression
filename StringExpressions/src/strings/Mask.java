package strings;

public class Mask extends BinaryExpression {
    // Technical
    /**
     * Konstruktor forming a mask from two StringExpressions
     * @param str1 first StringExpression
     * @param str2 second StringExpression
     */
    public Mask(StringExpression str1, StringExpression str2) {
        super(str1, str2);
    }

    // Methods
    @Override
    public String name() {
        return "*";
    }

    @Override
    public String evaluateWithoutVariables(){
        return this.mask(arguments[0].evaluateWithoutVariables(),
                          arguments[1].evaluateWithoutVariables());
    }

    @Override
    public String evaluate(Valuation variables) throws VariableNotFoundException,
                                                    InvalidVariableNameException {
        return this.mask(arguments[0].evaluate(variables), arguments[1].evaluate(variables));
    }

    /**
     * Method that returns string containing those characters from the first subtitle,
     * which correspond to the '*' character in the second string.
     * @param str1 first subtitle
     * @param str2 the mask for the second inscription.
     * @return string which is the result of the masking.
     */
    private String mask(String str1, String str2) {
        String mask = "";
        if(str2 == null) {
            return null;
        } else {
            if(!str2.contains("*")) {
                return "";
            }
        }
        if(str1 == null) {
            return null;
        }
        int lenStr1 = str1.length();
        int lenStr2 = str2.length();
        if(lenStr1 == 0) {
            return mask;
        } else {
            for(int i = 0; i < lenStr1; i++) {
                if('*' == str2.charAt(i % lenStr2)) {
                    mask += String.valueOf(str1.charAt(i));
                }
            }
        }
        return mask;
    }
}

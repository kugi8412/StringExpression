package main;

import strings.*;
public class Main {

    private void test(StringExpression expr, Valuation variables) {
        System.out.println("Test for " + expr + " with valuation " + variables);
        System.out.print(" - result with valuation: \"");
        try {
            System.out.println(expr.evaluate(variables) + "\"");
        } catch (VariableNotFoundException e){
            System.out.println("Test failed due to a reference to a non-existent variable: " + e);
        } catch (InvalidVariableNameException e){
            System.out.println("Test failed due to an invalid variable name in the expression: " + e);
        }

        String result = expr.evaluateWithoutVariables();
        System.out.println(" - result without valuation: " +
                (result == null ? "<no result> " : "\"" + result + "\""));
    }

    private void test1() {
        System.out.println("\ntest1");

        Valuation variables = new Valuation();
        StringExpression expr1 = new Constant("Ala");

        test(expr1, variables);
    }

    private void test2() throws InvalidVariableNameException {
        System.out.println("\ntest2");

        Valuation variables = new Valuation();
        variables.set('a', "Ala");
        StringExpression expr1 = new Variable('a');

        test(expr1, variables);
    }

    private void test3() throws InvalidVariableNameException {
        System.out.println("\ntest3");
        String text  = "Es#JrtapCPvyR+thY&+a*o@en";
        String mask  = "012*45*789*12345678*01234";
        String mask2 = "012345678*0*23**67890*23*";

        Valuation variables = new Valuation();
        StringExpression expr = new Mask(new Constant(text), new Constant(mask));
        test(expr, variables);

        expr = new Mask(new Constant(text), new Constant(mask2));
        test(expr, variables);

        variables.set('v', mask);
        expr = new Mask(new Constant(text), new Variable('v'));
        test(expr, variables);
    }

    private void test4() throws InvalidVariableNameException {
        System.out.println("\ntest4");
        Valuation variables = new Valuation();
        variables.set('a', "Ala");
        variables.set('b', "ma");

        StringExpression expr1 = new Addition(new Variable('a'), new Variable('b'));
        test(expr1, variables);

        variables.set('c', "kota");
        expr1 = new Addition(expr1, new Variable('c'));
        test(expr1, variables);
    }

    private void test5() throws InvalidVariableNameException {
        System.out.println("\ntest5");
        Valuation variables = new Valuation();
        variables.set('a', "Ala");

        StringExpression expr1 = new Interlace(new Variable('a'), new Constant("KOT"));
        test(expr1, variables);
    }

    public static void main(String[] args) throws InvalidVariableNameException {
        try {
            Main main = new Main();
            main.test1();
            main.test2();
            main.test3();
            main.test4();
            main.test5();
        } catch (InvalidVariableNameException e) {
            System.out.println("Failure to complete all tests: " + e);
        }

        System.out.println("End of program");
    }
}

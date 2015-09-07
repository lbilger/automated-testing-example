package de.dlh.lhind.testing;

/**
 * Adds up numbers from an input string.
 */
public class Calculator {

    private final Parser parser;

    /**
     * Constructor.
     *
     * @param parser the parser to use for parsing input strings into number sequences.
     */
    public Calculator(Parser parser) {
        this.parser = parser;
    }

    /**
     * Add up numbers found in the specified input string and return the sum.
     *
     * @param input input string
     * @return the sum of all numbers found in the input string
     */
    public int calculate(String input) {
        int sum = 0;
        for (Integer number : parser.parse(input)) {
            sum += number;
        }
        return sum;
    }
}

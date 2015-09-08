package de.dlh.lhind.testing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Adds up numbers from an input string.
 */
@RequestScoped
public class Calculator {

    @Inject
    private Parser parser;

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

package de.dlh.lhind.testing;

import com.google.common.base.Strings;

/**
 * Adds up numbers from an input string.
 */
public class Calculator {

    /**
     * Add up numbers found in the specified input string and return the sum.
     *
     * @param input input string
     * @return the sum of all numbers found in the input string
     */
    public int calculate(String input) {
        return Strings.isNullOrEmpty(input) ? 0 : Integer.valueOf(input);
    }
}

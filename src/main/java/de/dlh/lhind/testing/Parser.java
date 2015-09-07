package de.dlh.lhind.testing;

import java.util.List;

/**
 * Parser for splitting a string into numbers.
 */
public interface Parser {

    /**
     * Parse the given input string and return a list of the contained numbers.
     *
     * @param input the input string
     * @return list of numbers contained in the input string
     */
    List<Integer> parse(String input);
}

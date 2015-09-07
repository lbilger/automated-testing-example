package de.dlh.lhind.testing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void returnsZeroForEmptyString() {
        Calculator calculator = new Calculator();

        int result = calculator.calculate("");

        assertEquals(0, result);
    }
}

package de.dlh.lhind.testing;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @Parameters({", 0",
            "1, 1",
            "2, 2"})
    public void returnsExpectedResultForInput(String input, int expectedResult) {
        int result = calculator.calculate(input);

        assertEquals(expectedResult, result);
    }
}

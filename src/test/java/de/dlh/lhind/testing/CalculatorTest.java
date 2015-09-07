package de.dlh.lhind.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatorTest {

    private final Calculator calculator = new Calculator();
    
    @Parameter(0)
    public String input;

    @Parameter(1)
    public int expectedResult;

    @Parameters(name = "{index}: calculate({0})={1}")
    public static Iterable<Object[]> produceExamples() {
        return asList(
                new Object[]{"", 0},
                new Object[]{"1", 1},
                new Object[]{"2", 2}
        );
    }

    @Test
    public void returnsExpectedResultForInput() {
        int result = calculator.calculate(input);

        assertEquals(expectedResult, result);
    }
}

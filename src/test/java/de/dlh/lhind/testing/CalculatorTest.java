package de.dlh.lhind.testing;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatorTest {

    @Test
    public void returnsExpectedResultForInput() {
        Parser parser = mock(Parser.class);
        Calculator calculator = new Calculator(parser);
        when(parser.parse("1,3,0")).thenReturn(asList(1, 3, 0));

        int result = calculator.calculate("1,3,0");

        assertEquals(4, result);
    }
}

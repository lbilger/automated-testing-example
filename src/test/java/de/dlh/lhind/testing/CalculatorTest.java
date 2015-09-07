package de.dlh.lhind.testing;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CalculatorTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    
    @Mock
    private Parser parser;

    @Test
    public void returnsExpectedResultForInput() {
        Calculator calculator = new Calculator(parser);
        when(parser.parse("1,3,0")).thenReturn(asList(1, 3, 0));

        int result = calculator.calculate("1,3,0");

        assertEquals(4, result);
    }
}

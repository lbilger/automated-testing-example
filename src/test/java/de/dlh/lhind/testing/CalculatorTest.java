package de.dlh.lhind.testing;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.needle4j.annotation.ObjectUnderTest;
import org.needle4j.junit.NeedleRule;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class CalculatorTest {
    @Rule
    public NeedleRule needleRule = new NeedleRule();

    @ObjectUnderTest
    private Calculator calculator;

    @Mock
    private Parser parser;

    @Test
    public void returnsExpectedResultForInput() {
        when(parser.parse("1,3,0")).thenReturn(asList(1, 3, 0));
        
        int result = calculator.calculate("1,3,0");

        assertThat(result).isEqualTo(4);
    }
}

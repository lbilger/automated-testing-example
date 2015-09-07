package de.dlh.lhind.testing;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

public class CalculatorTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Parser parser;

    @Test
    public void returnsExpectedResultForInput() {
        given(parser.parse("1,3,0")).willReturn(asList(1, 3, 0));
        Calculator calculator = new Calculator(parser);

        // when
        int result = calculator.calculate("1,3,0");

        then(parser).should().parse("1,3,0");
        assertEquals(4, result);
    }
}

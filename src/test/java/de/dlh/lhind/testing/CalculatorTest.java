package de.dlh.lhind.testing;

import org.junit.Rule;
import org.junit.Test;
import org.needle4j.annotation.InjectIntoMany;
import org.needle4j.annotation.ObjectUnderTest;
import org.needle4j.junit.NeedleRule;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Rule
    public NeedleRule needleRule = new NeedleRule();

    @ObjectUnderTest
    private Calculator calculator;

    @InjectIntoMany
    private Parser parser = new CommaSeparatedParser();

    @Test
    public void returnsExpectedResultForInput() {
        int result = calculator.calculate("1,3,0");

        assertThat(result).isEqualTo(4);
    }
}

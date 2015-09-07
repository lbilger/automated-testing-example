package de.dlh.lhind.testing;

import org.junit.Rule;
import org.junit.Test;
import org.needle4j.annotation.ObjectUnderTest;
import org.needle4j.junit.NeedleRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.needle4j.injection.InjectionProviders.providerForInstance;

public class CalculatorTest {
    @Rule
    public NeedleRule needleRule = new NeedleRule(providerForInstance(new CommaSeparatedParser()));

    @ObjectUnderTest
    private Calculator calculator;

    @Test
    public void returnsExpectedResultForInput() {
        int result = calculator.calculate("1,3,0");

        assertThat(result).isEqualTo(4);
    }
}

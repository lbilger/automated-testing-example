package de.dlh.lhind.testing;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;

public class CalculatorTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Parser parser;

    @Test
    public void returnsExpectedResultForInput() {
        Calculator calculator = new Calculator(parser);
        doAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return newArrayList(transform(Splitter.on(",").split((String) invocation.getArguments()[0]),
                        new Function<String, Integer>() {
                            public Integer apply(String input) {
                                return Integer.valueOf(input);
                            }
                        }));
            }
        }).when(parser).parse(anyString());

        int result = calculator.calculate("1,3,0");

        assertEquals(4, result);
    }
}

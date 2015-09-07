package de.dlh.lhind.testing;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    @Test
    public void returnsExpectedResultForInput() {
        Parser parser = spy(new CommaSeparatedParser());
        Calculator calculator = new Calculator(parser);
        doAnswer(new Answer<List<Integer>>() {
            @SuppressWarnings("unchecked")
            public List<Integer> answer(InvocationOnMock invocation) throws Throwable {
                System.out.println("Parser spy called with parameters " + invocation.getArguments()[0]);
                return (List<Integer>) invocation.callRealMethod();
            }
        }).when(parser).parse(anyString());
        
        int result = calculator.calculate("1,3,0");

        assertEquals(4, result);
        verify(parser).parse("1,3,0");
        verifyNoMoreInteractions(parser);
    }
}

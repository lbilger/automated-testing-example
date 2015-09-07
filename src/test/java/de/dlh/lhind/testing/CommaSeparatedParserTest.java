package de.dlh.lhind.testing;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CommaSeparatedParserTest {
    private CommaSeparatedParser commaSeparatedParser = new CommaSeparatedParser();

    @Test
    public void returnsEmptyListForEmptyString() {
        List<Integer> result = commaSeparatedParser.parse("");

        assertNotNull(result);
        assertEquals(0, result.size());
        // or:
        assertTrue(result.isEmpty());
    }

    @Test
    public void parsesCommaSeparatedNumbers() {
        List<Integer> result = commaSeparatedParser.parse("1,3,0");

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(1, (int) result.get(0));
        assertEquals(3, (int) result.get(1));
        assertEquals(0, (int) result.get(2));
    }
}

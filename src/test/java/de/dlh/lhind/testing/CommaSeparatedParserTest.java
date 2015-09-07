package de.dlh.lhind.testing;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class CommaSeparatedParserTest {
    private CommaSeparatedParser commaSeparatedParser = new CommaSeparatedParser();

    @Test
    public void returnsEmptyListForEmptyString() {
        List<Integer> result = commaSeparatedParser.parse("");

        assertThat(result, is(notNullValue()));
        assertThat(result, hasSize(0));
        // or:
        assertThat(result, is(empty()));
    }

    @Test
    public void parsesCommaSeparatedNumbers() {
        List<Integer> result = commaSeparatedParser.parse("1,3,0");

        assertThat(result, is(notNullValue()));
        assertThat(result, contains(1, 3, 0));
    }
}

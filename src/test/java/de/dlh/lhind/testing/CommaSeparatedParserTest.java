package de.dlh.lhind.testing;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CommaSeparatedParserTest {
    private CommaSeparatedParser commaSeparatedParser = new CommaSeparatedParser();

    @Test
    public void returnsEmptyListForEmptyString() {
        List<Integer> result = commaSeparatedParser.parse("");

        assertThat(result).isNotNull();
        assertThat(result).hasSize(0);
        // or:
        assertThat(result).isEmpty();
    }

    @Test
    public void parsesCommaSeparatedNumbers() {
        List<Integer> result = commaSeparatedParser.parse("1,3,0");

        assertThat(result).isNotNull();
        assertThat(result).containsExactly(1, 3, 0);
    }
}

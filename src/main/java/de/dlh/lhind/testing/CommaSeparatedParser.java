package de.dlh.lhind.testing;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;

import java.util.List;

/**
 * {@link Parser} for splitting a string into numbers by separating commas.
 */
public class CommaSeparatedParser implements Parser {

    public List<Integer> parse(String input) {
        return FluentIterable.from(Splitter.on(",").omitEmptyStrings().split(input))
                .transform(new Function<String, Integer>() {

                    public Integer apply(String input) {
                        return Integer.valueOf(input);
                    }
                })
                .toList();
    }
}

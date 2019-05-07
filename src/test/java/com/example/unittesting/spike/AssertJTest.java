package com.example.unittesting.spike;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(12,13,45);
        /*MatcherAssert.assertThat(numbers, hasSize(3));
        MatcherAssert.assertThat(numbers, hasItems(12,45));
        MatcherAssert.assertThat(numbers, everyItem(greaterThan(10));
        MatcherAssert.assertThat(numbers, everyItem(lessThan(50));
        MatcherAssert.assertThat("", isEmptyString());
        MatcherAssert.assertThat("ABCDE", containsString("ABC"));
        MatcherAssert.assertThat("ABCDE", startsWith("ABC"));
        MatcherAssert.assertThat("ABCDE", endsWith("ABC"));*/

        assertThat(numbers).hasSize(3)
                            .contains(12,45)
                            .allMatch(x->x>10)
                            .allMatch(x-> x<100)
                            .noneMatch(x->x<0);

        assertThat("").isEmpty();
        assertThat("ABCDE").contains("BCD")
                                  .startsWith("ABC")
                                    .endsWith("CDE");




    }
}

package com.example.unittesting.spike;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class HamcrestMarchersTest {

    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(12,13,45);
        MatcherAssert.assertThat(numbers, hasSize(3));
        MatcherAssert.assertThat(numbers, hasItems(12,45));
        MatcherAssert.assertThat(numbers, everyItem(greaterThan(10)));
        MatcherAssert.assertThat(numbers, everyItem(lessThan(50)));
        MatcherAssert.assertThat("", isEmptyString());
        MatcherAssert.assertThat("ABCDE", containsString("ABC"));
        MatcherAssert.assertThat("ABCDE", startsWith("ABC"));
        MatcherAssert.assertThat("ABCDE", endsWith("CDE"));


    }
}

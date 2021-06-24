import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jun 21, 2021
 * Ref: https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique
 */

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public static void main(String[] args) {

    }

    static Stream<Arguments> inputOutputValues() {
//        Expected Value, Actual Value
        return Stream.of(
                Arguments.of("aab", 0),
                Arguments.of("ceabaacb", 2),
                Arguments.of("aaabbbcc", 2)
        );
    }

    static Function<String, Object> function = MinimumDeletionsToMakeCharacterFrequenciesUnique::minDeletions;

    @ParameterizedTest
    @MethodSource("inputOutputValues")
    void runTest(String input, Object expected) {
        assertEquals(expected, function.apply(input));
    }

    public static int minDeletions(String s) {
        int[] counts = new int[26];
        for (char cur : s.toCharArray()) {
            counts[cur - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int del = 0;
        for (int count : counts) {
            if (count == 0) continue;
            while (set.contains(count) && count > 0) {
                count--;
                del++;
            }
            set.add(count);
        }
        return del;
    }
}

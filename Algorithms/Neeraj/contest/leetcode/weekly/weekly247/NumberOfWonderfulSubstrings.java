package weekly.weekly247;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jun 26, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-247/problems/number-of-wonderful-substrings/
 */

public class NumberOfWonderfulSubstrings {

    public static void main(String[] args) {

    }

    static Stream<Arguments> inputOutputValues() {
//        Expected Value, Actual Value
        return Stream.of(
                Arguments.of("aba", 4),
                Arguments.of("aabb", 9),
                Arguments.of("he", 2),
                Arguments.of("ehaehcjjaafjdceac", 29)
        );
    }

    static Function<String, Long> function = NumberOfWonderfulSubstrings::wonderfulSubstrings;

    @ParameterizedTest
    @MethodSource("inputOutputValues")
    void runTest(String input, long expected) {
        assertEquals(expected, function.apply(input));
    }

    public static long wonderfulSubstrings(String word) {
        long count = 0;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            count++;
            int[] counts = new int[10];
            counts[word.charAt(i) - 'a']++;
            for (int j = i + 1; j < len; j++) {
                counts[word.charAt(j) - 'a']++;
                if (isWonderful(counts)) count++;
            }
        }
        return count;
    }

    private static boolean isWonderful(int[] counts) {
        return Arrays.stream(counts).filter(val -> val == 1).count() <= 1;
    }
}

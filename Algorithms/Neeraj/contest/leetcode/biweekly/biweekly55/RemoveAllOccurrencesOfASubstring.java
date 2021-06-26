package biweekly.biweekly55;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jun 26, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-55/problems/remove-all-occurrences-of-a-substring/
 */

public class RemoveAllOccurrencesOfASubstring {

    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }

    static Stream<Arguments> inputOutputValues() {
//        Expected Value, Actual Value
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, null)
        );
    }

    static Function<Object, Object> function;

    @ParameterizedTest
    @MethodSource("inputOutputValues")
    void runTest(Object input, Object expected) {
        assertEquals(expected, function.apply(input));
    }

    public static String removeOccurrences(String s, String part) {
        boolean reduced = true;
        while (reduced) {
            int idx = 0, len = s.length();
            StringBuilder sb = new StringBuilder();
            while (idx < len) {
                if (s.charAt(idx) == part.charAt(0)) {
//                Then match s and p.
                    int j = idx, k = 0;
                    boolean matched = true;
                    while (j < len && k < part.length() && matched) {
                        matched = s.charAt(j++) == part.charAt(k++);
                    }
                    if (matched && k == part.length()) {
                        idx = j;
                    } else {
                        sb.append(s.charAt(idx++));
                    }
                } else {
                    sb.append(s.charAt(idx++));
                }
            }
            reduced = !s.equals(sb.toString());
            s = sb.toString();
        }
        return s;
    }
}

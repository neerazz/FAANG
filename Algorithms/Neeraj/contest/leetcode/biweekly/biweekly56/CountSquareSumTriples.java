package biweekly.biweekly56;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jul 10, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-56/problems/count-square-sum-triples/
 */

public class CountSquareSumTriples {

    public static void main(String[] args) {

    }

    static Stream<Arguments> inputOutputValues() {
//        Expected Value, Actual Value
        return Stream.of(
                Arguments.of(5, 2),
                Arguments.of(10, 4),
                Arguments.of(18, 10)
        );
    }

    static Function<Integer, Integer> function = CountSquareSumTriples::countTriples;

    @ParameterizedTest
    @MethodSource("inputOutputValues")
    void runTest(Integer input, Integer expected) {
        assertEquals(expected, function.apply(input));
    }

    public static int countTriples(int n) {
        int count = 0;
        for (int a = 2; a <= n; a++) {
            for (int b = 2; b <= n; b++) {
                if (a == b) continue;
                int sqr = a * a + b * b;
                int c = (int) Math.sqrt(sqr);
                if (c * c == sqr && c <= n) {
                    System.out.printf("(%d, %d, %d) = (%d,%d,%d)", a, b, c, a * a, b * b, c * c);
                    count++;
                }
            }
        }
        return count;
    }
}

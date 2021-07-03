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
 * Ref: https://leetcode.com/contest/weekly-contest-247/problems/maximum-product-difference-between-two-pairs/
 */

public class MaximumProductDifferenceBetweenTwoPairs {

    public static void main(String[] args) {

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

    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        long first = (long) nums[len - 1] * nums[len-2], last = (long) nums[0] * nums[1];
        return (int) (first - last);
    }
}

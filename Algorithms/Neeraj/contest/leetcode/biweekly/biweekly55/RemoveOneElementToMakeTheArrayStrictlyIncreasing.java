package biweekly.biweekly55;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jun 26, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-55/problems/remove-one-element-to-make-the-array-strictly-increasing/
 */

public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {

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

    public static boolean canBeIncreasing(int[] nums) {
        int count = 0, len = nums.length;
        if (isIncreasing(nums)) return true;
        for (int i = 0; i < len; i++) {
            int[] temp = new int[len - 1];
            int idx = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                temp[idx++] = nums[j];
            }
            if (isIncreasing(temp)) return true;
        }
        return false;
    }

    private static boolean isIncreasing(int[] nums) {
        int pre = -1;
        for (int cur : nums) {
            if (pre != -1 && pre >= cur) {
                return false;
            }
            pre = cur;
        }
        return true;
    }
}

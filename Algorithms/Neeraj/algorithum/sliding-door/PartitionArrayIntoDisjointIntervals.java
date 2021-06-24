import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jun 21, 2021
 * Ref: https://leetcode.com/problems/partition-array-into-disjoint-intervals/
 */

public class PartitionArrayIntoDisjointIntervals {

    public static void main(String[] args) {

    }

    static Stream<Arguments> inputOutputValues() {
//        Expected Value, Actual Value
        return Stream.of(
                Arguments.of(new int[]{5, 0, 3, 8, 6}, 3),
                Arguments.of(new int[]{1, 1}, 1),
                Arguments.of(new int[]{1, 1, 1, 0, 6, 12}, 4)
        );
    }

    static Function<int[], Object> function = PartitionArrayIntoDisjointIntervals::partitionDisjoint;

    @ParameterizedTest
    @MethodSource("inputOutputValues")
    void runTest(int[] input, Object expected) {
        assertEquals(expected, function.apply(input));
    }

    public static int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] maxLeft = new int[len], minRight = new int[len];
        int max = Integer.MIN_VALUE, min = nums[len - 1];
        for (int i = 0; i < len; i++) {
            maxLeft[i] = max = Math.max(max, nums[i]);
        }
        int leftSize = -1;
        for (int i = len - 2; i >= 0; i--) {
            int left = maxLeft[i];
//            left = max item on left.
//            min = min item on right.
            if (left <= min) leftSize = i + 1;
            min = Math.min(min, nums[i]);
        }
        return leftSize;
    }
}

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jun 23, 2021
 * Ref: https://leetcode.com/problems/maximal-network-rank/
 */

public class MaximalNetworkRank {

    public static void main(String[] args) {

    }

    static Stream<Arguments> inputOutputValues() {
//        Expected Value, Actual Value
        return Stream.of(
                Arguments.of(2, new int[][]{{1, 0}}, 1),
                Arguments.of(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}}, 4),
                Arguments.of(8, new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}}, 5),
                Arguments.of(5, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}}, 5)
        );
    }

    static BiFunction<Integer, int[][], Integer> function = MaximalNetworkRank::maximalNetworkRank;

    @ParameterizedTest
    @MethodSource("inputOutputValues")
    void runTest(Integer input1, int[][] input2, Integer expected) {
        assertEquals(expected, function.apply(input1, input2));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] hasRoad = new boolean[n][n];
        int[] counts = new int[n];
        int max = 0;
        for (int[] road : roads) {
            hasRoad[road[0]][road[1]] = hasRoad[road[1]][road[0]] = true;
            counts[road[0]]++;
            counts[road[1]]++;
        }
        for (int r1 = 0; r1 < n; r1++) {
            for (int r2 = 0; r2 < n; r2++) {
                if (r1 == r2) continue;
//                Lop though each pair of roads and find the counts, and then reduce if any by one if any roard connects to both r1, and r2.
                int cur = counts[r1] + counts[r2];
                if (hasRoad[r1][r2]) cur--;
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}

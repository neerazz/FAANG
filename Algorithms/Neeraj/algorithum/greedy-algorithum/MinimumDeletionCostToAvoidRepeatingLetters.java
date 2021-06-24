import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jun 21, 2021
 * Ref: https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 */

public class MinimumDeletionCostToAvoidRepeatingLetters {

    public static void main(String[] args) {

    }

    static Stream<Arguments> inputOutputValues() {
//        Expected Value, Actual Value
        return Stream.of(
                Arguments.of("abaac", new int[]{1, 2, 3, 4, 5}, 3),
                Arguments.of("abc", new int[]{1, 2, 3}, 0),
                Arguments.of("aabaa", new int[]{1, 2, 3, 4, 1}, 2)
        );
    }

    static BiFunction<String, int[], Object> function = MinimumDeletionCostToAvoidRepeatingLetters::minCost_2;

    @ParameterizedTest
    @MethodSource("inputOutputValues")
    void runTest(String input1, int[] input2, Object expected) {
        assertEquals(expected, function.apply(input1, input2));
    }

    public static int minCost_3(String s, int[] cost) {
        int totalCost = 0, len = s.length(), i = 0;
        while (i < len) {
            int j = i + 1;
            int curCost = cost[i], curMax = cost[i];
//            Advance and check of there are any repeated chars.
            while (j < len && s.charAt(i) == s.charAt(j)) {
//                Loop though all the k duplicate chars, and add the k-s smallest chars to teh totalCost cost.
                curCost += cost[j];
                curMax = Math.max(curMax, cost[j]);
                j++;
            }
            totalCost += curCost - curMax;
            i = j;
        }
        return totalCost;
    }

    public static int minCost_2(String s, int[] cost) {
        int totalCost = 0, len = s.length(), i = 0;
        while (i < len) {
            int j = i + 1;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(cost[i]);
//            Advance and check of there are any repeated chars.
            while (j < len && s.charAt(i) == s.charAt(j)) {
//                Loop though all the k duplicate chars, and add the k-s smallest chars to teh totalCost cost.
                pq.add(cost[j++]);
            }
            while (pq.size() > 1) {
                totalCost += pq.poll();
            }
            i = j;
        }
        return totalCost;
    }

    public static int minCost(String s, int[] cost) {
        int totalCost = 0, len = s.length();
        char pre = ' ';
        int preCost = 0;
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (pre == cur) {
                totalCost += Math.min(preCost, cost[i]);
                preCost = Math.max(preCost, cost[i]);
            } else {
                preCost = cost[i];
            }
            pre = cur;
        }
        return totalCost;
    }
}

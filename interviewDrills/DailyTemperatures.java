import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * MAANG screen drill: Daily Temperatures (monotonic decreasing stack).
 *
 * Interview signal:
 * - Do you recognize "next greater element" as a monotonic-stack pattern
 *   instead of brute-force O(n^2) double loops?
 * - Do you store indices on the stack (not values), so you can compute the
 *   distance between the warmer day and the day waiting for it?
 *
 * Problem:
 * Given an array of integer daily temperatures, return an array answer where
 * answer[i] is the number of days you have to wait after day i to get a
 * warmer temperature. If no future day is warmer, answer[i] = 0.
 *
 * Approach:
 * 1. Walk left to right keeping a stack of indices whose answer is unknown.
 * 2. While the current temperature is strictly greater than the temperature
 *    at the top index, that top index has just found its warmer day -- pop
 *    it and write the gap (currentIndex - poppedIndex) into answer.
 * 3. Push the current index. Stack stays monotonically decreasing in
 *    temperature, so each index is pushed and popped at most once.
 *
 * Complexity:
 * - Time: O(n). Each index is pushed and popped at most once.
 * - Space: O(n) for the stack and the output array.
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }

        int[] answer = new int[temperatures.length];
        Deque<Integer> waitingIndices = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!waitingIndices.isEmpty()
                    && temperatures[i] > temperatures[waitingIndices.peek()]) {
                int waitingIndex = waitingIndices.pop();
                answer[waitingIndex] = i - waitingIndex;
            }
            waitingIndices.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        expect(new int[] {1, 1, 4, 2, 1, 1, 0, 0},
                dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73}),
                "classic mixed warming and cooling stretch");

        expect(new int[] {1, 1, 1, 0},
                dailyTemperatures(new int[] {30, 40, 50, 60}),
                "strictly increasing -- every day waits one");

        expect(new int[] {0, 0, 0, 0},
                dailyTemperatures(new int[] {60, 50, 40, 30}),
                "strictly decreasing -- no warmer day ever");

        expect(new int[] {0, 0, 0, 0},
                dailyTemperatures(new int[] {50, 50, 50, 50}),
                "ties do not count -- strictly greater required");

        expect(new int[] {0},
                dailyTemperatures(new int[] {99}),
                "single day has no future");

        expect(new int[0],
                dailyTemperatures(new int[0]),
                "empty input returns empty answer");

        System.out.println("All DailyTemperatures drill checks passed.");
    }

    private static void expect(int[] expected, int[] actual, String label) {
        if (!Arrays.equals(expected, actual)) {
            throw new AssertionError(label
                    + " expected " + Arrays.toString(expected)
                    + " but got " + Arrays.toString(actual));
        }
    }
}

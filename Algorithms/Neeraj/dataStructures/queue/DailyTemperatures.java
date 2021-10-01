import java.util.Arrays;

/*
https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println("Answer is :\n" + Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})) + " should be \n[1, 1, 4, 2, 1, 1, 0, 0].");
        System.out.println("Answer is :");
        Arrays.stream(dailyTemperatures(new int[]{64, 40, 49, 73, 72, 35, 68, 83, 35, 73, 84, 88, 96, 43, 74, 63, 41, 95, 48, 46, 89, 72, 34, 85, 72, 59, 87, 49, 30, 32, 47, 34, 74, 58, 31, 75, 73, 88, 64, 92, 83, 64, 100, 99, 81, 41, 48, 83, 96, 92, 82, 32, 35, 68, 68, 92, 73, 92, 52, 33, 44, 38, 47, 88, 71, 50, 57, 95, 33, 65, 94, 44, 47, 79, 41, 74, 50, 67, 97, 31, 68, 50, 37, 70, 77, 55, 48, 30, 77, 100, 31, 100, 69, 60, 47, 95, 68, 47, 33, 64})).forEach(v -> {
            System.out.print(v + ",");
        });
        System.out.println("\nShould be \n" + "[3,1,1,4,3,1,1,3,1,1,1,1,30,1,3,2,1,25,2,1,19,2,1,3,2,1,11,5,1,1,2,1,3,2,1,2,1,2,1,3,2,1,0,46,3,1,1,1,30,18,5,1,1,2,1,12,1,10,5,1,2,1,1,4,3,1,1,11,1,1,8,1,1,5,1,3,1,1,11,1,3,2,1,1,5,3,2,1,1,0,1,0,3,2,1,0,0,2,1,0].");
    }

    //    Time: O(n2), Space : O(n)
    public static int[] dailyTemperatures(int[] T) {
        if (null == T || T.length == 0) return new int[0];
        int[] wait = new int[T.length];
        wait[T.length - 1] = 0;
        for (int i = wait.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (wait[j] != 0 && T[j] <= T[i]) {
                j = j + wait[j];
            }

            wait[i] = (T[j] > T[i]) ? j - i : 0;
        }

        return wait;
    }

    //    Time : O(n2)
    public static int[] dailyTemperatures_naive(int[] T) {
        int size = T.length;
        if (size < 1) return T;

        for (int i = 0; i < size; i++) {
            if (T[i] == 100) {
                T[i] = 0;
                continue;
            }
            int counter = 1;
            boolean foundHighest = false;
            for (int j = i + 1; j < size; j++) {
                if (T[i] < T[j]) {
                    T[i] = counter;
                    foundHighest = true;
                    break;
                } else counter++;
            }
            if (!foundHighest) T[i] = 0;
        }
        return T;
    }
}

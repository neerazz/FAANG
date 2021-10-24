import java.util.Arrays;

/**
 * Created on:  Aug 17, 2020
 * Questions: https://leetcode.com/problems/distribute-candies-to-people/
 */
public class DistributeCandiesToPeople {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(10, 3)) + " = [5,2,3]");
        System.out.println(Arrays.toString(distributeCandies(60, 4)) + " = [15,18,15,12]");
    }

    public static int[] distributeCandies(int candies, int n) {
        int[] op = new int[n];
        int round = 0;
        while (candies > 0) {
            for (int i = 0; i < n; i++) {
                int expected = (round * n) + (i + 1);
                op[i] += Math.min(candies, expected);
                candies -= expected;
                if (candies < 0) return op;
            }
            round++;
        }
        return op;
    }
}

package recursion;

/*
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.

Example 1:
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:
Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        int[] output = new int[n + 2];
        return getNthStairCombination(output, n + 1);
    }

    private static int getNthStairCombination(int[] output, int n) {
        if (n <= 1)
            return 1;
        if (output[n - 1] == 0) {
            output[n - 1] = getNthStairCombination(output, n - 1);
        }
        if (output[n - 2] == 0) {
            output[n - 1] = getNthStairCombination(output, n - 2);
        }
        return output[n - 1] + output[n - 2];
    }
}

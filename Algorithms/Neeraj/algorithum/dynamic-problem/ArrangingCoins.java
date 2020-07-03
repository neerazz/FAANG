import java.util.Stack;

/**
 * Created on:  Jul 01, 2020
 * Questions: https://leetcode.com/problems/arranging-coins
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println("********************************** Solution 1 *****************************");
        System.out.println(arrangeCoins(0) + " should be [0]");
        System.out.println(arrangeCoins(1) + " should be [1]");
        System.out.println(arrangeCoins(5) + " should be [2]");
        System.out.println(arrangeCoins(8) + " should be [3]");

        System.out.println("********************************** Solution 2 *****************************");
//        System.out.println(arrangeCoins_Optimal(0) + " should be [0]");
//        System.out.println(arrangeCoins_Optimal(1) + " should be [1]");
//        System.out.println(arrangeCoins_Optimal(5) + " should be [2]");
        System.out.println(arrangeCoins_Optimal(7) + " should be [3]");
        System.out.println(arrangeCoins_Optimal(8) + " should be [3]");
//        System.out.println(arrangeCoins_Optimal(2147483647) + " should be [65535]");
    }

    public static int arrangeCoins_Optimal(int n) {
        if (n <= 1) return n;
        int total = 1, num = 1;
        while (total < n && total > 0) {
            total += ++num;
        }
        System.out.println("total = " + total + " num = " + num);
        if (total < 0) num--;
        System.out.println("total = " + total + " num = " + num);
        int result = 0;

        while (n > 0 && num > 0) {
            n -= num--;
            result++;
            System.out.println("result = " + result + " n = " + n + " num = " + num);
        }
        return result;
    }

    public static int arrangeCoins(int n) {
        if (n <= 1) return n;
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{1, 0});
        for (int i = 2; i + stack.peek()[0] < n; i++) {
            stack.add(new int[]{i + stack.peek()[0], i});
        }
        int result = 0;
        while (!stack.isEmpty() && n - stack.peek()[1] >= 0) {
            n -= stack.pop()[1];
            result++;
        }
        return result;
    }
}

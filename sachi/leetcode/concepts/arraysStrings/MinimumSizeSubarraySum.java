import java.util.Scanner;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println(minSubArrayLen(s, input));
        System.out.println(minSubArrayLenOptimized(s, input));
        scanner.close();
    }

    // O(n*2) Solution
    private static int minSubArrayLen(int s, int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    res = (res == 0 || res > j - i + 1) ? j - i + 1 : res;
                }
            }
        }
        return res;
    }

    // O(n) Solution
    private static int minSubArrayLenOptimized(int s, int[] nums) {
        int left = 0, res = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
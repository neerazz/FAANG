import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        rotate(input, k);
        Arrays.stream(input).forEach(e -> System.out.print(e + " "));
        scanner.close();
    }

    private static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        int pointer = nums.length - k;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (pointer == nums.length) {
                pointer = 0;
            }
            res[i] = nums[pointer++];
        }
        System.arraycopy(res, 0, nums, 0, res.length);
    }
}
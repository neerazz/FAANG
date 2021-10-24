import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameII {
    public static void main(String[] args) {
        System.out.println("*************************************** Solution 1 ***********************************");
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}) + " should be [2]");
        System.out.println("*************************************** Solution 2 ***********************************");
        System.out.println(jump_rev1(new int[]{2, 3, 1, 1, 4}) + " should be [2]");
        System.out.println(jump_rev1(new int[]{1}) + " should be [0]");
        System.out.println(jump_rev1(new int[]{1, 2}) + " should be [1]");
        System.out.println(jump_rev1(new int[]{2, 1, 1, 1, 1}) + " should be [3]");
    }

    //    Time: O(n), space : O(1)
    public static int jump_rev_2(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int maxSteps = nums[0], maxPos = nums[0], jump = 1;
        for (int i = 0; i < n; i++) {
            if (maxSteps < i) {
//                 If you cant reach to current point.
//                 Then take a jump and reach till the max point that can be reached
                jump++;
                maxSteps = maxPos;
            }
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        return jump;
    }

    private static int jump_rev1(int[] nums) {
        int len = nums.length;
        Queue<int[]> queue = new LinkedList<>();
//        index 0: step and index1: how many times can we use the step
//        Since we are starting from start, we add 0 steps.
        queue.add(new int[]{0, 0});
        for (int i = 0; i < len; i++) {
            while (!queue.isEmpty() && queue.peek()[1] < i) {
                queue.poll();
            }
            int[] peek = queue.peek();
            queue.add(new int[]{peek[0] + 1, i + nums[i]});
            if (i == len - 1) return peek[0];
        }
        return -1;
    }

    public static int jump(int[] nums) {
        int[] distances = new int[nums.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int canJump = nums[i];
            for (int j = i + 1; j <= i + canJump && j < nums.length; j++) {
                if (distances[i] + j < distances[j]) {
                    distances[j] = distances[i] + 1;
                }
            }
        }
        return distances[nums.length - 1];
    }
}

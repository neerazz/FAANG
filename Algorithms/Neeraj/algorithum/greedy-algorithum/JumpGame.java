package algorithms.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Optional;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}) + " should be [true]");
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}) + " should be [false]");
    }

    public static boolean canJump(int[] nums) {
        if (nums.length < 1) return true;
        boolean[] possible = new boolean[nums.length];
        possible[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int jumps = nums[i];
            for (int j = 1; j <= jumps && i + j < nums.length; j++) {
                possible[i+j] = true;
            }
        }
        for (int i = 0; i < possible.length; i++) {
            if (!possible[i]){
                return false;
            }
        }
        return true;
    }
}

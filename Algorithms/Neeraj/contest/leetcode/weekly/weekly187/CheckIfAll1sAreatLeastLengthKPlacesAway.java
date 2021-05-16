package weekly.weekly187;
/*
    Created on:  May 02, 2020
 */

/**
 * Questions:
 */
public class CheckIfAll1sAreatLeastLengthKPlacesAway {
    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int preOne = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (preOne == -1 || i - preOne > k) {
                    preOne = i;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

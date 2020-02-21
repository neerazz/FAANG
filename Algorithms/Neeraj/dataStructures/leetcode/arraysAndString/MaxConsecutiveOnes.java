package ds.arraysAndString;

/*
https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1301/
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println("Answer is: " + findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}) + " should be 3.");
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = -1, counter = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current == 1) {
                counter++;
            } else {
                max = Math.max(counter, max);
                counter = 0;
            }
        }
        return Math.max(counter, max);
    }
}

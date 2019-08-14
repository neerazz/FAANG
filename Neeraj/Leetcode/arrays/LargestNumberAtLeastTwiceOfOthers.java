package arrays;

/*
https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/

 */
public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        System.out.println("Answer is: " + dominantIndex(new int[]{3, 6, 1, 0}) + " should be 1.");
        System.out.println("Answer is: " + dominantIndex(new int[]{1, 2, 3, 4}) + " should be -1.");
    }

    public static int dominantIndex(int[] nums) {
        int size = nums.length;
        int largestNumber = Integer.MIN_VALUE;
        int largestNumberIndex = -1;
        if (size == 0) return -1;

//        Get the largest number
        for (int i = 0; i < size; i++) {
            if (nums[i] > largestNumber) {
                largestNumber = nums[i];
                largestNumberIndex = i;
            }
        }

        for (int i = 0; i < size; i++) {
            if (nums[i] * 2 > largestNumber && i != largestNumberIndex) {
                return -1;
            }
        }
        return largestNumberIndex;
    }
}

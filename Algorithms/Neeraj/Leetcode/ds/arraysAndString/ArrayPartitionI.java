package ds.arraysAndString;

import java.util.Arrays;

/*
https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1154/
 */
public class ArrayPartitionI {
    public static void main(String[] args) {
        System.out.println("Answer is: " + arrayPairSum(new int[]{1, 4, 3, 2}) + " should be 4");
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        int size = nums.length;
        if (size == 0) return 0;
        int result = 0;
        while (index < size) {
            result += Math.min(nums[index], nums[index + 1]);
            index += 2;
        }
        return result;
    }
}

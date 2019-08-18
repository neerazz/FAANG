package arraysAndString;

import java.util.LinkedList;

/*
https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1173/
Example 1:
Given nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.

Example 2:
Given nums = [0,0,1,1,1,2,2,3,3,4],
Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println("Answer is: \t[" + removeDuplicates(new int[]{1, 1, 2}) + "] \nShould be: \t[2]");
        System.out.println("Answer is: \t[" + removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}) + "] \nShould be: \t[5]");
    }

    public static int removeDuplicates(int[] nums) {
        int size = nums.length, pointer = 1;
        if (size <= 1) return size;
        for (int i = 1; i < size; i++) {
            int current = nums[i];
            if (nums[pointer - 1] != current) {
                nums[pointer] = current;
                pointer++;
            }
        }
//        System.out.println(Arrays.toString(nums));
        return pointer;
    }

    public static int removeDuplicates2(int[] nums) {
        LinkedList<Integer> results = new LinkedList<>();
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (results.isEmpty() || results.peekLast() != current) {
                results.add(current);
                nums[pointer] = current;
                pointer++;
            }
        }
        return results.size();
    }
}

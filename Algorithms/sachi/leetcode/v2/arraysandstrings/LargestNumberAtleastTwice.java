package leetcode.v2.arraysandstrings;

/*
https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
P
You are given an integer array nums where the largest integer is unique.
Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.

Example 1:
Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.

Example 2:
Input: nums = [1,2,3,4]
Output: -1
Explanation: 4 is less than twice the value of 3, so we return -1.

Example 3:
Input: nums = [1]
Output: 0
Explanation: 1 is trivially at least twice the value as any other number because there are no other numbers.
 
*/
public class LargestNumberAtleastTwice {

    // Insight - Find largest & second largest - Check if second is twice or not
    public static int dominantIndex(int[] nums) {
        int largest = Integer.MIN_VALUE, second = Integer.MIN_VALUE, index = 0, i = 0;
        for (int num : nums) {
            if (num > largest) {
                second = largest;
                largest = num;
                index = i;
            } else if (num > second) {
                second = num;
            }
            i++;
        }
        if (largest >= second * 2) {
            return index;
        } else {
            return -1;
        }
    }

}

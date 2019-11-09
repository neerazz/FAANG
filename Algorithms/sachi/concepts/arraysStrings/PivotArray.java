/* Find a Pivot in a n array
We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the 
sum of the numbers to the right of the index.
If no such index exists, we should return -1. If there are multiple pivot indexes, 
you should return the left-most pivot index.

Input: 
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation: 
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.

*/

import java.util.Scanner;

//--Edge case

public class PivotArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println(pivotIndex(input));
        scanner.close();
    }

    private static int pivotIndex(int[] nums) {
        if (nums == null || nums.length <= 1) return -1;
        int sum = 0, temp = 0;
        for (int num : nums) sum += num;
        //Check for 1st Index
        if (sum - nums[0] == 0) return 0;
        for (int i = 0; i < nums.length - 1; i++) {
            temp += nums[i];
            if (sum - nums[i + 1] == temp * 2) {
                return i + 1;
            }
        }
        return -1;
    }


}






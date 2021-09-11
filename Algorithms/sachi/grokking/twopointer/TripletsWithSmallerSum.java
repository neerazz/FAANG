package grokking.twopointer;

import util.Util;

import java.util.Arrays;

/*
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target
where i, j, and k are three different indices. Write a function to return the count of such triplets.

Example 1:

Input: [-1, 0, 2, 3], target=3
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
Example 2:

Input: [-1, 4, 2, 1, 3], target=5
Output: 4
Explanation: There are four triplets whose sum is less than the target:
   [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]

*/

public class TripletsWithSmallerSum {

    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 2, 3};
        System.out.println(searchTripletsMine(input, 3));

        input = new int[]{-1, 4, 2, 1, 3};
        System.out.println(searchTripletsMine(input, 5));
        //test();
    }


    /**
     * Sort Arrays
     * count = count + (end - start);
     * So every value in between will be bigger
     * <p>
     * Time - O(n*2)
     * Space - O(n)
     */
    public static int searchTripletsMine(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int start = i + 1, end = arr.length - 1;
            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                if (sum < target) {
                    count += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }


    public static void test() {
        while (true) {
            int[] input = Util.generateRandomArray();
            int sum = Util.generateRandomNumber();

            int s1 = searchTripletsMine(input, sum);
            int s2 = searchTriplets(input, sum);

            if (s1 != s2) {
                Util.print(input, "Input");
                System.out.println(s1);
                System.out.println(s2);
                return;
            }
        }
    }

    //Educative solution
    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int first) {
        int count = 0;
        int left = first + 1, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) { // found the triplet
                // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                // left and right to get a sum less than the target sum
                count += right - left;
                left++;
            } else {
                right--; // we need a pair with a smaller sum
            }
        }
        return count;
    }

}

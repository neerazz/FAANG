/*
Given an array arr[] of N non-negative integers representing the height of blocks.
If width of each block is 1,compute how much rain water can be trapped in between.
Example:
INPUT: N=6
       arr[]={3,0,0,2,0,4}
OUTPUT: 10
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Driver code
class TrappingRain {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //size of array
        int n = Integer.parseInt(br.readLine().trim());
        int arr[] = new int[n];
        String inputLine[] = br.readLine().trim().split(" ");

        //adding elements to the array
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }

        Solution obj = new Solution();

        //calling trappingWater() function
        System.out.println(obj.trappingWater(arr, n));
    }

    static class Solution {

        static int trappingWater(int arr[], int n) {

            int[] lmax = new int[n];
            int[] rmax = new int[n];
            lmax[0] = arr[0];
            rmax[n - 1] = arr[n - 1];
            for (int i = 1; i < n; i++) {
                lmax[i] = Math.max(lmax[i - 1], arr[i]);
                rmax[n - i - 1] = Math.max(rmax[n - i], arr[n - 1 - i]);
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (Math.min(lmax[i], rmax[i]) > arr[i]) {
                    sum += Math.min(lmax[i], rmax[i]) - arr[i];
                }
            }
            return sum;
        }
    }
}



/*
Given an integer array of size  N . You have to find sum of bit differences in all pairs that can be formed from array elements.
Bit difference of a pair (x, y) is count of different bits at same positions in binary representations of x and y.
Example:
INPUT: N = 2, arr[] = {1, 2}
OUTPUT: 4
*/

import java.io.*;
import java.util.*;

class BitDifference
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0 ;i<n;i++)
            arr[i] = sc.nextInt();
                    
            Solution obj = new Solution();
            System.out.println(obj.sumBitDiff(arr,n));
        }
}

class Solution
{
    public static long sumBitDiff(int arr[], int n) 
    { 
        long ans = 0; 

        for (int i = 0; i < 32; i++)
        {
            int count = 0;
            for (int j = 0; j < n; j++)
                if ( (arr[j] & (1 << i)) != 0)
                    count++;
                    ans += (count * (n - count) * 2);
        }
        return ans; 
    } 
}

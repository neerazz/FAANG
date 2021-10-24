/*
Given an array of strings arr[] of size n and given s a string str and an integer k. 
The task is to find the count of strings in arr[] whose prefix of length k matches with the k length prefix of str.
Example:
INPUT:n = 6
arr[] = {“abba”, “abbb”, “abbc”, “abbd”, “abaa”, “abca”}
str = “abbg”
k = 3
OUTPUT: 4
*/

//Initial Template for Java

import java.util.Scanner;

class PrefixMatch {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        int k = Integer.parseInt(sc.next());
        String str = sc.next();
        Solution obj = new Solution();
        int ans = obj.klengthpref(arr, n, k, str);
        System.out.println(ans);
    }

    static class Solution {
        public int klengthpref(String[] arr, int n, int k, String str) {
            // code inthere
            int y = 0;
            str = str.substring(0, k);
            for (int i = 0; i < n; i++) {
                if (arr[i].startsWith(str)) {
                    y++;
                }
            }
            return y;
        }
    }
}

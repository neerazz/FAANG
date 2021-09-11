/*
Given two strings A and B, find the minimum number of times A has to be repeated such that B becomes a substring of the repeated A.
If B cannot be a substring of A no matter how many times it is repeated, return -1.
Example:
INPUT: A="abcd" B="cdabcdab"
OUTPUT: 3
*/


import java.io.IOException;
import java.util.Scanner;

class RepeatedStringMatch {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        Solution ob = new Solution();
        System.out.println(ob.repeatedStringMatch(A, B));
    }

    static class Solution {
        static int repeatedStringMatch(String A, String B) {
            // Your code goes here
            String o = A;
            int a = B.length() / A.length();
            int c = 1;

            for (int i = 0; i < a + 2; i++) {
                if (A.contains(B)) {
                    return c;
                } else {
                    A += o;
                    c++;
                }
            }
            return -1;
        }
    }
} 
        

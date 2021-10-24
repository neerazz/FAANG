/*
Given a keypad as in old phones, and an N digit number which is represented by array a[ ],
the task is to list all words which are possible by pressing these numbers.
Example:
INPUT: N = 3, a[] = {2, 3, 4}
OUTPUT: adg adh adi aeg aeh aei afg afh afi 
bdg bdh bdi beg beh bei bfg bfh bfi 
cdg cdh cdi ceg ceh cei cfg cfh cfi 
*/

import java.util.ArrayList;
import java.util.Scanner;

class PossibleWordsPhone {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        ArrayList<String> res = new Solution().possibleWords(arr, n);
        for (String i : res) System.out.print(i + " ");
        System.out.println();
    }

    static class Solution {

        static ArrayList<String> possibleWords(int a[], int N) {
            String code[] = {"\0", "\0", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            String s = "";
            for (int i = 0; i < a.length; i++) {
                s = s + (char) a[i];
            }
            return helper(s, code);
        }

        static ArrayList<String> helper(String s, String[] code) {
            if (s.length() == 0) {
                ArrayList<String> res = new ArrayList<String>();
                res.add("");
                return res;
            }
            char ch = s.charAt(0);
            ArrayList<String> res1 = helper(s.substring(1), code);
            ArrayList<String> res3 = new ArrayList<String>();
            String str1 = code[ch];
            for (int i = 0; i < str1.length(); i++) {
                char ch1 = str1.charAt(i);
                for (String res2 : res1) {
                    res3.add(ch1 + res2);
                }
            }
            return res3;
        }
    }
}

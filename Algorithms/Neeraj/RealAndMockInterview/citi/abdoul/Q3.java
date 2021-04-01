package abdoul;

import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 31, 2021
 * Questions:
 */

public class Q3 {

    public static void main(String[] args) {
        System.out.println(solution("babaa") + " = 2");
        System.out.println(solution("ababa") + " = 4");
        System.out.println(solution("aba") + " = 0");
        System.out.println(solution("bbbbb") + " = 6");
    }

    private static int solution(String S) {
        int aCount = 0, len = S.length();
        for (char c : S.toCharArray()) {
            aCount += c == 'a' ? 1 : 0;
        }
// Check if a’s can be divided into three parts
        if (aCount % 3 != 0) return 0;
        Integer[][] dp = new Integer[len][3];
        return helper(S, 0, aCount / 3, dp, 0);
    }

    private static int helper(String str, int start, int countPerPart, Integer[][] dp, int k) {
        if (start == str.length()) {
            return k == 3 ? 1 : 0;
        }
        if (k >= 3) return 0;
        if (dp[start][k] != null) return dp[start][k];
        dp[start][k] = 0;
        int aCount = 0;
        for (int end = start; end < str.length(); end++) {
            aCount += str.charAt(end) == 'a' ? 1 : 0;
            if (aCount == countPerPart) {
                dp[start][k] += helper(str, end + 1, countPerPart, dp, k + 1);
            } else if (aCount > countPerPart) break;
        }
        return dp[start][k];
    }
}

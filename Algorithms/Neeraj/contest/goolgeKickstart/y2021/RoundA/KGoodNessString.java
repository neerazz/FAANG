package y2021.RoundA;

import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 21, 2021
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/0000000000436140/000000000068cca3
 */

public class KGoodNessString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        int[] result = new int[tests];
        for (int i = 0; i < tests; i++) {
            int n = sc.nextInt(), k = sc.nextInt();
            String str = sc.next();
            result[i] = getMinOperations(n, k, str);
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getMinOperations(int n, int k, String str) {
        int score = 0;
        for (int i = 0; i < (n + 1) / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) score++;
        }
        if (score == k) return 0;
        else if (score > k) return score - k;
        return k - score;
    }
}

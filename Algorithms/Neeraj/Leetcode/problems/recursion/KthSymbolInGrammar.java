package problems.recursion;

/*
On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).

Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001

Solution: https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1793/
 */
public class KthSymbolInGrammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(1, 1) + " should be 0");
        System.out.println(kthGrammar(2, 1) + " should be 0");
        System.out.println(kthGrammar(2, 2) + " should be 1");
        System.out.println(kthGrammar(4, 5) + " should be 1");
        System.out.println(kthGrammar(3, 2) + " should be 1");
        System.out.println(kthGrammar(3, 4) + " should be 0");
        System.out.println(kthGrammar(30, 434991989) + " should be 0");
    }

    public static int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        if (K <= 1 << N - 2) return kthGrammar(N - 1, K);
        return kthGrammar(N - 1, K - (1 << N - 2)) ^ 1;
    }

    public static int kthGrammar_optimal1(int n, int k) {
        long count = powerN(n, k - 1);
        int flips = 0;

        while (count > 2) {
            if (k > count / 2) {
                k = (int) (k - count / 2);
                flips++;
            }
            count = count / 2;
        }
        k--;
        if (flips % 2 == 1) k = 1 - k;
        System.out.println("k = " + k);
        return k == 1 ? 0 : 1;
    }

    public static long powerN(long a, long b) {
        long re = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                re *= a;
            }
            b >>= 1;
            a *= a;
        }
        return re;
    }

    public static int kthGrammar_naive(int N, int K) {
        String rowDataString = null;
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                rowDataString = "0";
            } else {
                char[] chars = rowDataString.toCharArray();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] == '0') {
                        sb.append("01");
                    } else {
                        sb.append("10");
                    }
                    if (K == j) break;
                }
                rowDataString = sb.toString();
            }
        }
        return Integer.parseInt(String.valueOf(rowDataString.charAt(K - 1)));
    }
}

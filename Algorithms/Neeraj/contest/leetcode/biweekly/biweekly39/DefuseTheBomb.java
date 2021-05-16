package biweekly.biweekly39;

/**
 * Created on:  Nov 14, 2020
 * Questions: https://leetcode.com/contest/biweekly-contest-39/problems/defuse-the-bomb/
 */

public class DefuseTheBomb {

    public static void main(String[] args) {

    }

    public static int[] decrypt(int[] code, int k) {
        int len = code.length, result[] = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = getVal(code, i, len, k);
        }
        return result;
    }

    private static int getVal(int[] code, int idx, int len, int k) {
        if (k == 0) return 0;
        int val = 0;
        if (k < 0) {
            k *= -1;
            idx--;
            while (k > 0) {
                if (idx < 0) idx = len - 1;
                val += code[idx--];
                k--;
            }
        } else {
            idx++;
            while (k > 0) {
                if (idx >= len) idx = 0;
                val += code[idx++];
                k--;
            }
        }
        return val;
    }
}

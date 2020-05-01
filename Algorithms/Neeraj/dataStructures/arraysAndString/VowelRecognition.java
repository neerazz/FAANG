/*
    Created on:  Apr 22, 2020
 */

import java.io.*;
import java.math.BigInteger;

/**
 * Questions: https://www.hackerearth.com/practice/basic-programming/complexity-analysis/time-and-space-complexity/practice-problems/algorithm/vowel-game-f1a1047c/
 */
public class VowelRecognition {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println(getVowelCount(br.readLine()).toString());
        }
    }

    private static BigInteger getVowelCount(String input) {
        BigInteger count = BigInteger.ZERO;
        int len = input.length();
        for (int i = 0; i < input.length(); i++) {
            if (isVowel(input.charAt(i))) {
                count = count.add(BigInteger.valueOf((len - i) * (i + 1)));
            }
        }
        return count;
    }

    private static Long getVowelCount_Long(String str) {
        long count = 0;
        long l = str.length();
        for (int i = 0; i < l; i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count = count + ((l - i) * (i + 1));
            }
        }
        return count;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
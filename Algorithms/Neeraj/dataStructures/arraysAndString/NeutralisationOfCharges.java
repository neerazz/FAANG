/*
    Created on:  May 07, 2020
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * Questions: https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/charges-repel/
 */
public class NeutralisationOfCharges {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int len = fr.nextInt();
        String result = neutralize(new StringBuilder(fr.readLine()));
        System.out.println(result.length());
        if (result.length() > 0) {
            System.out.println(result);
        } else {
            System.out.println("");
        }
    }

    private static String neutralize(StringBuilder sb) {
        if (sb.length() == 0) return "";
        int startLen = sb.length();
        int p1 = 0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sb.charAt(0));
        for (int i = 1; i < sb.length(); i++) {
            if (p1 >= 0 && sb.charAt(i) == sb2.charAt(p1)) {
                sb2.deleteCharAt(p1--);
            } else {
                p1++;
                sb2.append(sb.charAt(i));
            }
        }
        return startLen == sb2.length() ? sb.toString() : neutralize(sb2);
    }
}

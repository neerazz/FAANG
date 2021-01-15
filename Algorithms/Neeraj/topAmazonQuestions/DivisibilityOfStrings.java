import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 13, 2021
 * Questions: https://leetcode.com/discuss/general-discussion/680341/Divisibility-of-Strings
 */

public class DivisibilityOfStrings {

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("bcdbcdbcd", "bcdbcd"));
        System.out.println(gcdOfStrings("bcdbcdbcdbcd", "bcdbcd"));
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("bcdbcdbcd", "bcdbcd"));
        System.out.println(gcdOfStrings("bcdbcdbcdbcd", "bcdbcd"));
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo",
                "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"));
        System.out.println(gcdOfStrings("wqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazd",
                "wqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazd"));

        System.out.println(findSmallestDivisor("bcdbcdbcd", "bcdbcd"));
        System.out.println(findSmallestDivisor("bcdbcdbcdbcd", "bcdbcd"));
        System.out.println(findSmallestDivisor("ABCABC", "ABC"));
        System.out.println(findSmallestDivisor("ABABAB", "ABAB"));
        System.out.println(findSmallestDivisor("bcdbcdbcd", "bcdbcd"));
        System.out.println(findSmallestDivisor("bcdbcdbcdbcd", "bcdbcd"));
        System.out.println(findSmallestDivisor("ABCABC", "ABC"));
        System.out.println(findSmallestDivisor("ABABAB", "ABAB"));
        System.out.println(findSmallestDivisor("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo",
                "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"));
        System.out.println(findSmallestDivisor("wqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazd",
                "wqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazd"));
    }

    public static String gcdOfStrings(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        int i1 = 0, i2 = 0;
        int end = gcd(l1, l2), start = 1;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c1 = s.charAt(i1++), c2 = t.charAt(i2++);
            if (c1 != c2) return "";
            sb.append(c1);
            start++;
        }
        String gcdString = sb.toString();
        return isDivisible(s, gcdString) && isDivisible(t, gcdString) ? gcdString : "";
    }

    private static int findSmallestDivisor(String s, String t) {
//        Check if s can be formed by repeating t. O(N), n -> length of string.
        if (isDivisible(s, t)) {
            int l1 = s.length(), l2 = t.length();
//            Find the GCD of both l1, l2.
            int end = gcd(l1, l2), start = 1;
            while (start <= end) {
//                Starting from 1 till the GCD keep checking if the s(0,start) can be used to form t.
//                Here I am checking t because, in most of teh cases t will be smaller.
                if (l1 % start != 0 || l2 % start != 0) continue;
                if (isDivisible(t, t.substring(0, start))) return start;
                start++;
            }
        }
        return -1;
    }

    private static int gcd(int a, int b) {
//        a should be greater then b.
        if (a < b) return gcd(b, a);
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static boolean isDivisible(String s, String t) {
        StringBuilder sb = new StringBuilder(t);
        while (sb.length() <= s.length()) {
            if (sb.toString().equals(s)) return true;
            sb.append(t);
        }
        return false;
    }
}

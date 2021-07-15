package ctci.arrays;

import util.Util;

import java.util.HashSet;
import java.util.Set;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */

/**
 * Brute Force = n*n
 * Merge Sort = nlog(n)
 * Array Based = n, Space = n (or May be Fixed)
 */
public class IsUnique {

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            String word = Util.generateRandomString(15);
            //System.out.println(word);
            boolean sol1 = isUniqueNaive(word);
            boolean sol2 = isUniqueASCII(word);

            if (sol1 != sol2) {
                System.out.println(word);
                System.out.println(isUniqueNaive(word));
                System.out.println(isUniqueASCII(word));
                return;
            }
        }
    }

    public static boolean isUniqueNaive(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) return false;
            else set.add(c);
        }
        return true;
    }


    public static boolean isUniqueASCII(String s) {
        boolean[] arr = new boolean[256];
        for (char c : s.toCharArray()) {
            if (arr[c]) return false;
            else arr[c] = true;
        }
        return true;
    }


}

package weekly.weekly211;

import java.util.*;

/**
 * Created on:  Oct 17, 2020
 * Questions:
 */

public class LexicographicallySmallestStringAfterApplyingOperations {

    public static void main(String[] args) {
//        System.out.println(findLexSmallestString("5525", 9, 2));
        System.out.println(findLexSmallestString("74", 5, 1));
    }

    public static String findLexSmallestString(String s, int a, int b) {
        TreeSet<String> set = new TreeSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        b %= s.length();
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            String add = add(poll, a), rotate = rotate(poll, b);
            System.out.println("poll = " + poll + " add = " + add + " rotate = " + rotate);
            if (set.add(add)) {
                queue.add(add);
            }
            if (set.add(rotate)) {
                queue.add(rotate);
            }
        }
        return set.first();
    }

    private static String rotate(String str, int b) {
        return str.substring(str.length() - b) + str.substring(0, str.length() - b);
    }

    private static String add(String str, int a) {
        char[] chars = str.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            int cur = chars[i] - '0';
            cur = (cur + a) % 10;
            chars[i] = (char) ('0' + cur);
        }
        return String.valueOf(chars);
    }
}

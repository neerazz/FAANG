package weekly.weekly201;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created on:  Aug 08, 2020
 * Questions: https://leetcode.com/problems/make-the-string-great/
 */
public class MakeTheStringGreat {
    public static void main(String[] args) {
        System.out.println("********************************* Solution 1 ******************************");
        System.out.println(makeGood("leEeetcode") + " = leetcode");
        System.out.println(makeGood("abBAcC") + " = ''");
        System.out.println(makeGood("s") + " = s");
        System.out.println(makeGood("jeSsEJ") + " = ''");
        System.out.println(makeGood("djrDdRJD") + " = ''");
        System.out.println(makeGood("kkdsFuqUfSDKK") + " = kkdsFuqUfSDKK");
        System.out.println("********************************* Solution 2 ******************************");
        System.out.println(makeGood_optimal("leEeetcode") + " = leetcode");
        System.out.println(makeGood_optimal("abBAcC") + " = ''");
        System.out.println(makeGood_optimal("s") + " = s");
        System.out.println(makeGood_optimal("jeSsEJ") + " = ''");
        System.out.println(makeGood_optimal("djrDdRJD") + " = ''");
        System.out.println(makeGood_optimal("kkdsFuqUfSDKK") + " = kkdsFuqUfSDKK");
    }

    public static String makeGood_optimal(String s) {
        Stack<Character> stack = new Stack<>();
        for (char cur : s.toCharArray()) {
            if (!stack.isEmpty() && isBad(stack.peek(), cur)) {
                stack.pop();
            } else {
                stack.add(cur);
            }
        }
        return stack.stream().map(c -> "" + c).collect(Collectors.joining());
    }

    public static String makeGood(String s) {
        String change = s;
        while (!(change = makeStringGood(s)).equals(s)) {
            s = change;
        }
        return s;
    }

    private static boolean isBad(char a, char b) {
        return (Character.isLowerCase(a) && Character.toUpperCase(a) == b) || (Character.isLowerCase(b) && a == Character.toUpperCase(b));
    }

    private static String makeStringGood(String str) {
        StringBuilder sb = new StringBuilder();
        char pre = ' ';
        for (char cur : str.toCharArray()) {
            if (pre != ' ') {
                if (isBad(pre, cur)) {
                    pre = ' ';
                } else {
                    sb.append(pre);
                    pre = cur;
                }
            } else {
                pre = cur;
            }
        }
        if (pre != ' ') sb.append(pre);
        return sb.toString();
    }
}

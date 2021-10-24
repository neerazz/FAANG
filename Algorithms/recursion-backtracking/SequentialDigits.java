import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created on:  Sep 19, 2020
 * Questions: https://leetcode.com/problems/sequential-digits/
 */
public class SequentialDigits {
    static TreeSet<Integer> op;

    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 300));
        System.out.println(sequentialDigits(1000, 13000));
    }

    public static List<Integer> sequentialDigits_optimal(int low, int high) {
        int[] allNums = {
                12, 23, 34, 45, 56, 67, 78, 89,
                123, 234, 345, 456, 567, 678, 789,
                1234, 2345, 3456, 4567, 5678, 6789,
                12345, 23456, 34567, 45678, 56789,
                123456, 234567, 345678, 456789,
                1234567, 2345678, 3456789,
                12345678, 23456789,
                123456789};
        List<Integer> res = new ArrayList<>();
        for (int allNum : allNums) {
            if (allNum < low) continue;
            if (allNum > high) break;
            res.add(allNum);
        }
        return res;
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        op = new TreeSet<>();
        String start = String.valueOf(low);
        int div = (int) Math.pow(10, start.length() - 1);
        int cur = start.charAt(0) - '0', right = low % div, temp = (cur * div) + right;
        while (temp <= high) {
            temp = (cur++ * div) + right;
            char[] chars = String.valueOf(temp).toCharArray();
            getPermutation(chars[0], 1, chars.length, chars, high);
        }
        return new ArrayList<>(op);
    }

    private static void getPermutation(char pre, int idx, int len, char[] chars, int high) {
        int num = Integer.parseInt(String.valueOf(chars));
        if (num > high) return;
        if (idx >= chars.length) {
            op.add(Integer.parseInt(String.valueOf(chars)));
        } else if (chars[idx] <= pre) {
            chars[idx] = (char) (pre + 1);
            if (chars[idx] > '9') return;
            getPermutation(chars[idx], idx + 1, len, chars, high);
        }
    }
}

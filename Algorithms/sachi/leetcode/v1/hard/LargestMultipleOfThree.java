package leetcode.v1.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestMultipleOfThree {

    public static void main(String[] args) {
        System.out.println(largestMultipleOfThree(new int[]{8, 6, 7, 1, 0}));
    }

    public static String largestMultipleOfThree(int[] digits) {

        int sum = 0;
        List<Integer> list = new ArrayList<>(digits.length);
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sum += digit;
            list.add(digit);
        }
        list.sort(Collections.reverseOrder());

        for (Integer i : list) {
            sb.append(i);
        }

        if (sum % 3 == 0) return sb.toString();

        for (int i = list.size() - 1; i >= 0; i--) {
            sum = sum - list.get(i);
            if (sum % 3 == 0) {
                return sb.deleteCharAt(i).toString();
            } else {
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }
}

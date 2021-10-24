import java.util.Arrays;
import java.util.Stack;

/**
 * Created on:  Aug 15, 2020
 * Questions: https://leetcode.com/problems/find-permutation/
 */
public class FindPermutation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPermutation("DDIIDI")));
    }

    public static int[] findPermutation(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] op = new int[s.length() + 1];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == 'D') {
//                When the number is supposed to be decreasing, then just store that number to stack.
                stack.add(i + 1);
            } else {
//                When the number is supposed to be increasing. Then just add the number in the op array.
                op[idx++] = i + 1;
//                If there are any previously stored elements, then you cna take those out.
                while (!stack.isEmpty()) op[idx++] = stack.pop();
            }
        }
        stack.add(s.length() + 1);
        while (!stack.isEmpty()) op[idx++] = stack.pop();
        return op;
    }
}

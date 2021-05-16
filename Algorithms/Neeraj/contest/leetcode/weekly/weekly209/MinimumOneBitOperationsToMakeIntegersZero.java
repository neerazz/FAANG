package weekly.weekly209;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created on:  Oct 03, 2020
 * Questions: https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero
 */
public class MinimumOneBitOperationsToMakeIntegersZero {
    public static void main(String[] args) {
        System.out.println(minimumOneBitOperations(3));
        System.out.println(minimumOneBitOperations(6));
        System.out.println(minimumOneBitOperations(333));
        System.out.println(minimumOneBitOperations(236145));
        System.out.println(minimumOneBitOperations(212859));
        System.out.println(minimumOneBitOperations(284848));
        System.out.println(minimumOneBitOperations(277753));
    }

    public static int minimumOneBitOperations(int n) {
        if (n == 0) return 0;
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(Integer.toBinaryString(n));
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (allZeros(poll)) return level;
                String op1 = getOpt1(poll), op2 = getOpt2Val(poll);
                if (visited.add(op1)) queue.add(op1);
                if (visited.add(op2)) queue.add(op2);
            }
            level++;
        }
        return n;
    }

    private static String getOpt1(String str) {
        return str.substring(0, str.length() - 1) + (str.charAt(str.length() - 1) == '0' ? "1" : "0");
    }

    private static String getOpt2Val(String str) {
        int idx = str.lastIndexOf('1');
        if (idx == 0) return str;
        return str.substring(0, idx - 1) + (str.charAt(idx - 1) == '0' ? "1" : "0") + str.substring(idx);
    }

    private static boolean allZeros(String str) {
        return Integer.parseInt(str, 2) == 0;
    }
}

package weekly.weekly188;
/*
    Created on:  May 09, 2020
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Questions: https://leetcode.com/contest/weekly-contest-188/problems/build-an-array-with-stack-operations/
 */
public class BuildAnArrayWithStackOperations {
    public static void main(String[] args) {
        System.out.println(buildArray(new int[]{1, 3}, 3) + "\n[Push,Push,Pop,Push] \n");
        System.out.println(buildArray(new int[]{1, 2, 3}, 3) + "\n[Push,Push,Push] \n");
        System.out.println(buildArray(new int[]{1, 2}, 4) + "\n[Push,Push] \n");
        System.out.println(buildArray(new int[]{2, 3, 4}, 4) + "\n[Push,Pop,Push,Push,Push] \n");
    }

    public static List<String> buildArray(int[] target, int n) {
        int p1 = 0;
        List<String> op = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            op.add("Push");
            if (target[p1] != i) {
                op.add("Pop");
            }else{
                p1++;
            }
            if (p1 == target.length) break;
        }
        return op;
    }
}

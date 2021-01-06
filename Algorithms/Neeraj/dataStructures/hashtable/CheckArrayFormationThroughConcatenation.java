import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 01, 2021
 * Questions: https://leetcode.com/problems/check-array-formation-through-concatenation/
 */

public class CheckArrayFormationThroughConcatenation {

    public static void main(String[] args) {

    }
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int p1 = 0, len = arr.length;
        while (p1 < len) {
            boolean found = false;
            for (int[] p : pieces) {
                if (p1 >= len || arr[p1] != p[0]) continue;
                for (int num : p) {
                    if (arr[p1++] != num) return false;
                    found = true;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}

package weekly.weekly213;

/**
 * Created on:  Oct 31, 2020
 * Questions:
 */

public class CheckArrayFormationThroughConcatenation {

    public static void main(String[] args) {
        System.out.println(canFormArray(new int[]{85}, new int[][]{{85}}));
        System.out.println(canFormArray(new int[]{15, 88}, new int[][]{{88}, {15}}));
        System.out.println(canFormArray(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
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

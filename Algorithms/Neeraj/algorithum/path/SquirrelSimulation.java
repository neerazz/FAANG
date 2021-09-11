/**
 * Created on:  Feb 01, 2021
 * Questions: https://leetcode.com/problems/squirrel-simulation/
 */

public class SquirrelSimulation {

    public static void main(String[] args) {

    }

    public static int minDistance(int height, int width, int[] tree, int[] cur, int[][] nuts) {
        int total = 0, min = Integer.MAX_VALUE;
        for (int[] nut : nuts) {
            int d1 = getDistance(cur, nut);
            int d2 = getDistance(nut, tree);
            min = Math.min(min, d1 - d2);
            total += d2 * 2;
        }
        return total + min;
    }

    private static int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}

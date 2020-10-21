import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 19, 2020
 * Questions: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */

public class MinimumDominoRotationsForEqualRow {

    public static void main(String[] args) {

    }

    public static int minDominoRotations(int[] A, int[] B) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            int arote = getRotation(A, B, i), brote = getRotation(B, A, i);
            if (arote != -1 && brote != -1) {
                min = Math.min(min, Math.min(arote, brote));
            } else if (arote != -1) {
                min = Math.min(min, arote);
            } else if (brote != -1) {
                min = Math.min(min, arote);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static int getRotation(int[] A, int[] B, int val) {
        int len = A.length, rotate = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] == val) continue;
            if (B[i] == val) rotate++;
            else return -1;
        }
        return rotate;
    }
}

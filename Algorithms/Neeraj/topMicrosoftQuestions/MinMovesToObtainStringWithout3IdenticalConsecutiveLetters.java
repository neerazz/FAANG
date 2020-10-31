import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 30, 2020
 * Questions: https://leetcode.com/discuss/interview-question/398026/
 */

public class MinMovesToObtainStringWithout3IdenticalConsecutiveLetters {

    public static void main(String[] args) {
        System.out.println(getMinMoves("baaaaa") + " should be 1");
        System.out.println(getMinMoves("baaabbaabbba") + " should be 2");
        System.out.println(getMinMoves("aaaaaa") + " should be 2");
        System.out.println(getMinMoves("bbbbbbb") + " should be 2");
        System.out.println(getMinMoves("bbbbbbaa") + " should be 2");
    }

    private static int getMinMoves(String str) {
        if (str == null) return 0;
        int len = str.length(), p1 = 0, p2 = 0, swaps = 0;
        if (len < 3) return 0;
        while (p2 < len) {
            while (p2 < len && str.charAt(p1) == str.charAt(p2)) {
                p2++;
            }
            swaps += getSwapCount(p1, p2);
            p1 = p2;
        }
        swaps += getSwapCount(p1, p2);
        return swaps;
    }

    private static int getSwapCount(int p1, int p2) {
        return (p2 - p1) / 3;
    }
}

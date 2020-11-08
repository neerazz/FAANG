import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 05, 2020
 * Questions: https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 */

public class MinimumCostToMoveChipsToTheSamePosition {

    public static void main(String[] args) {

    }

    public static int minCostToMoveChips(int[] position) {
        int[] count = {0, 0};
        for (int pos : position) {
            count[pos % 2]++;
        }
        return Math.min(count[0], count[1]);
    }
}

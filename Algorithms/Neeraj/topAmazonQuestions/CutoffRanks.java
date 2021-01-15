import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 14, 2021
 * Questions:
 */

public class CutoffRanks {

    public static void main(String[] args) {
        System.out.println(cutOffRank(3, 4, new int[]{100, 50, 50, 25}));
        System.out.println(cutOffRank(4, 5, new int[]{2, 2, 3, 4, 5}));
    }

    public static int cutOffRank_rev2(int cutOffRank, int num, int[] scores) {
        Arrays.sort(scores);
        int total = 0, preScore = 0;
        for (int i = scores.length - 1; i >= 0; i--) {
            int curScore = scores[i];
            if (preScore == curScore) {
                total++;
            } else {
                if (total >= cutOffRank) break;
                total++;
                preScore = curScore;
            }
        }
        return total;
    }

    public static int cutOffRank(int cutOffRank, int num, int[] scores) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int score : scores) {
            map.put(score, map.getOrDefault(score, 0) + 1);
            if (map.size() > cutOffRank) map.pollFirstEntry();
        }
        int total = 0, preScore = Integer.MIN_VALUE, rank = 1;
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> entry = map.pollLastEntry();
            int curScore = entry.getKey(), count = entry.getValue();
            if (curScore == preScore) {
                total += count;
                rank += count;
            } else {
                if (rank > cutOffRank) break;
                total += count;
                rank += count;
                preScore = curScore;
            }
        }
        return total;
    }
}

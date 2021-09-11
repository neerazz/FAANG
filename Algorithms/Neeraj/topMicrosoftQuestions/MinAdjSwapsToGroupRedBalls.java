import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/discuss/interview-question/414660/
 */

public class MinAdjSwapsToGroupRedBalls {

    public static void main(String[] args) {
        System.out.println(minDistance("WRRWWR"));
        System.out.println(minDistance("WWRWWWRWR"));
        System.out.println(minDistance("WWW"));
        System.out.println(minDistance("RW"));
        System.out.println(minDistance("RW".repeat(100000)));
    }

    private static int minDistance(String s) {
        List<Integer> indexes = getRedIndexes(s);
        if (indexes.size() < 2) return 0;
        int swaps = 0, mid = indexes.size() / 2;
        for (int i = 0; i < indexes.size(); i++) {
            int actualDistance = Math.abs(indexes.get(mid) - indexes.get(i));
            int expectedDistance = Math.abs(mid - i);
            swaps += actualDistance - expectedDistance;
            if (swaps > 1_000_000_000) return -1;
        }
        return swaps;
    }

    private static List<Integer> getRedIndexes(String s) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                result.add(i);
            }
        }
        return result;
    }
}

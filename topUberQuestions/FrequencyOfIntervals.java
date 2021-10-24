import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on:  Nov 14, 2020
 * Questions: https://leetcode.com/discuss/interview-question/934777/Uber-Onsite
 */

public class FrequencyOfIntervals {

    public static void main(String[] args) {
        System.out.println(getFrequency(new int[][]{{0, 3}, {1, 4}, {2, 7}}));
    }

    private static List<String> getFrequency(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
//        Loop through all the input list and add a marker at start and after the end of each range.
        int max = 0;
        for (int[] range : nums) {
            map.put(range[0], 1);
            map.put(range[1] + 1, -1);
            max = Math.max(max, range[1]);
        }
//        Create an array of max length to draw the frequency graph
        int[] freq = new int[max + 1];
        int cur = 0;
        for (int i = 0; i <= max; i++) {
            cur += map.getOrDefault(i, 0);
            freq[i] = cur;
        }
        List<String> ranges = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p2 <= max) {
            if (freq[p1] == freq[p2]) {
                p2++;
            } else {
//                There is a frequency change collect the p1 to p2-1 range in output.
//                    Also assuming that the ranges with 0 frequency needs to be ignored.
                if (freq[p1] != 0) {
                    String range = String.format("[%d,%d] -> %d", p1, p2 - 1, freq[p1]);
                    ranges.add(range);
                }
                p1 = p2++;
            }
        }
//        Post processing the last range.
        if (freq[p1] != 0) {
            String range = String.format("[%d,%d] -> %d", p1, p2 - 1, freq[p1]);
            ranges.add(range);
        }
        return ranges;
    }

}

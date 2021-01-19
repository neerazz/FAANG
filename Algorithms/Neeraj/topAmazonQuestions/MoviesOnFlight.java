import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-questions#m
 */

public class MoviesOnFlight {

    public static void main(String[] args) {
        System.out.println(findPair(new int[]{90, 85, 75, 60, 120, 150, 125}, 250) + " = [90,125]");
    }

    private static List<Integer> findPair(int[] durations, int d) {
        int[] max = {0, 0, 0};
//        0:duration, 1: v1, 2: v2
        Arrays.sort(durations);
        int start = 0, end = durations.length - 1, target = d - 30;
        while (start < end) {
            int sum = durations[start] + durations[end];
            if (sum == target) {
                max[0] = target;
                max[1] = durations[start];
                max[2] = durations[end];
            } else if (sum < target) {
                if (max[0] < sum) {
                    max[0] = target;
                    max[1] = durations[start];
                    max[2] = durations[end];
                }
                start++;
            } else {
                end--;
            }
        }
        return Arrays.asList(max[1], max[2]);
    }
}

package weekly.weekly232;

import java.util.*;

/**
 * Created on:  Mar 13, 2021
 * Questions:
 */

public class MaximumAveragePassRatio {

    public static void main(String[] args) {
        System.out.println(maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}}, 2));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        int total = classes.length;
        PriorityQueue<Class> pq = new PriorityQueue<>((c1, c2) -> Double.compare(c2.avgChange, c1.avgChange));
        double sum = 0;
        for (int[] cls : classes) {
            Class cur = new Class(cls[0], cls[1]);
            sum += cur.avg;
            pq.add(cur);
        }
        while (extraStudents > 0) {
            Class poll = pq.poll();
            sum += poll.avgChange;
            if (poll.avgChange > 0) pq.add(new Class(poll.pass + 1, poll.total + 1));
            extraStudents--;
        }
        return sum / total;
    }

    static class Class {
        int pass;
        int total;
        double avg, addAvg, avgChange;

        public Class(int pass, int total) {
            this.pass = pass;
            this.total = total;
            avg = (1.0 * pass) / total;
            addAvg = 1.0 * (pass + 1) / (total + 1);
            avgChange = addAvg - avg;
        }
    }
}

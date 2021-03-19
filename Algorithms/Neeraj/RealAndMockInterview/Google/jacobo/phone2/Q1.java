package jacobo.phone2;

/**
 * Created on:  Mar 16, 2021
 * Questions:<p>
 * We have a machine that we want to run different programs on according to a schedule (start time and execution duration).
 * We want to check if a new program can be added to the schedule on the same machine.
 * <p>
 * INITIAL PROBLEM:
 * Only 1 program can be running at any given time. <br>
 * Already Scheduled: P1(10, 5), P2(25, 15)
 * <p>
 * 10-15  25-40
 * <p>
 * if they intersect
 * max(s1,s2)<min(e1,e2)
 * <p>
 * OP1:
 * Input
 * Already Scheduled: P1(10, 5), P2(25, 15)
 * Query: <br>
 * 18, 7    => 18-25    Possible<br>
 * 12, 10   => 12-22    Not-Possible<br>
 * 8,10     => 8-18     Not-Possible<br>
 * <p>
 * Explanation:
 * 10-15  25-40
 */

public class Q1 {

    public static void main(String[] args) {
        System.out.println("*************************** Solution 1 ************************");
        System.out.println(canScheduleNewJob(new int[][]{{10, 5}, {25, 15}}, new int[]{18, 7}) + " = true");
        System.out.println(canScheduleNewJob(new int[][]{{10, 5}, {25, 15}}, new int[]{12, 10}) + " = false");
        System.out.println(canScheduleNewJob(new int[][]{{10, 5}, {25, 15}}, new int[]{8, 10}) + " = false");
        System.out.println("*************************** Solution 2 ************************");
        System.out.println(canScheduleNewJob_rev2(new int[][]{{10, 5}, {25, 15}}, new int[]{18, 7}) + " = true");
        System.out.println(canScheduleNewJob_rev2(new int[][]{{10, 5}, {25, 15}}, new int[]{12, 10}) + " = false");
        System.out.println(canScheduleNewJob_rev2(new int[][]{{10, 5}, {25, 15}}, new int[]{8, 10}) + " = false");
    }

    //    Liner Search. Time: O(N)
    private static boolean canScheduleNewJob(int[][] scheduled, int[] newJob) {
        for (int[] job : scheduled) {
            if (hasOverLap(job, newJob)) return false;
        }
        return true;
    }

    //    Binary Search. Time: O(LogN)
    private static boolean canScheduleNewJob_rev2(int[][] scheduled, int[] newJob) {
//        Assuming that the input is sorted.
//        Arrays.sort(scheduled, (j1, j2) -> j1[0] - j2[0]);
        int start = 0, end = scheduled.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int[] midJob = scheduled[mid];
            if (newJob[0] + newJob[1] < midJob[0]) {
//                Then you have come too far on the right from the possible overlapping node.
                end = mid;
            } else if (newJob[0] > midJob[0] + midJob[1]) {
//                You have come too far on the left of teh possible overlap.
                start = mid + 1;
            } else if (hasOverLap(midJob, newJob)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasOverLap(int[] j1, int[] j2) {
        return Math.max(j1[0], j2[0]) < Math.min(j1[0] + j1[1], j2[0] + j2[1]);
    }
}

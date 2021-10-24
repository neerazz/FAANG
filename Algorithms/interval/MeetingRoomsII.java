import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created on:  Mar 10, 2021
 * Questions:
 */

public class MeetingRoomsII {

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}) + " should be [2]");
        System.out.println(minMeetingRooms(new int[][]{{}}) + " should be [0]");
        System.out.println(minMeetingRooms(new int[][]{{9, 10}, {4, 9}, {4, 17}}) + " should be [2]");
        System.out.println(minMeetingRooms(new int[][]{{2, 11}, {6, 16}, {11, 16}}) + " should be [2]");
        System.out.println(minMeetingRooms(new int[][]{{1, 5}, {8, 9}, {8, 9}}) + " should be [2]");
    }

    public static int minMeetingRooms_rev1(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] == i2[0] ? Integer.compare(i1[1], i2[1]) : Integer.compare(i1[0], i2[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[1], i2[1]));
        for (int[] cur : intervals) {
            if (pq.isEmpty() || pq.peek()[1] > cur[0]) {
                pq.add(cur);
            } else {
                int[] pre = pq.poll();
                pq.add(new int[]{Math.min(cur[0], pre[0]), Math.max(cur[1], pre[1])});
            }
        }
        return pq.size();
    }

    public static int minMeetingRooms(int[][] intervals) {
        int totalRooms = 0;
        if (intervals.length > 0 && intervals[0].length > 0) {
//         Loop through all the meetings and add it to a list.
            List<Meeting> meetings = new ArrayList<>();
            for (int[] interval : intervals) {
                meetings.add(new Meeting(interval[0], interval[1]));
            }
//         Sort the meetings based on the starting and ending time.
            meetings.sort((m1, m2) -> m1.start == m2.start ? m2.end - m1.end : m1.start - m2.start);
            totalRooms = 1;
            PriorityQueue<Meeting> queue = new PriorityQueue<>((m1, m2) -> m1.end - m2.end);
            queue.add(meetings.get(0));
            for (int i = 1; i < meetings.size(); i++) {
                Meeting cur = meetings.get(i);
                Meeting pre = queue.peek();
                if (pre.end > cur.start) {
                    totalRooms++;
                } else {
                    queue.poll();
                }
                queue.add(cur);
            }
        }
        return totalRooms;
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

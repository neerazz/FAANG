import java.io.FilenameFilter;
import java.util.*;

/**
 * Created on:  Jul 15, 2020
 * Questions: https://leetcode.com/problems/course-schedule-iii/
 */
public class CourseScheduleIII {
    static Map<String, Integer> memo;

    public static void main(String[] args) {
        System.out.println("********************************** Solution 1 *************************************");
        System.out.println(scheduleCourse(new int[][]{{5, 5}, {4, 6}, {2, 6}}) + " should be [2]");
        System.out.println(scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}) + " should be [3]");
        System.out.println(scheduleCourse(new int[][]{{5, 15}, {3, 19}, {6, 7}, {2, 10}, {5, 16}, {8, 14}, {10, 11}, {2, 19}}) + " should be [5]");
        System.out.println(scheduleCourse(new int[][]{{7, 16}, {2, 3}, {3, 12}, {3, 14}, {10, 19}, {10, 16}, {6, 8}, {6, 11}, {3, 13}, {6, 16}}) + " should be [4]");
        System.out.println("********************************** Solution 2 *************************************");
        System.out.println(scheduleCourse_dp(new int[][]{{5, 5}, {4, 6}, {2, 6}}) + " should be [2]");
        System.out.println(scheduleCourse_dp(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}) + " should be [3]");
        System.out.println(scheduleCourse_dp(new int[][]{{5, 15}, {3, 19}, {6, 7}, {2, 10}, {5, 16}, {8, 14}, {10, 11}, {2, 19}}) + " should be [5]");
        System.out.println(scheduleCourse_dp(new int[][]{{7, 16}, {2, 3}, {3, 12}, {3, 14}, {10, 19}, {10, 16}, {6, 8}, {6, 11}, {3, 13}, {6, 16}}) + " should be [4]");
    }

    public static int scheduleCourse_dp(int[][] courses) {
        memo = new HashMap<>();
        Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
        int len = courses.length, maxTime = courses[len - 1][1];
        return helper(courses, 0, 0);
    }

    private static int helper(int[][] courses, int idx, int time) {
        if (idx == courses.length) return 0;
        String key = idx + "-" + time;
        if (memo.containsKey(key)) return memo.get(key);
//        Find the best value by taking this course and without taking the course.
        int withOutTakingTheCourse = helper(courses, idx + 1, time), withTakingTheCourse = 0;
        if (time + courses[idx][0] <= courses[idx][1]) {
            withTakingTheCourse = 1 + helper(courses, idx + 1, time + courses[idx][0]);
        }
        int op = Math.max(withOutTakingTheCourse, withTakingTheCourse);
        memo.put(key, op);
        return op;
    }

    public static int scheduleCourse(int[][] courses) {
        Comparator<int[]> sortCourseBasedOnCompletionTime = (c1, c2) -> c1[1] - c2[1];
        Arrays.sort(courses, sortCourseBasedOnCompletionTime);
        Comparator<int[]> sortCourseBasedOnTime = (c1, c2) -> c2[0] - c1[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>(sortCourseBasedOnTime);
        int time = 0;
        for (int[] c : courses) {
            if (time + c[0] <= c[1]) {
//            If the current course can be done with in the expected time.
                time += c[0];
                pq.add(c);
            } else if (!pq.isEmpty() && pq.peek()[0] > c[0]) {
//                Try fitting the current course, by removing the previous course that is taking more time and blocking in taking the current course.
                time += c[0] - pq.poll()[0];
                pq.add(c);
            }
        }
        return pq.size();
    }
}

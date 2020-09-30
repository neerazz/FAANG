import java.util.*;

/**
 * Created on:  Sep 29, 2020
 * Questions: https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    public static void main(String[] args) {

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        Map<Integer, Set<Integer>> deps = new HashMap<>();
        for (int[] req : prerequisites) {
            in[req[1]]++;
            deps.computeIfAbsent(req[0], val -> new HashSet<>()).add(req[1]);
        }
        int processed = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.add(i);
                processed++;
            }
        }
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int dep : deps.getOrDefault(poll, new HashSet<>())) {
                if (--in[dep] == 0) {
                    queue.add(dep);
                    processed++;
                }
            }
        }
        return processed == numCourses;
    }
}

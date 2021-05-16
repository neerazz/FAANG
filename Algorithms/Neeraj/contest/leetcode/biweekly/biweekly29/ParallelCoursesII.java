package biweekly.biweekly29;

import java.util.*;

/**
 * Created on:  Jun 27, 2020
 * Questions: https://leetcode.com/problems/parallel-courses-ii
 */
public class ParallelCoursesII {
    public static void main(String[] args) {
        System.out.println(minNumberOfSemesters(4, new int[][]{{2, 1}, {3, 1}, {1, 4}}, 2) + " should be [3]");
        System.out.println(minNumberOfSemesters(8, new int[][]{{1, 6}, {2, 7}, {2, 5}, {8, 7}, {3, 4}}, 3) + " should be [3]");
        System.out.println(minNumberOfSemesters(8, new int[][]{{2, 7}, {1, 6}, {2, 8}, {8, 7}, {6, 7}, {5, 4}, {1, 7}, {1, 2}, {1, 4}, {2, 6}}, 3) + " should be [4]");
        System.out.println(minNumberOfSemesters(12, new int[][]{{1, 2}, {1, 3}, {7, 5}, {7, 6}, {4, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 12}}, 2) + " should be [6]");
    }

    public static int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        int count = 0;
        Map<Integer, Course> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new Course(i));
        }

        for (int[] dep : dependencies) {
            Course from = map.get(dep[0]);
            Course to = map.get(dep[1]);
            to.inbounds++;
            from.dep.add(to);
            from.outbounds++;
        }

//        PriorityQueue<Course> queue = new PriorityQueue<>((g1, g2) -> Integer.compare(g2.outbounds, g1.outbounds));
        LinkedList<Course> queue = new LinkedList<>();
        Comparator<Course> sorting = (g1, g2) -> Integer.compare(g2.outbounds, g1.outbounds);
        for (Course g : map.values()) {
            if (g.inbounds == 0) {
                queue.add(g);
            }
        }
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
//            We are not processing the top k from the PQ because:
//              Our PQ is sorted, when a new task is added it gets sorted and can cause change in position of courses that needs to be processed.
//              So first extract all teh possible k or the queue size of courses that needs to be processed at this level.
            int size = queue.size();
            count++;
            Collections.sort(queue, sorting);
//            Take all the courses that can be processed at that level.
            Queue<Course> level = new LinkedList<>();
            for (int i = 0; i < Math.min(size, k); i++) {
                level.add(queue.poll());
            }
            while (!level.isEmpty()) {
                Course poll = level.poll();
                visited.add(poll.val);
                for (Course child : poll.dep) {
                    if (!visited.contains(child.val)) {
                        if (--child.inbounds == 0) {
                            queue.add(child);
                        }
                    }
                }
            }
        }
        return count;
    }

    static class Course {
        int val;
        int inbounds;
        int outbounds;
        Set<Course> dep;

        public Course(int val) {
            this.val = val;
            dep = new HashSet<>();
        }
    }
}

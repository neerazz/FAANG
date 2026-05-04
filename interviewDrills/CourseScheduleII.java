import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * MAANG screen drill: Course Schedule II (topological sort via Kahn's BFS).
 *
 * Interview signal:
 * - Do you recognize the prerequisites graph as a DAG problem and reach for
 *   topological sort instead of trying brute-force permutations?
 * - Do you handle the cycle case as a first-class outcome (return empty
 *   array) rather than as an exception or an infinite loop?
 * - Do you build the adjacency list and indegree array in O(V + E) without
 *   double-counting duplicate prerequisites?
 *
 * Problem (LeetCode 210):
 * Given numCourses and a list of prerequisites where each [a, b] means
 * "to take a you must first take b", return any valid order in which to
 * take all numCourses courses. If no valid order exists (the graph has a
 * cycle), return an empty array.
 *
 * Approach -- Kahn's algorithm:
 * 1. Build adjacency list: for each prerequisite [a, b], add edge b -> a.
 *    Track indegree[a]++ for every such edge.
 * 2. Seed a queue with every course whose indegree is 0 -- those have no
 *    prerequisites and can be taken first.
 * 3. Pop a course, append it to the order, and "remove" its outgoing edges
 *    by decrementing indegree of each neighbor. Any neighbor that hits
 *    indegree 0 is now unblocked; enqueue it.
 * 4. If the produced order has fewer than numCourses entries, the graph
 *    has a cycle -- return an empty array. Otherwise return the order.
 *
 * Why Kahn over DFS:
 * Both work. Kahn's BFS variant makes cycle detection trivial -- you just
 * compare the output length to numCourses. The DFS variant requires a
 * three-color visited array (unvisited / on-stack / done) to detect
 * cycles, which is more code and easier to get wrong under interview time
 * pressure.
 *
 * Complexity:
 * - Time: O(V + E) -- each course is enqueued once, each edge is relaxed
 *   once.
 * - Space: O(V + E) for the adjacency list and indegree array.
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }

        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Deque<Integer> ready = new ArrayDeque<>();
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                ready.offer(course);
            }
        }

        int[] order = new int[numCourses];
        int taken = 0;
        while (!ready.isEmpty()) {
            int course = ready.poll();
            order[taken++] = course;
            for (int next : graph.get(course)) {
                if (--indegree[next] == 0) {
                    ready.offer(next);
                }
            }
        }

        if (taken < numCourses) {
            return new int[0];
        }
        return order;
    }

    public static void main(String[] args) {
        runNoPrerequisites();
        runLinearChain();
        runDiamondHasMultipleValidOrders();
        runCycleReturnsEmpty();
        runSelfLoopReturnsEmpty();
        runDuplicatePrerequisitesStillTerminate();
        runDisconnectedComponents();

        System.out.println("All CourseScheduleII drill checks passed.");
    }

    private static void runNoPrerequisites() {
        int[] order = new CourseScheduleII().findOrder(3, new int[0][0]);
        expectValidOrder(3, new int[0][0], order, "no prerequisites");
    }

    private static void runLinearChain() {
        int[][] prereqs = {{1, 0}, {2, 1}, {3, 2}};
        int[] order = new CourseScheduleII().findOrder(4, prereqs);
        expectValidOrder(4, prereqs, order, "linear chain 0 -> 1 -> 2 -> 3");
        expectArrayEquals(new int[] {0, 1, 2, 3}, order,
                "linear chain produces the unique order");
    }

    private static void runDiamondHasMultipleValidOrders() {
        int[][] prereqs = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = new CourseScheduleII().findOrder(4, prereqs);
        expectValidOrder(4, prereqs, order, "diamond 0 -> {1,2} -> 3");
    }

    private static void runCycleReturnsEmpty() {
        int[][] prereqs = {{1, 0}, {0, 1}};
        int[] order = new CourseScheduleII().findOrder(2, prereqs);
        expectArrayEquals(new int[0], order, "two-node cycle returns empty");
    }

    private static void runSelfLoopReturnsEmpty() {
        int[][] prereqs = {{0, 0}};
        int[] order = new CourseScheduleII().findOrder(1, prereqs);
        expectArrayEquals(new int[0], order, "self-loop returns empty");
    }

    private static void runDuplicatePrerequisitesStillTerminate() {
        int[][] prereqs = {{1, 0}, {1, 0}, {1, 0}};
        int[] order = new CourseScheduleII().findOrder(2, prereqs);
        expectValidOrder(2, prereqs, order,
                "duplicate prereqs increment indegree but do not livelock");
    }

    private static void runDisconnectedComponents() {
        int[][] prereqs = {{1, 0}, {3, 2}};
        int[] order = new CourseScheduleII().findOrder(4, prereqs);
        expectValidOrder(4, prereqs, order,
                "two disconnected chains 0->1 and 2->3");
    }

    private static void expectArrayEquals(int[] expected, int[] actual, String label) {
        if (!Arrays.equals(expected, actual)) {
            throw new AssertionError(label
                    + " expected " + Arrays.toString(expected)
                    + " but got " + Arrays.toString(actual));
        }
    }

    private static void expectValidOrder(int numCourses, int[][] prereqs,
                                         int[] order, String label) {
        if (order.length != numCourses) {
            throw new AssertionError(label
                    + " expected order of length " + numCourses
                    + " but got length " + order.length
                    + ": " + Arrays.toString(order));
        }
        Set<Integer> seen = new HashSet<>();
        int[] position = new int[numCourses];
        for (int i = 0; i < order.length; i++) {
            int course = order[i];
            if (course < 0 || course >= numCourses) {
                throw new AssertionError(label + " course out of range: " + course);
            }
            if (!seen.add(course)) {
                throw new AssertionError(label + " duplicate course: " + course);
            }
            position[course] = i;
        }
        for (int[] edge : prereqs) {
            int course = edge[0];
            int prereq = edge[1];
            if (position[prereq] >= position[course]) {
                throw new AssertionError(label
                        + " prerequisite " + prereq
                        + " not taken before " + course
                        + " in order " + Arrays.toString(order));
            }
        }
    }
}

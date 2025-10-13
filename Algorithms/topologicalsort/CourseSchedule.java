import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list representation of the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // Array to store the in-degree of each course
        int[] inDegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            // Add the edge from the prerequisite to the course
            graph.computeIfAbsent(prereq, k -> new ArrayList<>()).add(course);
            // Increment the in-degree of the course
            inDegree[course]++;
        }

        // Queue for courses with no prerequisites (in-degree of 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Count of courses that can be taken
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            // If the course has neighbors (i.e., it's a prerequisite for other courses)
            if (graph.containsKey(course)) {
                // Decrement the in-degree of each neighbor
                for (int neighbor : graph.get(course)) {
                    inDegree[neighbor]--;
                    // If a neighbor's in-degree becomes 0, add it to the queue
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // If the number of courses we can take is equal to the total number of courses,
        // then it's possible to finish all courses (no cycle).
        return count == numCourses;
    }
}

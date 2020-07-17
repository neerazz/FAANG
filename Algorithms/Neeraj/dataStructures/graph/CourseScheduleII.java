import java.util.*;

class CourseScheduleII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})) + " should be [0,1]");
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}, {0, 1}})) + " should be []");
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})) + " should be [0,1,2,3] or [0,2,1,3]");
        System.out.println(Arrays.toString(findOrder(5, new int[][]{})) + " should be [0,1,2,3,4]");
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] sorted = new int[numCourses];
        // Collect all the elements to map and the indegrees into a different array.
        for (int[] arr : prerequisites) {
            int cur = arr[1], dest = arr[0];
            List<Integer> values = map.getOrDefault(cur, new ArrayList<>());
            values.add(dest);
            indegree[dest] += 1;
            map.put(cur, values);
        }
        // Collect all the values with indegrees as zero.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        System.out.println("queue = " + queue);
        // Then travers through all the elements int the queue.
        int i = 0;
        while (!queue.isEmpty()) {
            // Pop the elements from queue.
            int poll = queue.poll();
            sorted[i++] = poll;
            // If poll have any dependencies,
            // reach out to all the dependencies and reduce the indegree at the respective positions.
            if (map.containsKey(poll)) {
                for (int dep : map.get(poll)) {
                    indegree[dep]--;
                    // Every time you encounter a dependency with '0' indegree add to the queue.
                    if (indegree[dep] == 0) {
                        queue.add(dep);
                    }
                }
            }
        }
        // Check if the graph has a circular connections.
        // Graph with circular connections, will have both nodes with greater indegree.
        // And those will not be added, hence it will cause the size difference.
        if (i == numCourses) {
            return sorted;
        }
        return new int[0];
    }

    public static int[] findOrder_invalidWhenCircular(int numCourses, int[][] prerequisites) {
        Map<Integer, Graph> map = new HashMap<>();
        // Add all cources to the map.
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new Graph(i));
        }
        // Create a releation with all the prerequisites in the graph.
        for (int[] arr : prerequisites) {
            int cur = arr[0], req = arr[1];
            Graph curGraph = map.get(cur);
            Graph reqGraph = map.get(req);
            curGraph.prerequisites.add(reqGraph);
        }
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (Graph course : map.values()) {
            if (!visited.contains(course.val)) {
                dfs(course, visited, stack);
            }
        }
        int[] op = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            op[index--] = stack.pop();
        }
        return op;
    }

    private static void dfs(Graph course, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(course.val);
        for (Graph prerequisites : course.prerequisites) {
            if (!visited.contains(prerequisites.val)) {
                dfs(prerequisites, visited, stack);
            }
        }
        stack.add(course.val);
    }

    static class Graph {
        int val;
        HashSet<Graph> prerequisites;

        public Graph(int val) {
            this.val = val;
            this.prerequisites = new HashSet<>();
        }
    }
}

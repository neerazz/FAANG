import java.util.*;

/**
 * Created on:  Jun 14, 2020
 * Questions: https://leetcode.com/problems/cheapest-flights-within-k-stops
 */
public class CheapestFlightsWithinKStops {
    static Map<Integer, List<int[]>> graph;
    static Map<String, Integer> memo;

    static Map<Integer, Set<Integer>> map;
    static Map<String, Integer> price;

    public static void main(String[] args) {
        System.out.println("************************************* Solution 1 ***************************************");
        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1) + " should be [200]");
        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0) + " should be [500]");
        System.out.println(findCheapestPrice(5, new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}}, 2, 1, 1) + " should be [-1]");
        System.out.println(findCheapestPrice(10,
                new int[][]{{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}},
                6, 0, 7) + " should be [14]");
        System.out.println(findCheapestPrice(17,
                new int[][]{{0, 12, 28}, {5, 6, 39}, {8, 6, 59}, {13, 15, 7}, {13, 12, 38}, {10, 12, 35}, {15, 3, 23}, {7, 11, 26}, {9, 4, 65}, {10, 2, 38}, {4, 7, 7}, {14, 15, 31}, {2, 12, 44}, {8, 10, 34}, {13, 6, 29}, {5, 14, 89}, {11, 16, 13}, {7, 3, 46}, {10, 15, 19}, {12, 4, 58}, {13, 16, 11}, {16, 4, 76}, {2, 0, 12}, {15, 0, 22}, {16, 12, 13}, {7, 1, 29}, {7, 14, 100}, {16, 1, 14}, {9, 6, 74}, {11, 1, 73}, {2, 11, 60}, {10, 11, 85}, {2, 5, 49}, {3, 4, 17}, {4, 9, 77}, {16, 3, 47}, {15, 6, 78}, {14, 1, 90}, {10, 5, 95}, {1, 11, 30}, {11, 0, 37}, {10, 4, 86}, {0, 8, 57}, {6, 14, 68}, {16, 8, 3}, {13, 0, 65}, {2, 13, 6}, {5, 13, 5}, {8, 11, 31}, {6, 10, 20}, {6, 2, 33}, {9, 1, 3}, {14, 9, 58}, {12, 3, 19}, {11, 2, 74}, {12, 14, 48}, {16, 11, 100}, {3, 12, 38}, {12, 13, 77}, {10, 9, 99}, {15, 13, 98}, {15, 12, 71}, {1, 4, 28}, {7, 0, 83}, {3, 5, 100}, {8, 9, 14}, {15, 11, 57}, {3, 6, 65}, {1, 3, 45}, {14, 7, 74}, {2, 10, 39}, {4, 8, 73}, {13, 5, 77}, {10, 0, 43}, {12, 9, 92}, {8, 2, 26}, {1, 7, 7}, {9, 12, 10}, {13, 11, 64}, {8, 13, 80}, {6, 12, 74}, {9, 7, 35}, {0, 15, 48}, {3, 7, 87}, {16, 9, 42}, {5, 16, 64}, {4, 5, 65}, {15, 14, 70}, {12, 0, 13}, {16, 14, 52}, {3, 10, 80}, {14, 11, 85}, {15, 2, 77}, {4, 11, 19}, {2, 7, 49}, {10, 7, 78}, {14, 6, 84}, {13, 7, 50}, {11, 6, 75}, {5, 10, 46}, {13, 8, 43}, {9, 10, 49}, {7, 12, 64}, {0, 10, 76}, {5, 9, 77}, {8, 3, 28}, {11, 9, 28}, {12, 16, 87}, {12, 6, 24}, {9, 15, 94}, {5, 7, 77}, {4, 10, 18}, {7, 2, 11}, {9, 5, 41}},
                13, 4, 13) + " should be [47]");
        System.out.println("************************************* Solution 2 ***************************************");
        System.out.println(findCheapestPrice_rev1(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1) + " should be [200]");
        System.out.println(findCheapestPrice_rev1(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0) + " should be [500]");
        System.out.println(findCheapestPrice_rev1(5, new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}}, 2, 1, 1) + " should be [-1]");
        System.out.println(findCheapestPrice_rev1(10,
                new int[][]{{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}},
                6, 0, 7) + " should be [14]");
        System.out.println(findCheapestPrice_rev1(17,
                new int[][]{{0, 12, 28}, {5, 6, 39}, {8, 6, 59}, {13, 15, 7}, {13, 12, 38}, {10, 12, 35}, {15, 3, 23}, {7, 11, 26}, {9, 4, 65}, {10, 2, 38}, {4, 7, 7}, {14, 15, 31}, {2, 12, 44}, {8, 10, 34}, {13, 6, 29}, {5, 14, 89}, {11, 16, 13}, {7, 3, 46}, {10, 15, 19}, {12, 4, 58}, {13, 16, 11}, {16, 4, 76}, {2, 0, 12}, {15, 0, 22}, {16, 12, 13}, {7, 1, 29}, {7, 14, 100}, {16, 1, 14}, {9, 6, 74}, {11, 1, 73}, {2, 11, 60}, {10, 11, 85}, {2, 5, 49}, {3, 4, 17}, {4, 9, 77}, {16, 3, 47}, {15, 6, 78}, {14, 1, 90}, {10, 5, 95}, {1, 11, 30}, {11, 0, 37}, {10, 4, 86}, {0, 8, 57}, {6, 14, 68}, {16, 8, 3}, {13, 0, 65}, {2, 13, 6}, {5, 13, 5}, {8, 11, 31}, {6, 10, 20}, {6, 2, 33}, {9, 1, 3}, {14, 9, 58}, {12, 3, 19}, {11, 2, 74}, {12, 14, 48}, {16, 11, 100}, {3, 12, 38}, {12, 13, 77}, {10, 9, 99}, {15, 13, 98}, {15, 12, 71}, {1, 4, 28}, {7, 0, 83}, {3, 5, 100}, {8, 9, 14}, {15, 11, 57}, {3, 6, 65}, {1, 3, 45}, {14, 7, 74}, {2, 10, 39}, {4, 8, 73}, {13, 5, 77}, {10, 0, 43}, {12, 9, 92}, {8, 2, 26}, {1, 7, 7}, {9, 12, 10}, {13, 11, 64}, {8, 13, 80}, {6, 12, 74}, {9, 7, 35}, {0, 15, 48}, {3, 7, 87}, {16, 9, 42}, {5, 16, 64}, {4, 5, 65}, {15, 14, 70}, {12, 0, 13}, {16, 14, 52}, {3, 10, 80}, {14, 11, 85}, {15, 2, 77}, {4, 11, 19}, {2, 7, 49}, {10, 7, 78}, {14, 6, 84}, {13, 7, 50}, {11, 6, 75}, {5, 10, 46}, {13, 8, 43}, {9, 10, 49}, {7, 12, 64}, {0, 10, 76}, {5, 9, 77}, {8, 3, 28}, {11, 9, 28}, {12, 16, 87}, {12, 6, 24}, {9, 15, 94}, {5, 7, 77}, {4, 10, 18}, {7, 2, 11}, {9, 5, 41}},
                13, 4, 13) + " should be [47]");
    }

    public static int findCheapestPrice_rev2(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> cons = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], cost = flight[2];
            cons.computeIfAbsent(from, key -> new ArrayList<>()).add(new int[]{to, cost});
        }
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int cur = poll[0], curCost = poll[1];
                for (int[] con : cons.getOrDefault(cur, new ArrayList<>())) {
                    int nextCost = curCost + con[1];
                    if (nextCost < distances[con[0]]) {
                        distances[con[0]] = nextCost;
                        q.add(new int[]{con[0], nextCost});
                    }
                }
            }
            stops++;
        }
        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }

    public static int findCheapestPrice_rev1(int n, int[][] flights, int src, int dst, int K) {
        map = new HashMap<>();
        price = new HashMap<>();
        for (int[] flight : flights) {
            map.computeIfAbsent(flight[0], val -> new HashSet<>()).add(flight[1]);
            price.put(flight[0] + "-" + flight[1], flight[2]);
        }
        Integer[][] dp = new Integer[n][K + 1];
        int result = helper(src, dst, K, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int helper(int cur, int dest, int stops, Integer[][] dp) {
        if (cur == dest) return 0;
        if (stops < 0) return Integer.MAX_VALUE;
        if (dp[cur][stops] != null) return dp[cur][stops];
        int curVal = Integer.MAX_VALUE;
        for (int next : map.getOrDefault(cur, new HashSet<>())) {
            int val = helper(next, dest, stops - 1, dp);
            if (val != Integer.MAX_VALUE) {
                curVal = Math.min(curVal, val + price.get(cur + "-" + next));
            }
        }
        return dp[cur][stops] = curVal;
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        graph = new HashMap<>();
        memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        boolean[] visited = new boolean[n];
        int result = dfs(src, dst, K, -1, visited);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int dfs(int cur, int dst, int k, int stops, boolean[] visited) {
        if (stops > k || visited[cur]) return Integer.MAX_VALUE;
        String key = cur + "-" + stops + "-" + dst;
        if (cur == dst) {
            return 0;
        }
        if (memo.containsKey(key)) return memo.get(key);
        int curCost = Integer.MAX_VALUE;
        visited[cur] = true;
        for (int[] next : graph.get(cur)) {
            int nextCost = dfs(next[0], dst, k, stops + 1, visited);
            if (nextCost != Integer.MAX_VALUE) {
                curCost = Math.min(curCost, nextCost + next[1]);
            }
        }
        visited[cur] = false;
        memo.put(key, curCost);
        return curCost;
    }
}

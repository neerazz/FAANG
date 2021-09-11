import java.util.*;

/**
 * Created on:  Mar 17, 2021
 * Questions:
 * <p>
 * You're looking to move into a new apartment on specific street, and you're given a list of contiguous blocks on that street where each block contains an apartment that you could move into.
 * <p>
 * You also have a list of requirements: a list of buildings that are important to you. For instance, you might value having a school and a gym near your apartment. The list of blocks that you have contains information at every block about all of the buildings that are present and absent at the block in question. For instance, for every block, you might know whether a school, a pool, an office, and a gym are present.
 * <p>
 * In order to optimize your life, you want to pick an apartment block such that you minimize the farthest distance you'd have to walk from your apartment to reach any of your required buildings.
 * <p>
 * Write a function that takes in a list of contiguous blocks on a specific street and a list of your required buildings and that returns the location (the index) of the block that's most optimal for you.
 * <p>
 * If there are multiple most optimal blocks, your function can return the index of any one of them.
 * <p>
 * Sample Input
 * blocks = [
 * {
 * "gym": false,   INF, 1                               1
 * "school": true, 0  , 0                               0
 * "store": false, INF, 5, over_all_dist and max_dist   4
 * },
 * {
 * "gym": true,        0,0                              0
 * "school": false,    1,1                              1
 * "store": false,     INF, 3                           3
 * },
 * {
 * "gym": true,        0,0                              0
 * "school": true,     0,0                              0
 * "store": false,    INF, 2                            2
 * },
 * {
 * "gym": false,        1,INF                           1
 * "school": true,       0,0                            0
 * "store": false,     INF, 1                           1
 * },
 * {
 * "gym": false,        2,INF                           1
 * "school": true,       0,0                            0
 * "store": true,        0,0                            0
 * },
 * ]
 * reqs = ["gym", "school", "store"]
 * <p>
 * 3 // at index 3, the farthest you'd have to walk to reach a gym, a school, or a store is 1 block; at any other index, you'd have to walk farther
 */

public class ApartmentHunting {

    public static void main(String[] args) {
        System.out.println(apartmentHunting(
                Arrays.asList(
                        Map.of("gym", false, "school", true, "store", false),
                        Map.of("gym", true, "school", false, "store", false),
                        Map.of("gym", true, "school", true, "store", false),
                        Map.of("gym", false, "school", true, "store", false),
                        Map.of("gym", false, "school", true, "store", true)
                ), new String[]{"gym", "school", "store"}));
        System.out.println(apartmentHunting(
                Arrays.asList(
                        Map.of("foo", true, "gym", false, "kappa", false, "office", true, "school", true, "store", false),
                        Map.of("foo", true, "gym", true, "kappa", false, "office", false, "school", false, "store", false),
                        Map.of("foo", true, "gym", true, "kappa", false, "office", false, "school", true, "store", false),
                        Map.of("foo", true, "gym", false, "kappa", false, "office", false, "school", true, "store", false),
                        Map.of("foo", true, "gym", true, "kappa", false, "office", false, "school", true, "store", false),
                        Map.of("foo", true, "gym", false, "kappa", false, "office", false, "school", true, "store", true)
                ), new String[]{"gym", "school", "store"}));
    }

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int len = blocks.size();
        List<Map<String, Integer>> left = new ArrayList<>(), right = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            left.add(new HashMap<>());
            right.add(new HashMap<>());
        }
        Map<String, Integer> dists = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Map<String, Boolean> block = blocks.get(i);
            for (String item : block.keySet()) {
                int dist = dists.getOrDefault(item, Integer.MAX_VALUE);
                if (block.get(item)) {
                    dist = 0;
                } else if (dist != Integer.MAX_VALUE) dist++;
                dists.put(item, dist);
                left.get(i).put(item, dist);
            }
        }
        dists = new HashMap<>();
        for (int i = len - 1; i >= 0; i--) {
            Map<String, Boolean> block = blocks.get(i);
            for (String item : block.keySet()) {
                int dist = dists.getOrDefault(item, Integer.MAX_VALUE);
                if (block.get(item)) {
                    dist = 0;
                } else if (dist != Integer.MAX_VALUE) dist++;
                dists.put(item, dist);
                right.get(i).put(item, dist);
            }
        }
//        System.out.println("left = " + left);
//        System.out.println("right = " + right);
        Integer bestidx = null, bestDist = null, blockMax = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0, max = 0;
            for (String item : reqs) {
                int l = left.get(i).get(item), r = right.get(i).get(item);
                int min = Math.min(l, r);
                sum += min;
                max = Math.max(max, min);
            }
//            System.out.println("Over All Sum = " + sum + " Max = " + max);
            if (bestidx == null || bestDist > sum || (bestDist == sum && blockMax > max)) {
                bestidx = i;
                bestDist = sum;
                blockMax = max;
            }
        }
        return bestidx;
    }
}

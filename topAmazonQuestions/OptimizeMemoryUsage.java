import java.util.*;

/**
 * Created on:  Jan 16, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-oa2-optimize-memory-usage
 */

public class OptimizeMemoryUsage {

    public static void main(String[] args) {
        optimizeMemoryUsage(new int[]{1, 7, 2, 4, 5, 6}, new int[]{1, 1, 2}, 0).forEach(i -> System.out.println(Arrays.toString(i)));
        optimizeMemoryUsage(new int[]{6, 6, 6}, new int[]{1}, 7).forEach(i -> System.out.println(Arrays.toString(i)));
        optimizeMemoryUsage(new int[]{1, 1}, new int[]{6, 6, 6, 6, 7}, 7).stream().forEach(i -> System.out.println(Arrays.toString(i)));
        optimizeMemoryUsage(new int[]{1, 7, 2, 4, 5, 6}, new int[]{1, 1, 2}, 1).stream().forEach(i -> System.out.println(Arrays.toString(i)));
        optimizeMemoryUsage(new int[]{1, 7, 8}, new int[]{3, 1, 2}, 10).stream().forEach(i -> System.out.println(Arrays.toString(i)));
    }

    public static List<int[]> optimizeMemoryUsage(int[] fore, int[] back, int k) {
        int max = 0;
        TreeMap<Integer, Set<Integer>> fMap = new TreeMap<>((v1, v2) -> Integer.compare(v2, v1)), bMap = new TreeMap<>();
        Map<Integer, List<int[]>> pairs = new HashMap<>();
        for (int i = 0; i < back.length; i++) {
            int cur = back[i];
            bMap.computeIfAbsent(cur, val -> new HashSet<>()).add(i);
            pairs.computeIfAbsent(cur, val -> new ArrayList<>()).add(new int[]{-1, i});
            if (cur <= k) max = Math.max(max, cur);
        }
        for (int i = 0; i < fore.length; i++) {
            int cur = fore[i];
            pairs.computeIfAbsent(cur, val -> new ArrayList<>()).add(new int[]{i, -1});
            fMap.computeIfAbsent(cur, val -> new HashSet<>()).add(i);
            if (cur <= k) max = Math.max(max, cur);
        }
        for (int a : fMap.keySet()) {
            Map.Entry<Integer, Set<Integer>> bEntry = bMap.floorEntry(k - a);
            if (bEntry != null) {
                Set<Integer> aIdxs = fMap.get(a);
                int sum = a + bEntry.getKey();
                if (sum <= k) {
                    max = Math.max(max, sum);
                    for (int aId : aIdxs) {
                        for (int bId : bEntry.getValue()) {
                            pairs.computeIfAbsent(sum, val -> new ArrayList<>()).add(new int[]{aId, bId});
                        }
                    }
                }
            }
        }
        return pairs.getOrDefault(max, Arrays.asList(new int[]{-1, -1}));
    }
}

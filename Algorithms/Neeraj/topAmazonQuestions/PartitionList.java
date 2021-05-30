import java.util.*;

/**
 * Created on:  May 30, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-optimizing-box-weight
 */

public class PartitionList {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(optimizingBoxWeight(new int[]{4, 5, 2, 3, 1, 2})));
        System.out.println(minimalHeaviestSetA(Arrays.asList(4, 5, 2, 3, 1, 2)));
    }

    /**
     * @implNote Since we are looking to divide weights into two boxes, and the box A weight is expected to be height and box a count is expected to be lighter. So we can sort the
     */
    private static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        Comparator<Integer> order = (v1, v2) -> Integer.compare(v2, v1);
        TreeMap<Integer, Integer> map = new TreeMap<>(order);
        int sum = 0;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            sum += num;
        }
        int targetSum = sum / 2, currentSum = 0;
        List<Integer> result = new ArrayList<>();
        for (int weight : map.keySet()) {
            int times = map.get(weight);
            currentSum += weight * times;
//            Add the current weight times.
            for (int i = 0; i < times; i++) result.add(weight);
            if (currentSum > targetSum) break;
        }
        return result;
    }

    public static int[] optimizingBoxWeight(int[] nums) {
        int sum = Arrays.stream(nums).sum(), targetSum = sum / 2;
        int currentSum = 0, idx = nums.length - 1;
        List<Integer> result = new ArrayList<>();
        while (currentSum < targetSum) {
            int cur = nums[idx--];
            result.add(cur);
            currentSum += cur;
        }
        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}

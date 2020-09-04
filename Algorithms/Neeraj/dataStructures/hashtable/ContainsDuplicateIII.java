import java.util.TreeMap;

/**
 * Created on:  Sep 02, 2020
 * Questions: https://leetcode.com/problems/contains-duplicate-iii/
 */
public class ContainsDuplicateIII {
    public static void main(String[] args) {
        System.out.println("*************************************** Solution 1 **********************************");
        System.out.println("Answer is:" + containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0) + " should be [true].");
        System.out.println("Answer is:" + containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2) + " should be [true].");
        System.out.println("Answer is:" + containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3) + " should be [false].");
        System.out.println("Answer is:" + containsNearbyAlmostDuplicate(new int[]{4, 2}, 2, 1) + " should be [false].");
        System.out.println("Answer is:" + containsNearbyAlmostDuplicate(new int[]{3, 6, 0, 4}, 2, 2) + " should be [true].");

        System.out.println("*************************************** Solution 2 **********************************");
        System.out.println("Answer is:" + containsNearbyAlmostDuplicate_naive(new int[]{1, 2, 3, 1}, 3, 0) + " should be [true].");
        System.out.println("Answer is:" + containsNearbyAlmostDuplicate_naive(new int[]{1, 0, 1, 1}, 1, 2) + " should be [true].");
        System.out.println("Answer is:" + containsNearbyAlmostDuplicate_naive(new int[]{1, 5, 9, 1, 5, 9}, 2, 3) + " should be [false].");
        System.out.println("Answer is:" + containsNearbyAlmostDuplicate_naive(new int[]{4, 2}, 2, 1) + " should be [false].");
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = map.ceilingKey((long) nums[i] - t), floor = map.ceilingKey((long) nums[i] + t);
            if ((ceiling != null && Math.abs(ceiling - nums[i]) <= t && i - map.get(ceiling) <= k) || (floor != null && Math.abs(floor - nums[i]) <= t && i - map.get(floor) <= k))
                return true;
            map.put((long) nums[i], i);
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicate_naive(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            long vi = nums[i];
            for (int j = i + 1; j < Math.min(nums.length, i + k + 1); j++) {
                long vj = nums[j];
                if (Math.abs(vi - vj) <= t) return true;
            }
        }
        return false;
    }
}

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Jan 13, 2021
 * Questions: https://leetcode.com/discuss/interview-question/372434
 */

public class TwoSumUniquePairs {

    public static void main(String[] args) {
        System.out.println(uniquePairs(new int[]{1, 1, 2, 45, 46, 46}, 47));
        System.out.println(uniquePairs(new int[]{1, 1}, 2));
        System.out.println(uniquePairs(new int[]{1, 5, 1, 5}, 6));
    }

    private static int uniquePairs(int[] nums, int target) {
        Set<Integer> set = new HashSet<>(), paired = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            int rem = target - num;
            if (set.contains(rem) && !paired.contains(num)) {
                set.remove(rem);
                paired.add(num);
                paired.add(rem);
                count++;
            } else {
                set.add(num);
            }
        }
        return count;
    }
}

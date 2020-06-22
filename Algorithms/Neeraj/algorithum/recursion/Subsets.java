import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on:  Jun 20, 2020
 * Questions: https://leetcode.com/problems/subsets/
 */
public class Subsets {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> subsets(int[] nums) {
        return helper(nums, 0);
    }

    private static List<List<Integer>> helper(int[] nums, int index) {
        if (index >= nums.length) return Collections.singletonList(Collections.emptyList());
        List<List<Integer>> next = helper(nums, index + 1);
        List<List<Integer>> cur = new ArrayList<>(next);
        for (List<Integer> val : next) {
            List<Integer> temp = new ArrayList<>(val);
            temp.add(nums[index]);
            cur.add(temp);
        }
        return cur;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on:  Jun 20, 2020
 * Questions: https://leetcode.com/problems/subsets/
 */
public class Subsets {
    static List<List<Integer>> op;

    public static void main(String[] args) {
        System.out.println("****************************** Solution 1 **********************************");
        System.out.println(subsets(new int[]{1, 2, 3, 4, 5}).equals(subsets_rev1(new int[]{1, 2, 3, 4, 5})));
        System.out.println(subsets(new int[]{1, 2, 3}).equals(subsets_rev1(new int[]{1, 2, 3})));
    }

    public static List<List<Integer>> subsets_rev1(int[] nums) {
        op = new ArrayList<>();
        recursion(nums, 0);
        return op;
    }

    private static void recursion(int[] nums, int idx) {
        if (nums.length == idx) {
            op.add(Collections.emptyList());
        } else {
            recursion(nums, idx + 1);
            int size = op.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(op.get(i));
                temp.add(nums[idx]);
                op.add(temp);
            }
        }
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

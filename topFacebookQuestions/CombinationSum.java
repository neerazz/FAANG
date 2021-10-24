import java.util.*;

/**
 * Created on:  Aug 17, 2020
 * Questions: https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Memo: What are the list of values that can be formed for a given target.
        Map<Integer, Set<List<Integer>>> memo = new HashMap<>();
        return new ArrayList<>(helper(candidates, target, memo));
    }

    private static Set<List<Integer>> helper(int[] values, int target, Map<Integer, Set<List<Integer>>> memo) {
        if (target < 0) return Collections.emptySet();
//        When you have all the selected values, in stack.
        if (target == 0) return new HashSet<>(Collections.singletonList(Collections.emptyList()));
        if (memo.containsKey(target)) return memo.get(target);
        Set<List<Integer>> cur = new HashSet<>();
        for (int val : values) {
            Set<List<Integer>> next = helper(values, target - val, memo);
            for (List<Integer> nextValues : next) {
                List<Integer> temp = new ArrayList<>(nextValues);
                temp.add(val);
                Collections.sort(temp);
                cur.add(temp);
            }
        }
        memo.put(target, cur);
        return cur;
    }
}

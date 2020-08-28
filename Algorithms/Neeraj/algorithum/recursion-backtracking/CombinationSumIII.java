import java.util.*;

/**
 * Created on:  Aug 07, 2020
 * Questions: https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(4, 9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        Map<String, List<List<Integer>>> memo = new HashMap<>();
        return helper(k, n, 0, 0, memo);
    }

    private static List<List<Integer>> helper(int k, int n, int soFarSum, Integer pre, Map<String, List<List<Integer>>> memo) {
//        If the soFarSum == sum. Then return single element list.
        if (k == 0) {
            if (soFarSum == n) return Collections.singletonList(Collections.emptyList());
            else return Collections.emptyList();
        }
        String key = k + "-" + soFarSum + "-" + pre;
        if (memo.containsKey(key)) return memo.get(key);
        List<List<Integer>> cur = new ArrayList<>();
        for (int i = pre + 1; i <= 9 && soFarSum + i <= n; i++) {
            List<List<Integer>> next = helper(k - 1, n, soFarSum + i, i, memo);
            for (List<Integer> val : next) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.addAll(val);
                cur.add(temp);
            }
        }
        memo.put(key, cur);
        return cur;
    }
}

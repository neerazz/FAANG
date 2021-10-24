import java.util.*;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/7npk3V3JQNr
 */

public class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets_unique(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> cur = new ArrayList<>();
            for (List<Integer> pre : subsets) {
                List<Integer> temp = new ArrayList<>(pre);
                temp.add(num);
                cur.add(temp);
            }
            subsets.addAll(cur);
        }
        return subsets;
    }

    public static List<List<Integer>> findSubsets_duplicate_rev2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int pre = Integer.MIN_VALUE, preIdx = 0;
        for (int cur : nums) {
            List<List<Integer>> curLevel = new ArrayList<>();
            int start = cur == pre ? preIdx : 0, end = subsets.size();
            for (int i = start; i < end; i++) {
                List<Integer> temp = new ArrayList<>(subsets.get(i));
                temp.add(cur);
                curLevel.add(temp);
            }
            subsets.addAll(curLevel);
            pre = cur;
            preIdx++;
        }
        return subsets;
    }

    public static List<List<Integer>> findSubsets_duplicate(int[] nums) {
        Set<List<Integer>> subsets = new HashSet<>();
        subsets.add(new ArrayList<>());
        for (int num : nums) {
            Set<List<Integer>> cur = new HashSet<>();
            for (List<Integer> pre : subsets) {
                List<Integer> temp = new ArrayList<>(pre);
                temp.add(num);
                cur.add(temp);
            }
            subsets.addAll(cur);
        }
        return new ArrayList<>(subsets);
    }

    public static void main(String[] args) {
        System.out.println(findSubsets_unique(new int[]{1, 2, 3}));
        System.out.println(findSubsets_unique(new int[]{1, 2, 3, 4, 5}));
        System.out.println("********************************* Solution 1 ******************************");
        System.out.println(findSubsets_duplicate(new int[]{1, 3, 3}));
        System.out.println(findSubsets_duplicate(new int[]{1, 5, 3, 3}));
        System.out.println("********************************* Solution 2 ******************************");
        System.out.println(findSubsets_duplicate_rev2(new int[]{1, 3, 3}));
        System.out.println(findSubsets_duplicate_rev2(new int[]{1, 5, 3, 3}));
    }
}

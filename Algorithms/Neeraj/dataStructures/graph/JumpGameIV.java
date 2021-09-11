import java.util.*;

/**
 * Created on:  Dec 27, 2020
 * Questions: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3582/
 */

public class JumpGameIV {

    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
    }

    public static int minJumps(int[] arr) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            map.computeIfAbsent(arr[i], val -> new HashSet<>()).add(i);
        }
        List<Integer> level = new ArrayList<>();
        level.add(0);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int step = 0;
        while (!level.isEmpty()) {
            List<Integer> next = new ArrayList<>();
//             Loop through the current layer
            for (int cur : level) {
                if (cur == len - 1) return step;

//                 Loop through the same values and add those indexs
                for (int idx : map.get(arr[cur])) {
                    if (set.add(idx)) {
                        next.add(idx);
                    }
                }
//                Clear the list to prevent redundant search
                map.get(arr[cur]).clear();

//                 Check neighbors
                if (cur - 1 >= 0 && set.add(cur - 1)) next.add(cur - 1);
                if (cur + 1 < len && set.add(cur + 1)) next.add(cur + 1);
            }
            level = next;
            step++;
        }
        return -1;
    }
}

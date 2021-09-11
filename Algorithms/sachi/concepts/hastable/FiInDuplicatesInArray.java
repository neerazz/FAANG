package concepts.hastable;

import java.util.*;

public class FiInDuplicatesInArray {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> counter = new HashMap<>();
        List<Integer> sol = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            if (counter.containsKey(nums1[i])) {
                counter.put(nums1[i], counter.get(nums1[i]) + 1);
            } else {
                counter.put(i, 1);
            }
        }

        for (int value : nums2) {
            Integer val = counter.get(value);
            if (val != null && val > 0) {
                sol.add(value);
                counter.put(value, --val);
            }
        }

        int[] result = new int[sol.size()];
        int j = 0;
        for (Integer i : sol) {
            result[j++] = i;
        }

        return result;

    }
}

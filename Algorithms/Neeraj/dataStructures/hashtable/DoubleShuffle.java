import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Sep 14, 2021
 * Ref: https://leetcode.com/discuss/interview-experience/1461079/google-swe-l3l4-dublin-ireland-reject
 * <p>
 * Given an array generate its double-shuffle i.e. double every array element and append it's double to the same array. Now shuffle this array randomly.
 * For e.g. if the array is [1, 3, 2] then it's double is [1, 3, 2, 2, 6, 4]. Finally, shuffle this array randomly which can be [3, 4, 2, 1, 2, 6]
 * Now given a double-shuffle array find it's original array. Using above example, if double-shuffle is [3, 4, 2, 1, 2, 6] then return [1, 2, 3] (in no particular order)
 */
public class DoubleShuffle {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getOriginal(new int[]{3, 4, 2, 1, 2, 6})));
    }

    public static int[] getOriginal(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] result = new int[len / 2];
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int half = num / 2;
            if (num % 2 == 0 && map.containsKey(half)) {
                result[i++] = half;
                int occ = map.remove(half);
                if (occ > 1) map.put(half, occ - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return result;
    }
}

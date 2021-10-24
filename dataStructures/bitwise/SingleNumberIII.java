import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Jul 23, 2020
 * Questions: https://leetcode.com/problems/single-number-iii/
 */
public class SingleNumberIII {
    public static void main(String[] args) {

    }

    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        int[] op = new int[2];
        int i = 0;
        for (int num : set) {
            op[i++] = num;
        }
        return op;
    }
}

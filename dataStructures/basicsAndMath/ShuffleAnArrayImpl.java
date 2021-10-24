import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created on:  Oct 12, 2021
 * Ref: https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleAnArrayImpl {
    public static void main(String[] args) {

    }

    static class ShuffleAnArray {
        int[] nums, cur;
        Random ran;

        public ShuffleAnArray(int[] nums) {
            this.nums = nums;
            this.cur = nums.clone();
            ran = new Random();
        }

        List<Integer> getList() {
            return Arrays.stream(cur).boxed().collect(Collectors.toList());
        }

        public int[] reset() {
            cur = nums.clone();
            return nums;
        }

        public int[] shuffle() {
            List<Integer> list = getList();
            for (int i = 0; i < nums.length; i++) {
                int idx = ran.nextInt(list.size());
                cur[i] = list.get(idx);
                list.remove(idx);
            }
            return cur;
        }
    }
}

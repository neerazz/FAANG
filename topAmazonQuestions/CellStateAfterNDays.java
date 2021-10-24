import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-oa2-cell-state-after-n-days
 */

public class CellStateAfterNDays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(newState(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1)) + " = [0, 1, 0, 0, 1, 0, 1, 0]");
        System.out.println(Arrays.toString(newState(new int[]{1, 1, 1, 0, 1, 1, 1, 1}, 2)) + " = [0, 0, 0, 0, 0, 1, 1, 0]");
        System.out.println(Arrays.toString(prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000)) + " = [0, 0, 1, 1, 1, 1, 1, 0]");
    }

    public static int[] prisonAfterNDays(int[] nums, int k) {
        Map<String, Integer> stateMap = new HashMap<>();
        int day = 0, cur[] = nums;
        stateMap.put(Arrays.toString(cur), 0);
        while (k > 0) {
            k--;
            day++;
            int[] next = new int[8];
            for (int i = 1; i < 7; i++) {
                next[i] = cur[i - 1] == cur[i + 1] ? 1 : 0;
            }
            String nextStr = Arrays.toString(next);
            System.out.println(nextStr + ". Day = " + day);
            if (stateMap.containsKey(nextStr)) {
                int pre = stateMap.get(nextStr);
                System.out.println("Repeated : " + pre);
                k %= (day - pre);
            } else {
                stateMap.put(nextStr, day);
            }
            cur = next;
        }
        return cur;
    }

    private static int[] newState(int[] nums, int k) {
        Map<String, Integer> stateMap = new HashMap<>();
        int day = 0;
        while (k > 0) {
            k--;
            day++;
            int[] next = new int[8];
            next[0] = nums[1];
            next[7] = nums[6];
            for (int i = 1; i < 7; i++) {
                next[i] = nums[i - 1] ^ nums[i + 1];
            }
            String nextStr = Arrays.toString(next);
            if (stateMap.containsKey(nextStr)) {
                int pre = stateMap.get(nextStr);
                k /= (day - pre);
            } else {
                stateMap.put(nextStr, k);
            }
            nums = next;
        }
        return nums;
    }
}

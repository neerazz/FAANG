/**
 * Created on:  Oct 30, 2020
 * Questions: https://app.codility.com/c/run/demoSR6XM4-PGA/
 */

public class SmallestPositiveInteger {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}));
        System.out.println(solution(new int[]{1}));
        System.out.println(solution(new int[]{2}));
        System.out.println(solution(new int[]{3}));
    }

    public static int solution(int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) nums[i] = len + 1;
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min > 1) return 1;
//        Now the array will have only number between 1 to n+1
        for (int i = 0; i < len; i++) {
            int cur = Math.abs(nums[i]);
            if (cur > len) continue;
//            Convert the number at the cur index to negative. Convert only if the number is positive.
            if (nums[cur - 1] > 0) {
                nums[cur - 1] *= -1;
            }
        }
//        Now loop through the array and find the first index that doesn't have a negative value
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return max + 1;
    }
}

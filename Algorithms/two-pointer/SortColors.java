import java.util.Arrays;

/**
 * Created on:  Jun 11, 2020
 * Questions: https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
    public static void main(String[] args) {
        System.out.println("*********************** Solution 1 *********************");
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{2, 0, 0, 1, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("*********************** Solution 2 *********************");
        int[] nums2 = new int[]{2, 0, 2, 1, 1, 0};
        sortColors_Optimal(nums2);
        System.out.println(Arrays.toString(nums2));
        nums2 = new int[]{2, 0, 0, 1, 0, 1};
        sortColors_Optimal(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    public static void sortColors_Optimal(int[] nums) {
        int c1 = 0, c2 = 0, c3 = nums.length - 1;
        while (c2 <= c3) {
            if (nums[c2] == 0) {
//                Then swap the current c1 value with c2 value.
                swap(nums, c2++, c1++);
            } else if (nums[c2] == 1) {
//                Let the value stay there and increase the c2 pointer
                c2++;
            } else {
                swap(nums, c2, c3--);
            }
        }
    }

    private static void swap(int[] nums, int to, int from) {
        int temp = nums[to];
        nums[to] = nums[from];
        nums[from] = temp;
    }

    public static void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums) counts[num]++;
        int index = 0, p1 = 0;
        while (p1 < 3) {
            int count = counts[p1];
            for (int i = 0; i < count; i++) {
                nums[index++] = p1;
            }
            p1++;
        }
    }
}

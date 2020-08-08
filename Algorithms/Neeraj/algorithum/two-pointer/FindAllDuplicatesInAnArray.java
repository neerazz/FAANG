import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on:  Aug 06, 2020
 * Questions: https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}) + " = [2,3]");
        System.out.println(findDuplicates(new int[]{4, 9, 2, 7, 8, 2, 9, 1, 8}) + " = [2,9,8]");
        System.out.println(findDuplicates(new int[]{79, 88, 22, 20, 11, 24, 37, 42, 18, 2, 99, 31, 31, 30, 81, 52, 34, 91, 90, 48, 41, 71, 54, 40, 58, 21, 14, 91, 35, 74, 17, 44, 54, 47, 68, 100, 83, 96, 94, 72, 67, 42, 67, 81, 94, 98, 46, 47, 82, 48, 57, 61, 44, 64, 17, 77, 74, 15, 58, 32, 52, 13, 57, 89, 45, 5, 63, 1, 46, 35, 56, 32, 28, 72, 71, 99, 93, 23, 93, 14, 30, 43, 2, 20, 78, 95, 45, 50, 1, 85, 65, 87, 55, 55, 85, 62, 75, 98, 39, 50}) +
                " = [31,91,54,42,67,81,94,47,48,44,17,74,58,52,57,46,35,32,72,71,99,93,14,30,2,20,45,1,55,85,98,50]");
    }

    public static List<Integer> findDuplicates(int[] nums) {
        Set<Integer> op = new HashSet<>();
        int len = nums.length, i = 0;
        if (len < 2) return new ArrayList<>(op);
        boolean lenTaken = false;
        while (i < len) {
            if (nums[i] == len) {
                if (lenTaken) op.add(len);
                else {
                    nums[i] = 0;
                    lenTaken = true;
                }
                i++;
            } else if (i == nums[i]) {
                i++;
            } else {
//                 Swap cur with the index of current
                int swap = nums[i];
                nums[i] = nums[swap];
                nums[swap] = swap;
//                 Even after swap if the num is same then add to list.
                if (nums[i] == swap) {
                    op.add(nums[i]);
                    i++;
                }
            }
        }

        return new ArrayList<>(op);
    }
}

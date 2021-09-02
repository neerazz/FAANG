import java.util.*;

/**
 * Created on:  Aug 29, 2021
 * Ref: https://leetcode.com/problems/patching-array
 */
public class PatchingArray {
    public static void main(String[] args) {
        System.out.println(minPatches(new int[]{1, 3}, 6) + " = 1");
        System.out.println(minPatches(new int[]{1, 5, 10}, 20) + " = 2");
        System.out.println(minPatches(new int[]{1, 2, 2}, 5) + " = 0");
    }

    public static int minPatches(int[] nums, int n) {
        if(nums.length == 0) return 0;
        long covered = 0;
        int count = 0;
//        Initially you have all the numbers to till covered with count number of patching.
        for(int num: nums){
            while(num > covered+1){
//                If you reached a number which is greater than covered, then find out how many patching is required till that number.
                System.out.println("Pathching " + (covered +1));
                covered += covered+1;
                count++;
//                keep checking that if you have reached the number, if so yuo cna exit the current count.
                if(covered >= n) return count;
            }
//            Now you know that, you are able to reach covered, also now you are able to reach number. Then add all those to covered.
            covered += num;
            if(covered >= n) return count;
        }
//        If you have completed all the numbers in array, but have still not reached the end then, greedily keep patching a number+1;
        while(n > covered){
            covered += covered +1;
            count++;
        }
        return count;
    }
}

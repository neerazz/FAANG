import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 08, 2020
 * Questions: https://leetcode.com/problems/intersection-of-two-arrays/
 */

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

    }

    public static int[] intersection_Optimal(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        for(int num: nums2){
            if(set1.contains(num)) duplicate.add(num);
        }
        int[] op = new int[duplicate.size()];
        int idx = 0;
        for (int num : duplicate) {
            op[idx++] = num;
        }
        return op;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, l1 = nums1.length, j = 0, l2 = nums2.length;
        Set<Integer> set = new HashSet<>();
        while (i < l1 && j < l2) {
            int v1 = nums1[i], v2 = nums2[j];
            if (v1 == v2) {
                set.add(v1);
                i++;
                j++;
            } else if (v1 < v2) {
                i++;
            } else {
                j++;
            }
        }
        int[] op = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            op[idx++] = num;
        }
        return op;
    }
}

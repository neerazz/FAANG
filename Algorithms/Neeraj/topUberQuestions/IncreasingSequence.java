import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 07, 2020
 * Questions:
 */

public class IncreasingSequence {

    public static void main(String[] args) {

    }

    static boolean almostIncreasingSequence(int[] nums) {
        int rem = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                rem++;
                if (rem > 1) return false;
                // If by removing the current element, or pre element is possible
                if (i + 1 < nums.length && nums[i - 1] >= nums[i + 1] &&
                        i > 1 && nums[i - 2] >= nums[i]) return false;
            }
        }
        System.out.println(rem);
        return rem <= 1;
    }
}

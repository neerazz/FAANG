import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 15, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-items-in-containers
 */

public class ItemsInContainers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfItems("*|*|", new int[]{1}, new int[]{3})));
        System.out.println(Arrays.toString(numberOfItems("*|*|*|", new int[]{1}, new int[]{6})));
    }

    private static int[] numberOfItems(String str, int[] starts, int[] ends) {
        int len = str.length();
        int[] result = new int[starts.length], left = new int[len], right = new int[len];
//        Left array will have the index of close\open located on the left side.
//        Right array will have the index of close\open located on the right side.
        int closeIdx = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == '|') closeIdx = i;
            right[i] = closeIdx;
        }
        closeIdx = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '|') closeIdx = i;
            left[i] = closeIdx;
        }
        for (int i = 0; i < starts.length; i++) {
            int start = starts[i], end = ends[i];
            int startIdx = right[start - 1], endIdx = left[end - 1];
            result[i] = getCount(startIdx, endIdx, str);
        }
        return result;
    }

    private static int getCount(int startIdx, int endIdx, String str) {
        if (startIdx == Integer.MAX_VALUE || endIdx == Integer.MAX_VALUE || startIdx >= endIdx) return 0;
        int count = 0;
        for (int i = startIdx + 1; i < endIdx; i++) {
            count += str.charAt(i) == '*' ? 1 : 0;
        }
        return count;
    }
}

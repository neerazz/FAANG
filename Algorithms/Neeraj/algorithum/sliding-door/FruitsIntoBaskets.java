import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 05, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/Bn2KLlOR0lQ
 */

public class FruitsIntoBaskets {

    public static void main(String[] args) {

    }

    public static int findLength(char[] arr) {
        int count = 0, len = arr.length, p1 = 0, max = 0;
        Map<Character, Integer> bucket = new HashMap<>();
        for (int p2 = 0; p2 < len; p2++) {
            char cur = arr[p2];
            bucket.put(cur, bucket.getOrDefault(cur, 0) + 1);
            count++;
            while (bucket.size() > 2) {
                cur = arr[p1++];
                int val = bucket.remove(cur);
                if (val > 1) bucket.put(cur, val - 1);
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}

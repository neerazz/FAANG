import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 13, 2021
 * Questions: https://leetcode.com/problems/slowest-key/
 */

public class SlowestKey {

    public static void main(String[] args) {

    }

    public static char slowestKey(int[] times, String keys) {
        int pre = times[0], max = pre;
        char maxChar = keys.charAt(0);
        for (int i = 1; i < times.length; i++) {
            int cur = times[i];
            if (cur - pre > max || (cur - pre == max && keys.charAt(i) > maxChar)) {
                maxChar = keys.charAt(i);
                max = cur - pre;
            }
            pre = cur;
        }
        return maxChar;
    }
}

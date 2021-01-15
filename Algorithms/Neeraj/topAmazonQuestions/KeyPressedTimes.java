import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 15, 2021
 * Questions: https://aonecode.com/aplusplus/interviewctrl/getInterview/8960002076
 */

public class KeyPressedTimes {

    public static void main(String[] args) {
        System.out.println(keyPressedTimes(new int[][]{{0, 1}, {3, 4}, {0, 8}, {2, 11}}));
    }

    private static char keyPressedTimes(int[][] times) {
        int key = -1, max = 0, pre = 0;
        for (int[] time : times) {
            int cur = time[1];
            if (cur - pre > max || (cur - pre == max && time[0] < key)) {
                key = time[0];
                max = cur - pre;
            }
            pre = cur;
        }
        return (char) ('a' + key);
    }
}

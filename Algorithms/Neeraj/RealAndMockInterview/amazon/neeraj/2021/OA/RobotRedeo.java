import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 10, 2021
 * Questions: https://leetcode.com/problems/robot-bounded-in-circle/
 */

public class RobotRedeo {

    public static void main(String[] args) {

    }

    public static boolean isRobotBounded(String instructions) {
        int dir = 0; // 0-N, 1-E, 2-S, 3-W
        int x = 0, y = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (char cur : instructions.toCharArray()) {
            if (cur == 'G') {
                x += dirs[dir][0];
                y += dirs[dir][1];
            } else if (cur == 'L') {
                dir = (dir + 3) % 4;
            } else if (cur == 'R') {
                dir = (dir + 1) % 4;
            }
        }
        // after one cycle:
        // robot returns into initial position
        // or robot doesn't face north
        return (dir != 0) || (x == 0 && y == 0);
    }
}

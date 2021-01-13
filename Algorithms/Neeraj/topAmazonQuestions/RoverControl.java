import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/discuss/interview-question/985703/Amazon-or-OA-or-Rover-Control
 */

public class RoverControl {

    public static void main(String[] args) {
        System.out.println(roverMove(4, new String[]{"RIGHT", "UP", "DOWN", "LEFT", "DOWN", "DOWN"}));
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int roverMove(int n, String[] directions) {
        int row = 0, col = 0;
        for (String dir : directions) {
            int idx = getDirIdx(dir);
            int nr = row + dirs[idx][0], nc = col + dirs[idx][1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                row = nr;
                col = nc;
            }
        }
        return (row * n) + col;
    }

    private static int getDirIdx(String dir) {
        if (dir.equals("UP")) return 0;
        if (dir.equals("DOWN")) return 1;
        if (dir.equals("LEFT")) return 2;
        return 3;
    }
}

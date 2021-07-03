package biweekly.biweekly37;

import java.util.Arrays;

/**
 * Created on:  Oct 17, 2020
 * Questions:
 */

public class CoordinateWithMaximumNetworkQuality {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(bestCoordinate(new int[][]{{1, 2, 5}, {2, 1, 7}, {3, 1, 9}}, 2)));
//        System.out.println(Arrays.toString(bestCoordinate(new int[][]{{28, 6, 30}, {23, 16, 0}, {21, 42, 22}, {50, 33, 34}, {14, 7, 50}, {40, 31, 4}, {39, 45, 17}, {46, 21, 12}, {45, 36, 45}, {35, 43, 43}, {29, 41, 48}, {22, 27, 5}, {42, 44, 45}, {10, 49, 50}, {47, 43, 26}, {40, 36, 25}, {10, 25, 6}, {27, 30, 30}, {50, 35, 20}, {11, 0, 44}, {34, 29, 28}}, 12)));
        System.out.println(Arrays.toString(bestCoordinate(new int[][]{{3, 46, 2}, {3, 27, 46}, {7, 25, 50}, {32, 39, 3}, {4, 42, 37}, {20, 18, 48}, {13, 16, 23}, {22, 36, 24}, {40, 7, 26}, {16, 21, 1}, {46, 33, 34}, {19, 11, 19}, {31, 22, 41}, {37, 29, 20}, {18, 29, 28}, {36, 0, 45}, {39, 22, 37}, {25, 25, 45}, {0, 31, 15}, {44, 45, 13}, {18, 47, 23}, {47, 19, 26}, {48, 18, 32}}, 44)));
    }

    public static int[] bestCoordinate(int[][] towers, int radius) {
        int len = towers.length, result[] = new int[2];
        double factor = 0;
        for (int i = 0; i < len; i++) {
            int curFactor = 0;
            for (int j = 0; j < len; j++) {
                double dist = getDist(towers[i], towers[j]);
                if (dist <= radius) {
                    curFactor += towers[j][2] / (1 + dist);
                }
            }
            if (curFactor > factor) {
                factor = curFactor;
                result = new int[]{towers[i][0], towers[i][1]};
            } else if (curFactor == factor) {
                if (result[0] > towers[i][0] || (result[0] == towers[i][0] && result[1] > towers[i][1])) {
                    result = new int[]{towers[i][0], towers[i][1]};
                }
            }
            System.out.println(String.format("Factor at %d : %s is : %s", i, Arrays.toString(Arrays.copyOf(towers[i], 2)), String.valueOf(curFactor)));
        }
        System.out.println("factor = " + factor);
        return result;
    }

    private static double getDist(int[] a, int[] b) {
        int x = a[0] - b[0], y = a[1] - b[1];
        return Math.sqrt((x * x) + (y * y));
    }
}

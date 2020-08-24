import java.util.Random;
import java.util.TreeMap;

/**
 * Created on:  Aug 22, 2020
 * Questions: https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
 */
public class RandomPointInNonOverlappingRectangles {
    public static void main(String[] args) {

    }

    static class Solution {
        TreeMap<Integer, Integer> map;
        Random random = new Random();
        Rectangle[] rectangles;
        int sum;

        public Solution(int[][] rects) {
            rectangles = new Rectangle[rects.length];
            map = new TreeMap<>();
            for (int i = 0; i < rects.length; i++) {
                int[] rect = rects[i];
                rectangles[i] = new Rectangle(rect);
                // the right part means the number of points can be picked in this rectangle
                sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
                map.put(sum, i);
            }
        }

        public int[] pick() {
// nextInt(sum) returns a num in [0, sum -1]. After added by 1, it becomes [1, sum]
            int c = map.ceilingKey(random.nextInt(sum) + 1);

            return rectangles[map.get(c)].getRandom(random);
            // return rectangles[random.nextInt(rectangles.length)].getRandom(random);
        }

        class Rectangle {
            int minRow, maxRow;
            int minCol, maxCol;

            Rectangle(int[] vertx) {
                minRow = Math.min(vertx[0], vertx[2]);
                maxRow = Math.max(vertx[0], vertx[2]);
                minCol = Math.min(vertx[1], vertx[3]);
                maxCol = Math.max(vertx[1], vertx[3]);
            }

            public int[] getRandom(Random random) {
                return new int[]{ran(random, minRow, maxRow), ran(random, minCol, maxCol)};
            }

            private int ran(Random random, int min, int max) {
                return random.nextInt((max - min) + 1) + min;
            }
        }
    }
}
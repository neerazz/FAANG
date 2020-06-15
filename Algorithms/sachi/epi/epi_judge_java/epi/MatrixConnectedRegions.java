package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.List;

public class MatrixConnectedRegions {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void flipColor(int x, int y, List<List<Boolean>> image) {
        // TODO - you fill in here.
        boolean toColor = !image.get(x).get(y);
        flipColor(x, y, image, toColor);
    }

    public static void flipColor(int x, int y, List<List<Boolean>> image, boolean toColor) {
        if (x < 0 || y < 0 || x >= image.size() || y >= image.get(x).size() || image.get(x).get(y) == toColor) return;
        image.get(x).set(y, toColor);
        for (int[] dir : dirs) {
            flipColor(x + dir[0], y + dir[1], image, toColor);
        }
    }

    @EpiTest(testDataFile = "painting.tsv")
    public static List<List<Integer>> flipColorWrapper(TimedExecutor executor,
                                                       int x, int y,
                                                       List<List<Integer>> image)
            throws Exception {
        List<List<Boolean>> B = new ArrayList<>();
        for (int i = 0; i < image.size(); i++) {
            B.add(new ArrayList<>());
            for (int j = 0; j < image.get(i).size(); j++) {
                B.get(i).add(image.get(i).get(j) == 1);
            }
        }

        executor.run(() -> flipColor(x, y, B));

        image = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            image.add(new ArrayList<>());
            for (int j = 0; j < B.get(i).size(); j++) {
                image.get(i).add(B.get(i).get(j) ? 1 : 0);
            }
        }

        return image;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "MatrixConnectedRegions.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

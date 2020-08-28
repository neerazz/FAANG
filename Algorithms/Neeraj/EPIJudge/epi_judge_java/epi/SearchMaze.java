package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.*;

public class SearchMaze {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static List<Coordinate> searchMaze(List<List<Color>> maze,
                                              Coordinate s, Coordinate e) {
        Map<Integer, List<Coordinate>> memo = new HashMap<>();
        int rows = maze.size(), cols = rows > 0 ? maze.get(0).size() : 0;
        return helper(maze, s, e, memo, rows, cols);
    }

    private static List<Coordinate> helper(List<List<Color>> maze, Coordinate cur, Coordinate end, Map<Integer, List<Coordinate>> memo, int rows, int cols) {
        if (cur.equals(end)) return Collections.singletonList(end);
        List<Coordinate> curList = new ArrayList<>();
        maze.get(cur.x).set(cur.y, Color.BLACK);
        for (int[] dir : dirs) {
            int newX = cur.x + dir[0], newY = cur.y + dir[1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && maze.get(newX).get(newY).equals(Color.WHITE)) {
                List<Coordinate> next = helper(maze, new Coordinate(newX, newY), end, memo, rows, cols);
                if (!next.isEmpty()) {
                    curList.add(cur);
                    curList.addAll(next);
                    break;
                }
            }
        }
        return curList;
    }

    public static boolean pathElementIsFeasible(List<List<Integer>> maze,
                                                Coordinate prev, Coordinate cur) {
        if (!(0 <= cur.x && cur.x < maze.size() && 0 <= cur.y &&
                cur.y < maze.get(cur.x).size() && maze.get(cur.x).get(cur.y) == 0)) {
            return false;
        }
        return cur.x == prev.x + 1 && cur.y == prev.y ||
                cur.x == prev.x - 1 && cur.y == prev.y ||
                cur.x == prev.x && cur.y == prev.y + 1 ||
                cur.x == prev.x && cur.y == prev.y - 1;
    }

    @EpiTest(testDataFile = "search_maze.tsv")
    public static boolean searchMazeWrapper(List<List<Integer>> maze,
                                            Coordinate s, Coordinate e)
            throws TestFailure {
        List<List<Color>> colored = new ArrayList<>();
        for (List<Integer> col : maze) {
            List<Color> tmp = new ArrayList<>();
            for (Integer i : col) {
                tmp.add(i == 0 ? Color.WHITE : Color.BLACK);
            }
            colored.add(tmp);
        }
        List<Coordinate> path = searchMaze(colored, s, e);
        if (path.isEmpty()) {
            return s.equals(e);
        }

        if (!path.get(0).equals(s) || !path.get(path.size() - 1).equals(e)) {
            throw new TestFailure("Path doesn't lay between start and end points");
        }

        for (int i = 1; i < path.size(); i++) {
            if (!pathElementIsFeasible(maze, path.get(i - 1), path.get(i))) {
                throw new TestFailure("Path contains invalid segments");
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SearchMaze.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }

    public enum Color {WHITE, BLACK}

    @EpiUserType(ctorParams = {int.class, int.class})
    public static class Coordinate {
        public int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }
    }
}

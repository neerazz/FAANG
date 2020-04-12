package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchMaze {
    public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate s, Coordinate e) {
        List<Coordinate> sol = new ArrayList<>();
        dfs(maze, s, e, sol);
        return sol;
    }

    public static boolean dfs(List<List<Color>> maze, Coordinate s, Coordinate e, List<Coordinate> sol) {
        //Base Case
        int x = s.x, y = s.y;
        if (x >= maze.size() || x < 0 || y < 0 || y >= maze.get(x).size()) return false; //Out of Bounds
        if (maze.get(x).get(y) != Color.WHITE) return false;  //Wall
        sol.add(s);     //Valid - Add to path
        maze.get(x).set(y, Color.BLACK);         //Mark current as visited
        if (s.equals(e)) return true; //Reached

        //All 4 directions
        boolean b1 = dfs(maze, new Coordinate(x - 1, y), e, sol)
                || dfs(maze, new Coordinate(x + 1, y), e, sol)
                || dfs(maze, new Coordinate(x, y - 1), e, sol)
                || dfs(maze, new Coordinate(x, y + 1), e, sol);
        if (b1) {
            return true;
        } else {
            sol.remove(sol.size() - 1);
            return false;
        }


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

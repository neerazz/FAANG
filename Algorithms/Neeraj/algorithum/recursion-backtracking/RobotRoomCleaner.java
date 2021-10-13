import java.util.HashSet;
import java.util.Set;

interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean move();

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();
}

/*
https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2794/

Example:
Input:
    room = [
              [1,1,1,1,1,0,1,1],
              [1,1,1,1,1,0,1,1],
              [1,0,1,1,1,1,1,1],
              [0,0,0,1,0,0,0,0],
              [1,1,1,1,1,1,1,1]
            ],
    row = 1,
    col = 3
Explanation:
All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
The robot initially starts at the position of row=1, col=3.
From the top left corner, its position is one row below and three columns right.
Notes:
The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
The robot's initial position will always be in an accessible cell.
The initial direction of the robot will be facing up.
All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
Assume all four edges of the grid are all surrounded by wall.
 */
public class RobotRoomCleaner {
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet();
    Robot robot;

    public static void main(String[] args) {

    }

    static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void cleanRoom_rev1(Robot robot) {
        Set<Integer> visited = new HashSet<>();
        // start with the initial directions.
        dfs(robot, 0, 0, 0, visited);
    }

    static void dfs(Robot robot, int row, int col, int dir, Set<Integer> visited) {
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int ndir = (dir + i) % 4;
            int nr = row + dirs[ndir][0], nc = col + dirs[ndir][1];
            int key = key(nr, nc);
            if (!visited.contains(key) && robot.move()) {
                visited.add(key);
                dfs(robot, nr, nc, ndir, visited);
                back(robot);
            }
            robot.turnLeft();
        }
    }

    static void back(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    static int key(int row, int col) {
        return row * 1_0000 + col;
    }

    public void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void backtrack(int row, int col, int d) {
        visited.add(new Pair(row, col));
        robot.clean();
        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int i = 0; i < 4; ++i) {
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

            if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
                backtrack(newRow, newCol, newD);
                goBack();
            }
            // turn the robot following chosen direction : clockwise
            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }

    static class Pair<T, U> {
        T key;
        U val;

        public Pair(final T key, final U val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || this.getClass() != o.getClass()) return false;

            final Pair<?, ?> pair = (Pair<?, ?>) o;

            if (!this.key.equals(pair.key)) return false;
            return this.val.equals(pair.val);
        }

        @Override
        public int hashCode() {
            int result = this.key.hashCode();
            result = 31 * result + this.val.hashCode();
            return result;
        }
    }
}
package recursion2;

import java.util.HashSet;

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
Given a robot cleaner in a room modeled as a grid.
Each cell in the grid can be empty or blocked.
The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
Design an algorithm to clean the entire room using only the 4 given APIs shown below.
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
    public static void main(String[] args) {
        /*
        Time to write down the algorithm for the backtrack function backtrack(cell = (0, 0), direction = 0).
Mark the cell as visited and clean it up.
Explore 4 directions : up, right, down, and left (the order is important since the idea is always to turn right) :
Check the next cell in the chosen direction :
If it's not visited yet and there is no obtacles :
Move forward.
Explore next cells backtrack(new_cell, new_direction).
Backtrack, i.e. go back to the previous cell.
Turn right because now there is an obstacle (or a virtual obstacle) just in front.
         */
    }

    public static void backtrack(Robot robot, int row, int col, HashSet<String> visited, int dir) {
        String currentHash = row + "->" + col;
        if (visited.contains(currentHash)) return;
        robot.clean();
        visited.add(currentHash);
        for (int n = 0; n < 4; n++) {
            // the robot can to four directions, we use right turn
            if (robot.move()) {
                // can go directly. Find the (x, y) for the next cell based on current direction
                int x = row, y = col;
                switch (dir) {
                    case 0:
                        // go up, reduce i
                        x = row - 1;
                        break;
                    case 90:
                        // go right
                        y = col + 1;
                        break;
                    case 180:
                        // go down
                        x = row + 1;
                        break;
                    case 270:
                        // go left
                        y = col - 1;
                        break;
                    default:
                        break;
                }

                backtrack(robot, x, y, visited, dir);
                // go back to the starting position
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();

            }
            // turn to next direction
            robot.turnRight();
            dir += 90;
            dir %= 360;
        }
    }

    public void cleanRoom(Robot robot) {
        // A number can be added to each visited cell
        // use string to identify the class
        HashSet<String> visited = new HashSet<>();
        int dir = 0;   // 0: up, 90: right, 180: down, 270: left
        backtrack(robot, 0, 0, visited, dir);
    }
}
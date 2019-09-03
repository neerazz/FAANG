/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example:
Given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
  
  //TODO: Go through this sol again
 */
public class WallsAndGates {
  public static void main(String[] args) {
    int[][] matrix = new int[][] { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
        { 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };
    Util.print(matrix);
    wallsAndGates(matrix);
    Util.print(matrix);
  }

  public static void wallsAndGates(int[][] rooms) {
    int m = rooms.length - 1;
    int n = rooms[0].length - 1;
    // Iterate through Matrix
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        // Check if Infinity
        if (rooms[i][j] != 2147483647) {
          continue;
        }
        // Counters on each side
        int a = 2147483647, b = 2147483647, c = 2147483647, d = 2147483647, p = i, q = j;
        // Left
        for (p = i, q = j - 1; q >= 0; q--) {
          if (rooms[p][q] == -1) {
            a = 2147483647;
            break;
          }
          if (rooms[i][j] != 2147483647 && rooms[i][j] > 0) {
            break;
          }
          a = (a == 2147483647) ? 1 : a + 1;
          if (rooms[p][q] == 0) {
            break;
          }
        }

        // Right
        for (p = i, q = j + 1; q <= n; q++) {
          if (rooms[p][q] == -1) {
            b = 2147483647;
            break;
          }
          b = (b == 2147483647) ? 1 : b + 1;
          if (rooms[p][q] == 0) {
            break;
          }
        }

        // Top
        for (p = i - 1, q = j; p >= 0; p--) {
          if (rooms[p][q] == -1) {
            c = 2147483647;
            break;
          }
          c = (c == 2147483647) ? 1 : c + 1;
          if (rooms[p][q] == 0) {
            break;
          }
        }

        // Bottom
        for (p = i + 1, q = j; p <= m; p++) {
          if (rooms[p][q] == -1) {
            d = 2147483647;
            break;
          }
          d = (d == 2147483647) ? 1 : d + 1;
          if (rooms[p][q] == 0) {
            break;
          }
        }
        int min = Math.min(Math.min(Math.min(a, b), c), d);
        rooms[i][j] = min;
      }
    }
  }
}

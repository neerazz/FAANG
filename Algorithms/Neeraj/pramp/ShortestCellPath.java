import java.util.LinkedList;
import java.util.Queue;

class ShortestCellPath{
  public static void main(String[] args) {
    System.out.println(shortestCellPath(new int[][]{{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 1, 1}},0,0,2,0) + " should be [8].");
    System.out.println(shortestCellPath(new int[][]{{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 0, 1}},0,0,2,0) + " should be [-1].");
  }
  static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
    int[][] possibilities = {{1,0},{-1,0},{0,1},{0,-1}};
    int rows = grid.length, cols = rows>0 ? grid[0].length :0 , distance = -1;
    if(cols == 0) return 0;
    // Perform BFS
		Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{sr,sc});
    while(!queue.isEmpty()){
      int size = queue.size();
      distance++;
      for(int i = 0; i < size; i++){
        int[] poll = queue.poll();
        int x = poll[0], y = poll[1];
        // Check if target is reached and then exit.
        if(x == tr && y == tc) return distance;
        for(int[] neighbours : possibilities){
          int newX = x + neighbours[0], newY = y + neighbours[1];
          // Check if the new cordinates are with in the range, also check if the user can walk on it or not.
          if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1){
            // If can walk then add it to queue and set the value to, so that it is not visited again.
            grid[newX][newY] = 0;
            queue.add(new int[]{newX,newY});
          }
        }
      }
    }
    return -1;
	}
}

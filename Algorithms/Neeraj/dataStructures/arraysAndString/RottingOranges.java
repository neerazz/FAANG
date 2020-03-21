import java.util.*;

class RottingOranges{
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.orangesRotting(new int[][]{
      {2,1,1},
      {1,1,0},
      {0,1,1}
    }) + "should be [4]");
  }
  static class Solution {
      public int orangesRotting(int[][] grid) {
          int rows = grid.length, cols = rows >0 ? grid[0].length : 0;
          if(cols ==0) return 0;
          Queue<Integer> queue = new LinkedList<>();
          int time = -1;
  //         Collect all the roten oranges
          for(int row =0 ; row < rows; row++){
              for(int col =0; col < cols ; col++){
                  if(grid[row][col] == 2){
                      queue.add(getHash(row,col));
                  }
              }
          }
  //         Perform a bfs to perform roting its neighbours.
          while(!queue.isEmpty()){
              // System.out.println("queue = " + queue);
              int size = queue.size();
              time++;
              for(int i = 0; i < size; i++){
                  int poll = queue.poll();
                  int[] indices = getIndices(poll);
                  int row = indices[0], col = indices[1];
                  if(isFresh(row+1,col,rows,cols,grid)){
                      grid[row+1][col] = 2;
                      queue.add(getHash(row+1,col));
                  }
                  if(isFresh(row-1,col,rows,cols,grid)){
                      grid[row-1][col] = 2;
                      queue.add(getHash(row-1,col));
                  }
                  if(isFresh(row,col+1,rows,cols,grid)){
                      grid[row][col+1] = 2;
                      queue.add(getHash(row,col+1));
                  }
                  if(isFresh(row,col-1,rows,cols,grid)){
                      grid[row][col-1] = 2;
                      queue.add(getHash(row,col-1));
                  }
              }
          }
  //         Check if any oranges are left fresh
          for(int row =0 ; row < rows; row++){
              for(int col =0; col < cols ; col++){
                  if(grid[row][col] == 1){
                      return -1;
                  }
              }
          }
          return time == -1? 0 : time;
      }
      private int getHash(int row, int col){
          return row *100 + col;
      }
      private int[] getIndices(int hash){
          int row = hash / 100;
          int col = hash % 100;
          return new int[]{row,col};
      }
      private boolean isFresh(int row, int col, int rows, int cols, int[][] grid){
          return row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1;
      }
  }
}

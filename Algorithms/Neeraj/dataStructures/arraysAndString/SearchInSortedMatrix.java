import java.util.*;

class SearchInSortedMatrix{
  public static void main(String[] args) {
    System.out.println(Arrays.toString(searchInSortedMatrix(
    new int[][]{
      {1,4,7,12,15,1000},
      {2,5,19,31,32,1001},
      {3,8,24,33,35,1002},
      {40,41,42,44,45,1003},
      {99,100,103,106,128,1004}
    },44)));
  }
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    int rows = matrix.length, cols = rows>0 ? matrix[0].length : 0;
    if(cols == 0) return new int[]{-1,-1};
    int startingRow = 0;
    for(int col = cols-1; col >=0; col--){
      for(int row = startingRow; row < rows; row++){
        int cur = matrix[row][col];
        if(target == cur){
          return new int[]{row,col};
        }
        if(cur > target){
          startingRow = row;
          break;
        }
      }
    }
    return new int[]{-1,-1};
  }
}

import java.util.Arrays;

class ToeplitzMatrix{

    static boolean isToeplitz(int[][] arr) {
      System.out.println(Arrays.deepToString(arr));
      int rows = arr.length;
      int cols = rows>0? arr[0].length: 0;
      //Returning true when empty array.
      if(cols == 0) return true;

      // This is to travel the upper matrix
      System.out.println("Upper traingle");
      for(int l = 0; l < cols-1; l++){
        int val = arr[0][l];
        int col = l;
        for(int row =0; row+l < rows && col < cols; row++){
          // System.out.println("row =" + row + " col=" + col + " \t val =" + val);
          if(arr[row][col++] != val){
            return false;
          }
        }
      }
      System.out.println("Lower traingle");
      // Int this is to travle the lower matrix.
      for (int l = 1; l< rows-1; l++ ) {
        int val = arr[l][0];
        int col = 0;
        for (int row = l; row < rows && col < cols ;row++ ) {
          // System.out.println("row =" + row + " col=" + col + " \t val =" + val);
          if(arr[row][col++] != val){
            return false;
          }
        }
      }
      return true;
  }

  public static void main(String[] args) {
    System.out.println(isToeplitz(new int[][]{{1,2,3,4},{5,1,2,3},{6,5,1,2}}) + " ans should be [true]");
    System.out.println(isToeplitz(new int[][]{{1,2,3,4},{5,1,2,3},{6,4,1,2}}) + " ans should be [false]");
    System.out.println(isToeplitz(new int[][]{{3,9},{5,3},{6,5}}) + " ans should be [true]");
    System.out.println(isToeplitz(new int[][]{{6,4,4}}) + " ans should be [true]");
    System.out.println("*********************************");
    System.out.println("isToeplitz2");
    System.out.println("*********************************");
//    System.out.println(isToeplitz2(new int[][]{{1,2,3,4},{5,1,2,3},{6,5,1,2}}) + " ans should be [true]");
//    System.out.println(isToeplitz2(new int[][]{{1,2,3,4},{5,1,2,3},{6,4,1,2}}) + " ans should be [false]");
//    System.out.println(isToeplitz2(new int[][]{{3,9},{5,3},{6,5}}) + " ans should be [true]");
//    System.out.println(isToeplitz2(new int[][]{{6,4,4}}) + " ans should be [true]");
  }
}

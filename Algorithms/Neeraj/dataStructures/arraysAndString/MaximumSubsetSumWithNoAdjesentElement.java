import java.util.*;

class MaximumSubsetSumWithNoAdjesentElement{
  public static void main(String[] args) {

  }
  public static int maxSubsetSumNoAdjacent(int[] array) {
    if(array.length == 0) return 0;
    int len = array.length;
    int[] op = new int[len];
    for (int i = 0; i < len ; i++ ) {
      int cur = array[i];
      if(i >= 2) {
        // Take the value present at the left side sum.
        cur += sum[i-2];
      }
      sum[i] = Math.max(cur, sum[i-1]);
    }
    return op[array.length-1];
  }
}

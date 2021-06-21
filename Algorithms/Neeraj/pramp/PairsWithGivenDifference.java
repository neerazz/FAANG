import java.util.*;

class Solution {

  static int[][] findPairsWithGivenDifference(int[] arr, int k) {
    Set<Integer> set = new HashSet<>();
    List<int[]> output = new ArrayList<>();
    for(int i =0; i < arr.length; i++){
      set.add(arr[i]);
    }
    for(int i =0; i < arr.length; i++){
      int dif = k + arr[i];
      if(set.contains(dif)){
        output.add(new int[]{dif,arr[i]});
      }
    }
    int[][] conv = new int[output.size()][2];
    for(int i =0; i < output.size(); i++){
      conv[i][0] = output.get(i)[0];
      conv[i][1] = output.get(i)[1];
    }
    return conv;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(findPairsWithGivenDifference(new int[]{0,-1,-2,2,1},1)));
  }
}

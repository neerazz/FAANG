import java.util.*;

class Merging2Packages{
  static int[] getIndicesOfItemWeights(int[] arr, int limit) {
    if(arr == null || arr.length == 0) return new int[0];
    // arr = [4, 4, 6, 10, 15, 16],  lim = 21, len = 5
    // map = {4:[0,1]},{6,[2]},{10,[3]},{15,[4]},{16,[5]}
    Map<Integer, Integer> map = new HashMap<>();
    int len = arr.length;
    for(int i = 0; i < len ; i ++){
      int cur = arr[i], rem = limit - cur;
      if(map.containsKey(rem)){
        int val = map.get(rem);
        return val > i ? new int[]{val,i} : new int[]{i,val};
      }
      map.put(cur,i);
    }
    // map = {4:[0,1]},{6,[2]},{10,[3]},{15,[4]},{16,[5]}
    // rem = 21-6 = 15
    /*
    for(int i = 0; i < len ; i ++){
      int rem = limit - arr[i];
      if(map.containsKey(rem)){
        Set<Integer> values = map.get(rem);
        for(int val : values){
          // val =4, i =2
          if(val != i){
            return val > i ? new int[]{val,i} : new int[]{i,val};
          }
        }
      }
    }
    */
    return new int[0];
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(getIndicesOfItemWeights(new int[]{4, 6, 10, 15, 16},21)));
  }
}

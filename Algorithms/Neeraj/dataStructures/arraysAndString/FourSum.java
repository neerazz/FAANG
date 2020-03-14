import java.util.*;

class FourSum{
  public static void main(String[] args) {
    fourNumberSum(new int[]{7,6,4,-1,1,2},16).forEach(val -> System.out.println(Arrays.toString(val)));
  }
  public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
    Map<Integer,List<int[]>> map = new HashMap<>();
    List<Integer[]> output = new ArrayList<>();
    int len = array.length;
    // First loop through all the values with two sum, and store it inot a map.
    for(int i = 0; i < len ; i ++){
      // Loop through the second half of the array, and add to output when found.
      for(int j =i+1; j < len ; j++){
        int remaining = targetSum - array[i] - array[j];
        if(map.containsKey(remaining)){
          List<int[]> value = map.get(remaining);
          for(int[] temp : value){
            //Check if the current list values are already in the oputput set.
            int k = temp[0], l = temp[1];
            if(i != k && i != l){
              output.add(new Integer[]{array[k], array[l], array[i],array[j]});
            }
          }
        }
      }
      for(int j =0; j < i ; j++){
        int curSum = array[j] + array[i];
        int[] pair = new int[]{j,i};
        List<int[]> value = map.getOrDefault(curSum, new ArrayList<>());
        value.add(pair);
        map.put(curSum, value);
      }
    }
    // System.out.println(map);
    return output;
  }
}

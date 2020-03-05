import java.util.*;

class ThreeSum{
  public static void main(String[] args) {
    threeNumberSum(new int[]{12,3,1,2,-6,5,-8,6},0).forEach(array -> System.out.println(Arrays.toString(array)));
    System.out.println("**********************************");
    threeNumberSum(new int[]{12,3,1,2,-6,5,0,-8,-1,6},0).forEach(array -> System.out.println(Arrays.toString(array)));
  }
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    List<Integer[]> op = new ArrayList<>();
    if(array.length < 3) return op;
    Set<List<Integer>> set = new HashSet<>();
    for(int i = 0; i < array.length; i++){
      Set<Integer> inner = new HashSet<>();
      for(int j = i+1; j < array.length; j++){
        int rem = targetSum - array[i] - array[j];
        if(inner.contains(rem)){
          List<Integer> innerResult = Arrays.asList(array[i],array[j],rem);
          Collections.sort(innerResult);
          set.add(innerResult);
        }
        inner.add(array[j]);
      }
    }
    for(List<Integer> temp : set){
      op.add(new Integer[]{temp.get(0),temp.get(1),temp.get(2)});
    }
    return op;
  }
}

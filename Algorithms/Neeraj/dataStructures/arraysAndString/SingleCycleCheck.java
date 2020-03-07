import java.util.*;

class SingleCycleCheck{
  public static void main(String[] args) {
    System.out.println(hasSingleCycle(new int[]{2,3,1,-4,-4,2}));
    System.out.println(hasSingleCycle(new int[]{1,2,3,4,-2,3,7,8,-26}));
  }
  public static boolean hasSingleCycle(int[] array) {
    int len = array.length;
    if(len == 0) return true;
    for(int i = 0; i < len ; i++){
      if(!startingAtNCompleteCycle(array,i)){
        return false;
      }
    }
    return true;
  }
  private static boolean startingAtNCompleteCycle(int[] nums , int index){
    // System.out.println(Arrays.toString(nums) + " starting from index :" + index);
    Set<Integer> indexes = new HashSet<>();
    int p1 = index, size = nums.length;
    while(!indexes.contains(p1)){
      // System.out.println("p1 : " + p1);
      indexes.add(p1);
      // Calculate the next pointer.
      int newPoint = (p1 + nums[p1] ) % size;
      if(newPoint < 0){
        p1 = size + newPoint;
      }else{
        p1 = newPoint;
      }
    }
    if(indexes.size() == size && p1 == index) return true;
    return false;
  }
}

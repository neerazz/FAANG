import java.util.*;

class ProductSum{
  public static void main(String[] args) {
    System.out.println(productSum(Arrays.asList(5,2,Arrays.asList(7,-1),3,Arrays.asList(6,Arrays.asList(-13,8),4))));
  }
  public static int productSum(List<Object> array) {
    return helper(array,1);
  }
  private static int helper(List<Object> array, int level){
    int sum =0;
    for(Object obj : array){
      if(obj instanceof List){
        // Then make a recursive call.
        sum += helper((List<Object>)obj,level+1);
      }else{
        sum += (int) obj;
      }
    }
    return sum * level;
  }
}

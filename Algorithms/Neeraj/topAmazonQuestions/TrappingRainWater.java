import java.util.*;

public class TrappingRainWater{
  public static void main(String[] args) {
    System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}) + " should be [6]");
    System.out.println(trap(new int[]{4,2,3}) + " should be [1]");
  }
  public static int trap(int[] height) {
    int start = 0, end = height.length-1;
    int collect = 0, lMax = 0, rMax = 0;
    while(start < end){
      int i = height[start], j = height[end];
      if(i < j){
        collect += lMax > i ? lMax-i : 0;
        lMax = Math.max(lMax,i);
        start++;
      }else{
        collect += rMax > j ? rMax-j : 0;
        rMax = Math.max(rMax,j);
        end--;
      }
    }
    return collect;
  }
}

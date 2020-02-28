import java.util.*;

public class ContainerWithMostWater{
  public static void main(String[] args) {
    System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    System.out.println(maxArea_elegent(new int[]{1,8,6,2,5,4,8,3,7}));
  }

  public static int maxArea(int[] height) {
    int size = height.length;
    if(size < 2) return 0;
    int maxArea = 0;
    for(int i = 0 ; i<size;i++){
      for(int j = i+1 ; j<size;j++){
        int currentArea = Math.min(height[i], height[j]) * (j-i);
        maxArea = Math.max(currentArea, maxArea);
      }
    }
    return maxArea;
  }

  public static int maxArea_elegent(int[] height) {
    int size = height.length;
    if(size < 2) return 0;
    int maxArea = 0, left = 0, right = size-1;
    while(left < right){
      int currentArea = Math.min(height[left], height[right]) * (right-left);
      maxArea = Math.max(currentArea, maxArea);
      if(height[left] < height[right]){
        left++;
      }else{
        right--;
      }
    }
    return maxArea;
  }
}

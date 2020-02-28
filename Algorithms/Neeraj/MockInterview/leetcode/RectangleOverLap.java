import java.util.*;

public class RectangleOverLap{
  public static void main(String[] args) {
    System.out.println(isRectangleOverlap(new int[]{0,0,2,2},new int[]{1,1,3,3}));
    System.out.println(isRectangleOverlap(new int[]{0,0,1,1},new int[]{1,0,2,1}));
  }
  public static  boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    // Calculate the area and and make sure that rec1 is smaller.
    if(rec2[0] > rec1[0] && rec2[0] < rec1[2]){
      return true;
    }
    return false;
  }
}

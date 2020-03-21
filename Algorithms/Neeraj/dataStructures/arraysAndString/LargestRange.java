import java.util.*;

class LargestRange{
  public static void main(String[] args) {
    System.out.println(Arrays.toString(largestRange(new int[]{1})));
    System.out.println(Arrays.toString(largestRange(new int[]{8,4,2,10,3,6,7,9,1})));
    System.out.println(Arrays.toString(largestRange(new int[]{1,11,3,0,15,5,2,4,10,7,12,6})));
  }
  public static int[] largestRange(int[] array) {
    int[] output = new int[2];
    if(array == null || array.length == 0) return output;
    Arrays.sort(array);
    // Then find all the continues integers and store it into list.
    int maxDiff = 0;
    // 1,2,3,4,6,7,8,9,10
    int start = array[0], end = start;
    for (int i = 1; i < array.length; i++) {
        int cur = array[i];
        if(end+1 != cur && end != cur){
            int diff = end - start;
            if(maxDiff < diff){
                output[0] = start;
                output[1] = end;
                maxDiff = diff;
            }
            start = cur;
        }
        end = cur;
    }
    if(maxDiff == 0 || maxDiff < end -start){
        output[0] = start;
        output[1] = end;
    }
    return output;
  }
}

import java.util.*;

class SubArraySort{
  public static void main(String[] args) {
    System.out.println(Arrays.toString(subarraySort(new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19})));
  }
  public static int[] subarraySort(int[] array) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
  // 		Find the lowest and highest incorrect ordered value in the array.
    int len = array.length;
    for (int i=0; i < len ; i++) {
      int cur = array[i];
      if(i ==0){
        // Then check only with right side value.
        if(cur > array[i+1]){
          min = Math.min(cur,min);
          max = Math.max(cur,max);
        }
      }else if(i == len -1){
        // Then check only with left side value.
        if(cur < array[i-1]){
          min = Math.min(cur,min);
          max = Math.max(cur,max);
        }
      }else{
        // Check with both the sides of values.
        if(cur > array[i+1] || cur < array[i-1]){
          min = Math.min(cur,min);
          max = Math.max(cur,max);
        }
      }
    }
    if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE){
      return new int[]{-1,-1};
    }
    int[] op = new int[2];
    op[0] = findIndex(min,array);
    op[1] = findIndex(max,array);
    return op;
  }
  private static int findIndex(int val, int[] arr){
    System.out.println("val =" + val + " array=" + Arrays.toString(arr));
    int pre =0;
    for(int i =0 ; i < arr.length; i++){
      if(val < arr[i]){
        return pre;
      }else{
        pre =i;
      }
    }
    return -1;
  }
}

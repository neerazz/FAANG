import java.util.*;

class MinReward{
  public static void main(String[] args) {
    System.out.println(minRewards(new int[]{8,4,2,1,3,6,7,9,5}));
    // 8,4,2,1,3,6,7,9,5
    // 1 1 1 1 2 3 4 5 1 -> left
    // 4 3 2 1 1 1 1 2 1 -> right
    // 4 3 2 1 2 3 4 5 1 -> result
    System.out.println(minRewards(new int[]{5,10}));
  }
  public static int minRewards(int[] scores) {
		int len = scores.length;
		int[] left = new int[len];
		int[] right= new int[len];
		left[0] =1;
		for(int i =1; i < len ; i++){
// 			If teh value is greater then the left
			if(scores[i-1] < scores[i]){
				left[i] = left[i-1] +1;
			}else{
				left[i] = 1;
			}
		}
		right[len-1] = 1;
		for(int i = len-2; i >= 0 ; i--){
// 			If the value is greater than the value at right
			if(scores[i] > scores[i+1]){
				right[i] = right[i+1] +1;
			}else{
				right[i] = 1;
			}
		}
    System.out.println("left =" + Arrays.toString(left));
    System.out.println("right =" + Arrays.toString(right));
		int result = 0;
		for(int i =0; i < len; i++){
      int cur = Math.max(left[i],right[i]);
      System.out.print(cur + " ");
			result += cur;
		}
    return result;
  }
}

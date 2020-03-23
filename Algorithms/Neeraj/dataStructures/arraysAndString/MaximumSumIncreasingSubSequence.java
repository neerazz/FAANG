import java.util.*;

class MaximumSumIncreasingSubSequence{
  public static void main(String[] args) {
    System.out.println("********************************************");
    System.out.println(maxSumIncreasingSubsequence(new int[]{10,70,20,30,50,11,30}));
    System.out.println("********************************************");
    System.out.println(maxSumIncreasingSubsequence(new int[]{-1,1}));
    System.out.println("********************************************");
    System.out.println(maxSumIncreasingSubsequence(new int[]{1}));
    System.out.println("********************************************");
    System.out.println(maxSumIncreasingSubsequence(new int[]{5,4,3,2,1}));
  }
  public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
    if(array == null || array.length == 0) return new ArrayList<>();
    int maxSum = array[0], maxIndex =0, len = array.length;
    int[] sum = new int[len];
    int[] preIdxs = new int[len];
    Arrays.fill(preIdxs,Integer.MIN_VALUE);
    for(int i = 0; i < len ; i++){
      int cur = array[i];
      sum[i] = cur;
      for(int j =0; j < i; j++){
        int pre = array[j];
        if(pre < cur){
          // Check if the combination of the current and prevois is more or only cur is more.
          if(sum[j]+cur > sum[i]){
            // If the combination is more then reassign the sum and preIndex.
            preIdxs[i] = j;
            sum[i] = sum[j]+cur;
          }
          // Get the maximum
          if(maxSum < sum[i]){
            maxSum = sum[i];
            maxIndex = i;
          }
        }
      }
    }
    // Create the subsequence list
    LinkedList<Integer> list = new LinkedList<>();
    list.add(array[maxIndex]);
    while(true){
      maxIndex = preIdxs[maxIndex];
      if(maxIndex != Integer.MIN_VALUE){
        list.addFirst(array[maxIndex]);
      }else{
        break;
      }
    }
    // System.out.println(Arrays.toString(array));
    // System.out.println(Arrays.toString(sum));
    // System.out.println("list =" + list);
    // System.out.println(Arrays.toString(preIdxs));
    return Arrays.asList(Arrays.asList(maxSum),list);
  }
  public static List<List<Integer>> maxSumIncreasingSubsequence_invalidForNegative(int[] array) {
    int max = Integer.MIN_VALUE, sum =0;
    List<Integer> list = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    for(int cur : array){
      int pre = stack.isEmpty() ? Integer.MIN_VALUE : stack.peek();
      // Keep collecting the values into stack till the increasing order is maintained.
      if(cur < pre){
        // If the current sum can form max sum, then assign the stack value to list.
        if(sum > max){
          max = sum;
          list = new ArrayList<>(stack);
        }
        // Keep poping till stack gets a value less then the cur value.
        while(!stack.isEmpty() && stack.peek() >= cur){
          sum -= stack.pop();
        }
      }
      if(cur > sum){
        stack.clear();
        sum = 0;
      }
      stack.add(cur);
      sum+= cur;
    }
    if(sum > max){
      max = sum;
      list = new ArrayList<>(stack);
    }
    return Arrays.asList(Arrays.asList(max),list);
  }
}

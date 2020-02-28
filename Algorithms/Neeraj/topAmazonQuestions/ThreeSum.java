import java.util.*;

public class ThreeSum{
  public static void main(String[] args) {
    // System.out.println(threeSum_elegent(new int[]{-1, 0, 1, 2, -1, -4}));
    System.out.println(threeSumClosest(new int[]{-1, 1, 2, -4},1));
  }

  public static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int sum = Integer.MAX_VALUE;
    int diff = Integer.MAX_VALUE;
    for(int i = 0; i < nums.length-2;i++) {
      int left = i+1;
      int right = nums.length-1;
        while(left < right) {
           int tempSum = nums[i]+nums[left] + nums[right];
           int tempDiff = Math.abs(tempSum-target);
             if(tempDiff < diff) {
               sum = tempSum;
               diff = tempDiff;
             }
             if(tempSum > target) right--;
             else if(tempSum < target) left++;
             else {
               return target;
             }
        }
    }
    return sum;
    // int len = nums.length, dif = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
    // if(len < 1) return -1;
    // Arrays.sort(nums);
    // for(int i = 0; i < len-2 ; i++){
    //   int j = i+1, k = len-1;
    //   while(j < k){
    //     int curSum = nums[i] + nums[j] + nums[k];
    //     int curDif = Math.abs(target-curSum);
    //     // Update the result & difference value when the difference is less then the previous difference.
    //     if(curDif < dif){
    //       dif = curDif;
    //       result = curSum;
    //     }
    //     // Travel towards your right, if the curSum is greater then target.
    //     if(curSum > target){
    //       k--;
    //     }else if(curSum < target){
    //       j++;
    //     }else{
    //       // This is when the target is same as curent sum.
    //       return target;
    //     }
    //   }
    // }
    // return dif;
  }

  public static List<List<Integer>> threeSum_elegent(int[] nums) {
    HashSet<List<Integer>> set = new HashSet<>();
    Arrays.sort(nums);
    int len = nums.length;
    for (int i =0; i < len ; i++ ) {
      HashSet<Integer> set2 = new HashSet<>();
      for(int j = i+1; j < len ; j++){
        if(set2.contains(0-nums[i]-nums[j])){
          set.add(Arrays.asList(new Integer[]{nums[i],nums[j],0-nums[i]-nums[j]}));
        }
        set2.add(nums[j]);
      }
    }
    return new ArrayList<>(set);
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> op = new ArrayList<>();
    int len = nums.length;
    if(len == 0) return op;
    Map<Integer, List<Integer>> map = new HashMap<>();
    // Assign all the values into the map.
    for(int i =0; i < len ; i++){
      List<Integer> indx = map.getOrDefault(nums[i],new ArrayList<>());
      indx.add(i);
      map.put(nums[i], indx);
    }
    System.out.println("Map value after setting : " + map);
    for(int i =0; i < len ; i++){
      int cur = nums[i];
      List<Integer> indx = map.get(cur);
      // If the value has multiple occurences, then delete the current occurence.
      if(indx.size() > 1){
        indx.remove((Integer) i);
        map.put(cur, indx);
      }else{
        map.remove(cur);
      }
      // Then pass the map and the current value and perform two sum.
      List<List<Integer>> result = twoSum(map,0-cur,i,nums);
      for(List<Integer> list: result){
        op.add(list);
      }
    }
    return op;
  }
  private static List<List<Integer>> twoSum(Map<Integer, List<Integer>> input, int target, int curIndex, int[] nums){
    System.out.println("Map value in twoSum : " + input + " target=" + target);
    List<List<Integer>> output = new ArrayList<>();
    Map<Integer, List<Integer>> map = input;
    for(int i = 0 ; i<nums.length; i++){
      if(i != curIndex){
        int cur = nums[i];
        int rem = target - cur;
        System.out.println("Map:" + input + " rem : " + rem + " i =" + i);
        if(map.containsKey(rem)){
          System.out.println(" Entered contains");
          List<Integer> indx = map.get(cur);
          if(indx != null && indx.size() > 0){
            if(indx.contains(i)) { indx.remove((Integer) i);}
            if(indx.size() > 0){
              int thirdIndx = indx.get(0);
              System.out.println("Adding to output : " + Arrays.asList(nums[curIndex],nums[i],nums[thirdIndx]));
              output.add(Arrays.asList(nums[curIndex],nums[i],nums[thirdIndx]));
              indx.remove(0);
            }
            map.put(cur,indx);
          }
        }
      }
    }
    System.out.println("Map value at end of twoSum : " + input + " output = " + output);
    return output;
  }
}

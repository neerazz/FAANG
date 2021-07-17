package topQuestions.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum{
	public static void main(String[] args){

	}

	 public int[] twoSum(int[] nums, int target) {
        //Linear space, time
        Map<Integer, Integer> cache = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if(cache.containsKey(target-nums[i])){
                return new int[]{i, cache.get(target-nums[i])};
            }else{
                cache.put(nums[i], i);
            }
        }
        return null;
    }
}
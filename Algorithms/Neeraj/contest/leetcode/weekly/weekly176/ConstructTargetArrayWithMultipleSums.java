package weekly.weekly176;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {
    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{9,3,5}));
    }

    public static boolean isPossible_pass(int[] target) {
        long sum = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> {return (int)(b - a);});
        for(int i = 0; i < target.length; i++){
            sum += target[i];
            pq.offer((long)target[i]);
        }
        while(!pq.isEmpty()){
            long now = pq.poll();
            // if there is no number bigger than 1 early exit true
            if (now == 1){
                return true;
            }
            // check if current max can be subtract multiple times by other elements' sum.
            long diff = sum - now;
            long times = now / diff;

            // check if current max can be subtract at least once by other elements' sum.
            // this also ensures that no number less than 1 will be added to the priority queue.
            if (times < 1){
                return false;
            }

            // update value.
            sum = sum - times * diff;
            now = now % diff;
            pq.offer(now);
        }
        return true;
    }

    public static boolean isPossible(int[] target) {
        int[] myArray = new int[target.length];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < target.length; i++) {
            myArray[i] = 1;
            max = Math.max(max,target[i]);
            min = Math.min(min,target[i]);
        }
        return isPossible(target,myArray,target.length,min,max);
    }

    private static boolean isPossible(int[] target, int[] myArray, int sum, int min, int max) {
        if (sum > max) return false;
        return Arrays.equals(target, myArray);
    }
}

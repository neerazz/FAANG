package contests.weekly176;

import java.util.Arrays;
import java.util.Map;

public class ConstructTargetArrayWithMultipleSums {
    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{9,3,5}));
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
        if (Arrays.equals(target,myArray)) return true;

        return false;
    }
}

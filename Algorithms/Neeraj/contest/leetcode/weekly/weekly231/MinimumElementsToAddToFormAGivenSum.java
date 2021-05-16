package weekly.weekly231;

/**
 * Created on:  Mar 06, 2021
 * Questions:
 */

public class MinimumElementsToAddToFormAGivenSum {

    public static void main(String[] args) {
//        System.out.println(minElements(new int[]{1, -1, 1}, 3, -4));
        System.out.println(minElements(new int[]{-1, 0, 1, 1, 1}, 1, 771843707));
    }

    public static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) sum += num;
        long diff = Math.abs(goal - sum);
        long adds = (diff / limit) + (diff % limit == 0 ? 0 : 1);
        System.out.println("Sum = " + sum + " Goal = " + goal + " Changes " + adds + " diff = " + diff);
        return (int) adds;
    }
}

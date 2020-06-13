import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int sol = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1, newTarget = target - nums[i];
            while (start < end) {
                int currSum = nums[start] + nums[end];
                if (currSum == newTarget) {
                    return 0;
                } else if (newTarget > currSum) {
                    start++;
                    sol = Math.min(sol, Math.abs(currSum - newTarget));
                } else {
                    end--;
                    sol = Math.min(sol, Math.abs(currSum - newTarget));
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

}

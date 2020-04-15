import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumLC {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> sol = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == target) {
                    sol.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if (sum > target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return new ArrayList<>(sol);
    }

    public static void main(String[] args) {
        ThreeSumLC threeSumLC = new ThreeSumLC();
        System.out.println(threeSumLC.threeSum(new int[]{3, 0, -2, -1, 1, 2}));
    }
}

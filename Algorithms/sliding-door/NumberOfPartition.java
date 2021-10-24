import java.util.*;

/**
 * Created on:  Jul 20, 2021
 * Ref : https://leetcode.com/discuss/interview-question/1349770/google-oa-july-2021-sde-role
 */
public class NumberOfPartition {

    public static void main(String[] args) {
        System.out.println(numberOfPartitions(new int[]{-1, 5, 0, 0, 5, 0}) + " = 3");
    }

    private static int numberOfPartitions(int[] nums) {
        int len = nums.length, sum = 0;
        int[] preSum = new int[len];
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            preSum[i] = sum;
//            Collect all the number and the corresponding start position.
            map.computeIfAbsent(nums[i], val -> new Stack<>()).add(i);
        }
        int count = 0, rightSum = nums[len - 1];
        Set<Integer> rightValues = new HashSet<>();
        rightValues.add(nums[len - 1]);
        for (int i = len - 2; i > 0; i--) {
            int leftSum = preSum[i];
            if (leftSum == rightSum) {
//                Then you dont have to perform any operation.
                count++;
            } else {
                int diff = leftSum - rightSum;
//                leftSum and Right sum matches, in below two cases:
//                  Find if the difference element on the left side of subsequence then you can bring it to zero.
//                  Find if the negative difference on the right sides so that you can bring it to zero.
//                      Ex: diff = 2, and if there is any number on teh right with -2, Then you can make it 0.
                if (hasValueInLeft(map, i, diff) || rightValues.contains(diff * -1)) count++;
            }
            rightSum += nums[i];
            rightValues.add(nums[i]);
        }
        return count;
    }

    private static boolean hasValueInLeft(Map<Integer, Stack<Integer>> map, int idx, int num) {
        Stack<Integer> idxs = map.get(num);
//        There are no any number in the map.
        if (idxs == null) return false;
//        If there is a number in the map but, it at the index greater than the current idx.
//          Then remove all those indexes.
        while (!idxs.isEmpty() && idxs.peek() > idx) idxs.pop();
        return !idxs.isEmpty();
    }
}

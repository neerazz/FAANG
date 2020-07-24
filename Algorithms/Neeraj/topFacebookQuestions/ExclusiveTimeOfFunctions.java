import java.util.List;
import java.util.Stack;

/**
 * Created on:  Jul 22, 2020
 * Questions: https://leetcode.com/problems/exclusive-time-of-functions/
 */
public class ExclusiveTimeOfFunctions {
    public static void main(String[] args) {

    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();
        int cur = 0;
        for (String log : logs) {
            String[] split = log.split(":");
            int function = Integer.parseInt(split[0]), time = Integer.parseInt(split[2]);
            if (split[1].equals("start")) {
                stack.add(new int[]{function, time});
            } else {
                int val = time - stack.pop()[1] + 1;
//                 Update the scope of current function.
                result[function] += val;
//                 reduce cpu time from the top most element.
                if (!stack.isEmpty()) result[stack.peek()[0]] -= val;
            }
        }
        return result;
    }
}

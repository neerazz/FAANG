import java.util.List;
import java.util.Stack;

/**
 * Created on:  Jul 22, 2020
 * Questions: https://leetcode.com/problems/exclusive-time-of-functions/
 */
public class ExclusiveTimeOfFunctions {
    public static void main(String[] args) {

    }

    public static int[] exclusiveTime_rev2(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] times = new int[n];
        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]), time = Integer.parseInt(split[2]);
            if (split[1].equals("start")) {
                if (stack.isEmpty()) {
                    stack.add(new int[]{id, time});
                } else {
                    int[] peek = stack.peek();
                    times[peek[0]] += time - peek[1];
                }
                stack.add(new int[]{id, time});
            } else if (split[1].equals("end")) {
                int[] pop = stack.pop();
                times[pop[0]] += time - pop[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = time + 1;
                }
            }
        }
        return times;
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (String log : logs) {
            String[] split = log.split(":");
            int function = Integer.parseInt(split[0]), time = Integer.parseInt(split[2]);
            if (split[1].equals("start")) {
                stack.add(new int[]{function, time});
            } else {
//                Add +1 because, when are calculating the difference between points
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

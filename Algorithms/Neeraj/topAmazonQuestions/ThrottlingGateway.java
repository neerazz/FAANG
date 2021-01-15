import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on:  Jan 14, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-throttling-gateway
 * https://leetcode.com/discuss/interview-question/819577/Throttling-Gateway-Hackerrank
 */

public class ThrottlingGateway {

    public static void main(String[] args) {
        System.out.println(reAssignedCount(5, new int[]{1, 1, 1, 1, 2}) + " = 1");
        System.out.println(reAssignedCount(27, new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11}) + " = 7");
        System.out.println(reAssignedCount(27, new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 9, 9, 10, 10, 11, 11, 11, 11}) + " = 8");

//        System.out.println(droppedRequests(new int[]{1, 1, 1, 1, 2}) + " = 1");
        System.out.println(droppedRequests(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11}) + " = 7");
        System.out.println(droppedRequests(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 9, 9, 10, 10, 11, 11, 11, 11}) + " = 8");
    }

    public static int droppedRequests(int[] requestTimeArr) {
        int dropped = 0;
        for (int i = 0; i < requestTimeArr.length; i++) {
            if (i > 2 && requestTimeArr[i] == requestTimeArr[i - 3]) {
                dropped++;
            } else if (i > 19 && (requestTimeArr[i] - requestTimeArr[i - 20]) < 10) {
                dropped++;
            } else if (i > 59 && (requestTimeArr[i] - requestTimeArr[i - 60]) < 60) {
                dropped++;
            }
        }
        return dropped;
    }

    private static int reAssignedCount(int n, int[] times) {
        int reAssigned = 0, pre = 0, count = 0;
        LinkedList<int[]> list = new LinkedList<>();
//        0: day, 1: count
        for (int cur : times) {
            if (pre != cur) {
//                Get previous counts
                int[] counts = getLastCount(list, pre);
                int canTake = Math.min(Math.min(3, count), Math.min(20 - counts[0], 60 - counts[1]));
                int taken = Math.min(canTake, count);
                reAssigned += count - taken;
                list.add(new int[]{pre, count});
                count = 0;
                pre = cur;
            }
            count++;
        }
        int[] counts = getLastCount(list, pre);
        int canTake = Math.min(Math.min(3, count), Math.min(20 - counts[0], 60 - counts[1]));
        int taken = Math.min(canTake, count);
        reAssigned += count - taken;
        return reAssigned;
    }

    private static int[] getLastCount(LinkedList<int[]> list, int time) {
        int ten = 0, sixty = 0;
        for (int i = list.size() - 1; i >= 0 && !list.isEmpty(); i--) {
            int[] cur = list.get(i);
            if (time - cur[0] < 10) ten += cur[1];
            if (time - cur[0] < 60) sixty += cur[1];
            if (time - cur[0] > 60) list.removeFirst();
        }
        return new int[]{ten, sixty};
    }
}

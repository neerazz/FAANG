import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created on:  Jan 13, 2021
 * Questions: https://leetcode.com/discuss/interview-question/992156/Amazon-or-OA-or-Earliest-Time-To-Complete-Deliveries
 */

public class EarliestTimeToCompleteDeliveries {

    public static void main(String[] args) {
        System.out.println(earliestTime(2, new int[]{8, 10}, new int[]{2, 2, 3, 1, 8, 7, 4, 5}));
    }

    private static int earliestTime(int numOfBuildings, int[] buildingOpenTime, int[] offloadTime) {
        PriorityQueue<Integer> loads = new PriorityQueue<>((v1, v2) -> Integer.compare(v2, v1));
        PriorityQueue<Integer> docks = new PriorityQueue<>((v1, v2) -> Integer.compare(v1, v2));
        Arrays.stream(offloadTime).forEach(loads::add);
        Arrays.stream(buildingOpenTime).forEach(docks::add);
        int max = 0;
        while (!docks.isEmpty()) {
//            Starting time of each building
            int poll = docks.poll();
            for (int i = 0; i < 4 && !loads.isEmpty(); i++) {
//                Unload the 4 loads, and get the max time to finish all the loads to the building.
                max = Math.max(max, poll + loads.poll());
            }
        }
        return max;
    }
}

package weekly.weekly179;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeNeededToInformAllEmployees {
    public static void main(String[] args) {
        System.out.println(numOfMinutes(1, 0, new int[]{-1}, new int[]{0}));
        System.out.println(numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0}));
    }

    static Map<Integer, List<Integer>> reportiees = new HashMap<>();

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //         Manager and indices of reporties.
        for (int i = 0; i < manager.length; i++) {
            reportiees.putIfAbsent(manager[i],new ArrayList<>());
            reportiees.get(manager[i]).add(i);
        }
        return totalTime(headID,informTime);
    }

    private static int totalTime(int headID, int[] informTime) {
        //        Start from the manager and keep adding the respecting for reportiees times.
        int result = 0;
        List<Integer> temp = reportiees.getOrDefault(headID, new ArrayList<>());
        //        Loop through all the reporties and add there times.
        for(int childs: temp){
            int timeAtLevel = totalTime(childs,informTime) + informTime[headID];
            result = Math.max(result, timeAtLevel);
        }
        return result;
    }
}

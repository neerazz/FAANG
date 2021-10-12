import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {
    public static void main(String[] args) {
        System.out.println("********************************** Solution 1 *********************************");
        System.out.println(minRefuelStops_dp(100, 25, new int[][]{{25, 25}, {50, 25}, {75, 25}}) + " = 3");
        System.out.println(minRefuelStops_dp(100, 50, new int[][]{{25, 25}, {50, 50}}) + " = 1");
        System.out.println(minRefuelStops_dp(100, 50, new int[][]{{25, 50}, {50, 25}}) + " = 1");
        System.out.println(minRefuelStops_dp(1000000000, 145267354, new int[][]{{32131797, 142290934}, {86397166, 44642653}, {99237057, 56978680}, {130019011, 99649968}, {154227249, 90514223}, {198652959, 102942413}, {272491487, 108474929}, {282220105, 83721209}, {302284128, 43151624}, {318501736, 107636032}, {359336452, 73807027}, {425903682, 43078334}, {447483572, 53751173}, {469840976, 57311636}, {472584505, 57629539}, {531147470, 106487691}, {611722638, 111485731}, {650472592, 20105771}, {692670691, 141572192}, {747847056, 7972504}, {800899205, 106134661}, {825649709, 136473550}, {880534339, 72135820}, {887048383, 73776979}, {967172408, 58930710}})
                + " = 8");
        System.out.println("********************************** Solution 2 *********************************");
        System.out.println(minRefuelStops(100, 25, new int[][]{{25, 25}, {50, 25}, {75, 25}}) + " = 3");
        System.out.println(minRefuelStops(100, 50, new int[][]{{25, 25}, {50, 50}}) + " = 1");
        System.out.println(minRefuelStops(100, 50, new int[][]{{25, 50}, {50, 25}}) + " = 1");
        System.out.println(minRefuelStops(1000000000, 145267354, new int[][]{{32131797, 142290934}, {86397166, 44642653}, {99237057, 56978680}, {130019011, 99649968}, {154227249, 90514223}, {198652959, 102942413}, {272491487, 108474929}, {282220105, 83721209}, {302284128, 43151624}, {318501736, 107636032}, {359336452, 73807027}, {425903682, 43078334}, {447483572, 53751173}, {469840976, 57311636}, {472584505, 57629539}, {531147470, 106487691}, {611722638, 111485731}, {650472592, 20105771}, {692670691, 141572192}, {747847056, 7972504}, {800899205, 106134661}, {825649709, 136473550}, {880534339, 72135820}, {887048383, 73776979}, {967172408, 58930710}})
                + " = 8");
    }

    public static int minRefuelStops_dp(int target, int startFuel, int[][] stations) {
        Map<String, Integer> dp = new HashMap<>();
        int result = helper(0, startFuel, 0, stations, target, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    static int helper(int dist, int fuelInTank, int idx, int[][] stations, int target, Map<String, Integer> dp) {
//        With the travelled distance and the amount of fuelInTank, if you can reach target then return 0;
        if (target <= dist + fuelInTank) return 0;
        if (idx >= stations.length) return Integer.MAX_VALUE;
//        dp.get(key) -> The amount of stops required to reach the new target from current point, with the fuelInTank. New target = (actual target - traveled sofar)
        String key = idx + " " + fuelInTank + " " + (target - dist);
        int distTraveled = stations[idx][0] - dist;
        int rem = fuelInTank - distTraveled;
//        If you can't reach hear then return INF
        if (rem < 0) return Integer.MAX_VALUE;
//        If this combination was previously explored, then
        if (dp.containsKey(key)) return dp.get(key);
        int next = helper(stations[idx][0], rem + stations[idx][1], idx + 1, stations, target, dp);
        int withStop = next == Integer.MAX_VALUE ? Integer.MAX_VALUE : next + 1;
        int withOutStop = helper(stations[idx][0], rem, idx + 1, stations, target, dp);
        int result = Math.min(withStop, withOutStop);
        dp.put(key, result);
        return result;
    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((f1, f2) -> Integer.compare(f2, f1));
        int stops = 0, totalFuel = startFuel, prev = 0;
        for (int[] station : stations) {
            int location = station[0], capacity = station[1];
            totalFuel -= location - prev;
//            If your totalFuel is empty then you should have filled fuel in previous stations.
            while (!pq.isEmpty() && totalFuel < 0) {
                totalFuel += pq.poll();
                stops++;
            }
//            Even after considering filling fuels at previous stations, the totalFuel is empty then you cant go ahead;
            if (totalFuel < 0) return -1;
            pq.add(capacity);
            prev = location;
        }
//        Reduce the fuel required to travel from the last station to the target.
        totalFuel -= target - prev;
        while (!pq.isEmpty() && totalFuel < 0) {
            totalFuel += pq.poll();
            stops++;
        }
//        Even after filing all the previous tanks, you can't reach target then it's impossible to reach
        if (totalFuel < 0) return -1;
        return stops;
    }
}

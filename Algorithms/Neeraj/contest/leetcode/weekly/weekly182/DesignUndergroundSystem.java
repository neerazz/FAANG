package weekly.weekly182;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem {
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        undergroundSystem.getAverageTime("Paradise", "Cambridge");       // return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 12.0
    }

    static class UndergroundSystem {
        Map<String, int[]> map;
        Map<Integer, Action> started;

        public UndergroundSystem() {
            map = new HashMap<>();
            started = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            started.put(id, new Action(id, t, stationName));
        }

        public void checkOut(int id, String stationName, int t) {
            Action action = started.remove(id);
            String travel = action.station + "->" + stationName;
            int[] ints = map.getOrDefault(travel, new int[]{0, 0});
            ints[0] += t - action.time;
            ints[1]++;
            map.put(travel, ints);
        }

        public double getAverageTime(String startStation, String endStation) {
            String travel = startStation + "->" + endStation;
            int[] ints = map.get(travel);
            return (double) ints[0] / ints[1];
//            double sum =0.0;
//            List<Integer> integers = map.get(travel);
//            for(int i: integers){
//                sum += i;
//            }
//            return sum/integers.size();
        }
    }

    static class Action {
        int id;
        int time;
        String station;

        public Action(int id, int time, String station) {
            this.id = id;
            this.time = time;
            this.station = station;
        }
    }
}

import java.util.*;

class DesignHitCounter{
  public static void main(String[] args) {
    HitCounter hitCounter = new HitCounter();
    hitCounter.hit(1);
    hitCounter.hit(2);
    hitCounter.hit(3);
    System.out.println(hitCounter.getHits(4));
    hitCounter.hit(300);
    System.out.println(hitCounter.getHits(300));
    System.out.println(hitCounter.getHits(301));
  }
}
class HitCounter {

    Map<Integer, Integer> map;
    // HashSet<Integer> set;
    /** Initialize your data structure here. */
    public HitCounter() {
        // set = new HashSet<>();
        map = new HashMap<>();
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        map.put(timestamp,map.getOrDefault(timestamp,0)+1);
        // set.add(timestamp);
        // System.out.println(set);
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int minRange = timestamp -300 + 1;
        // System.out.println("minRange =" + minRange);
        int sum =0;
        for(int i = Math.max(0,minRange); i <= timestamp; i++){
            // if(set.contains(i)){
            if(map.containsKey(i)){
                sum+=map.get(i);
            }
        }
        return sum;
    }
}

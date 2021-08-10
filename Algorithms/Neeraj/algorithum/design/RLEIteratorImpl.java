import java.util.LinkedList;

/**
 * Created on:  Aug 09, 2021
 * Ref : https://leetcode.com/problems/rle-iterator/
 */
public class RLEIteratorImpl {
    public static void main(String[] args) {
        RLEIterator obj = new RLEIterator(new int[]{3, 8, 0, 9, 2, 5});
        obj = new RLEIterator(new int[]{923381016,843,898173122,924,540599925,391,705283400,275,811628709,850,895038968,590,949764874,580,450563107,660,996257840,917,793325084,82});
    }
    static class RLEIterator {
        // 0: val, 1: count
        LinkedList<int[]> queue = new LinkedList<>();
        public RLEIterator(int[] encoding) {
            int len = encoding.length;
            int i=0, j =1;
            while(j < len){
                int times = encoding[i];
                int num = encoding[j];
                i+=2;
                j+=2;
                if(times == 0) continue;
                if(!queue.isEmpty() && queue.getLast()[0] == num){
                    queue.getLast()[1] += times;
                }else{
                    queue.add(new int[]{num, times});
                }
            }
        }

        public int next(int n) {
            int[] last = null;
            while(n > 0 && !queue.isEmpty()){
                if(last == null || last[1] == 0) last = queue.removeFirst();
                int min = Math.min(last[1], n);
                last[1] -= min;
                n -= min;
            }
            if(last != null && last[1] > 0) queue.addFirst(last);
            return n > 0 ? -1 : last[0];
        }
    }
}

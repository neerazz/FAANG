package algorithms.GreedyAlgorithm;

import groovyx.gpars.extra166y.Ops;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString("baaba") + " should be [ababa]");
        System.out.println(reorganizeString("aab") + " should be [aba]");
        System.out.println(reorganizeString("aaab") + " should be []");
    }
    public static String reorganizeString(String S) {
        char[] chars = S.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(char cur: chars){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        PriorityQueue<CharPair> queue = new PriorityQueue<>(map.size(), (c1,c2) -> c2.count == c1.count ? c1.c - c2.c : c2.count - c1.count);
        queue.addAll(map.entrySet().stream().map(e -> new CharPair(e.getKey(),e.getValue())).collect(Collectors.toList()));

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            int outputSize = sb.length();
//            Take the first element off the queue, and add it to the string only when
//            Queue has more items or the top most item count is 1.
            CharPair poll = queue.poll();
            if (!queue.isEmpty() || poll.count == 1){
                sb.append(poll.c);
            }
//            Then take the next item in the next item in the queue.
            CharPair poll2 = null;
            if (!queue.isEmpty()){
                poll2 = queue.poll();
                sb.append(poll2.c);
            }

//            Now insert the poll items if the count is greater than 1.
            if (poll.count > 1){
                --poll.count;
                queue.add(poll);
            }
            if (poll2 != null && poll2.count > 1){
                --poll2.count;
                queue.add(poll2);
            }
            if (sb.length() == outputSize){
//                It is not possible to construct a string.
                return "";
            }
        }
        return sb.toString();
    }
    static class CharPair{
        char c;
        int count;

        public CharPair(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public String toString() {
            return "CharPair{" +
                    "c=" + c +
                    ", count=" + count +
                    '}';
        }
    }
}

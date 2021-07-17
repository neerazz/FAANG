package leetcode.v1.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class HappyStrings {


    static List<String> list = new ArrayList<>();

    public String getHappyString(int n, int k) {

        Queue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        char[] input = new char[]{'a', 'b', 'c'};
        generateString(n, sb, pq, input, k);
        return pq.poll();
    }

    private void generateString(int n, StringBuilder sb, Queue<String> pq, char[] input, int k) {

        if (sb.length() == n) {
            pq.add(sb.toString());
            if (pq.size() > k) {
                pq.poll();
            }
            list.add(sb.toString());
            return;
        }

        for (char c : input) {
            if (sb.length() > 0 && c == sb.charAt(sb.length() - 1)) continue;
            generateString(n, sb.append(c), pq, input, k);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        HappyStrings happyStrings = new HappyStrings();
        happyStrings.getHappyString(3, 2);
        System.out.println(list.toString());
    }

}

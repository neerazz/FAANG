/**
 * Created on:  Nov 14, 2020
 * Questions: https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3530/
 */

public class PoorPigs {

    public static void main(String[] args) {

    }

    /*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3530/discuss/94266/Another-explanation-and-solution
     */
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int tests = minutesToTest / minutesToDie;
        for (int i = 0; i < buckets; i++) {
            double val = Math.pow(tests + 1, i);
            if (val >= buckets) return i;
        }
        return buckets;
    }
}

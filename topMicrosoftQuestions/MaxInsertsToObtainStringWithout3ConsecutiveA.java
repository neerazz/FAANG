/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/discuss/interview-question/398056/
 */

public class MaxInsertsToObtainStringWithout3ConsecutiveA {

    public static void main(String[] args) {
        System.out.println(maxInserts("dog"));
    }

    private static int maxInserts(String s) {
        int len = s.length(), inserts = 0, count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            } else {
                inserts += 2 - count;
                count = 0;
            }
            if (count > 3) return -1;
        }
//        Insert towards the end.
        if (s.charAt(len - 1) != 'a') inserts += 2;
        else inserts += 2 - count;
        return inserts;
    }
}

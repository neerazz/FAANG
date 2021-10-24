/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/discuss/interview-question/786237/
 */

public class MinDeletionsToObtainStringInRightFormat {

    public static void main(String[] args) {
        System.out.println(minDeletion("BAAABAB") + " should be [2]");
        System.out.println(minDeletion("BBABAA") + " should be [3]");
        System.out.println(minDeletion("AABBBB") + " should be [0]");
    }

    private static int minDeletion(String s) {
        int a = 0, len = s.length();
        for (char c : s.toCharArray()) {
            if (c == 'A') a++;
        }
//        Initialize try deleting a's or b's, Take min as we need minimum value.
        int deletions = Math.min(a, len - a), b = 0;
        for (char c : s.toCharArray()) {
            if (c == 'B') {
                deletions = Math.min(deletions, a + b);
                b++;
            } else {
                a--;
            }
        }
        return deletions;
    }
}

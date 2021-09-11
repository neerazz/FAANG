/**
 * Created on:  Oct 12, 2020
 * Questions:
 */

public class BuddyStrings {

    public static void main(String[] args) {

    }

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int len = A.length(), mismatch = 0, diff = 0;
        int[] count = new int[26];
        for (int i = 0; i < len; i++) {
            count[A.charAt(i) - 'a']++;
            if (A.charAt(i) != B.charAt(i)) {
                if (diff == 1) {
                    if (mismatch != B.charAt(i) - A.charAt(i)) return false;
                } else {
                    mismatch = A.charAt(i) - B.charAt(i);
                }
                diff++;
            }
            if (diff > 2) return false;
        }
        if (diff == 0) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 1) return true;
            }
        }
        return diff == 2;
    }
}

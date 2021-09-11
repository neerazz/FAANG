/**
 * Created on:  Jan 22, 2021
 * Questions:
 */

public class DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {

    }

    public static boolean closeStrings(String word1, String word2) {
        int[] c1 = buildCounts(word1), c2 = buildCounts(word2);
        for (int i = 0; i < 26; i++) {
            int v1 = c1[i];
            if (v1 == 0) continue;
            boolean found = false;
//             Find substitute of c1 char in c2.
            for (int j = 0; j < 26; j++) {
                int v2 = c2[j];
                if (v2 == 0) continue;
                if (v1 == v2) {
//                     Now the j char should also be present in first word.
                    if (c1[j] > 0) {
                        found = true;
                        c2[j] -= v1;
                        break;
                    }
                }
            }
            if (!found) return false;
        }
        for (int count : c2) if (count > 0) return false;
        return true;
    }

    private static int[] buildCounts(String str) {
        int[] counts = new int[26];
        for (char c : str.toCharArray()) {
            counts[c - 'a']++;
        }
        return counts;
    }
}

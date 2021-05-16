package weekly.weekly215;

import java.util.*;

/**
 * Created on:  Nov 14, 2020
 * Questions:
 */

public class DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {

    }

    public boolean closeStrings(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        if (l1 != l2) return false;
        int[] c1 = new int[26], c2 = new int[26];
        for (char c : word1.toCharArray()) {
            c1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            c2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
//            If you find a char in one string that is not in the other string means that is invalid.
            if (c1[i] > 0 && c2[i] == 0) return false;
            if (c2[i] > 0 && c1[i] == 0) return false;
        }
//        Each char occurrence should be present.
        Map<Integer, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        for (int occ : c1) m1.put(occ, m1.getOrDefault(occ, 0) + 1);
        for (int occ : c2) m2.put(occ, m2.getOrDefault(occ, 0) + 1);
        for(int key: m1.keySet()){
            if(m2.get(key) == null || m2.get(key) != m1.get(key)) return false;
        }
        for(int key: m2.keySet()){
            if(m1.get(key) == null || m2.get(key) != m1.get(key)) return false;
        }
        return true;
    }
}

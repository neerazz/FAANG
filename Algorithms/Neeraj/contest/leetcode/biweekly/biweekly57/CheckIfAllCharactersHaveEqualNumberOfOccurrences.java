package biweekly.biweekly57;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Jul 24, 2021
 * Ref : https://leetcode.com/contest/biweekly-contest-57/problems/check-if-all-characters-have-equal-number-of-occurrences/
 */
public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {
    public static void main(String[] args) {

    }

    public boolean areOccurrencesEqual(String s) {
        int[] counts = new int[26];
        for(char c: s.toCharArray()){
            counts[c-'a']++;
        }
        Set<Integer> set = new HashSet<>();
        for(int count: counts){
            set.add(count);
        }
        return set.size() <= 2;
    }
}

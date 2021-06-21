package weekly.weekly245;

/**
 * Created on:  Jun 12, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-245/problems/redistribute-characters-to-make-all-strings-equal/
 */

public class RedistributeCharactersToMakeAllStringsEqual {

    public static void main(String[] args) {

    }

    public boolean makeEqual(String[] words) {
        int[] counts = new int[26];
        int len = words.length;
        for(String word: words){
            for(char c: word.toCharArray()){
                counts[c-'a']++;
            }
        }
        for(int count: counts){
            if(count % len != 0) return false;
        }
        return true;
    }
}

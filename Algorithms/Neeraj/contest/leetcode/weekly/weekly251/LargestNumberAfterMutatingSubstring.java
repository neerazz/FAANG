package weekly.weekly251;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Jul 24, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-251/problems/largest-number-after-mutating-substring/
 */
public class LargestNumberAfterMutatingSubstring {
    public static void main(String[] args) {

    }
    public String maximumNumber(String num, int[] change) {
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<10; i++){
            char cur = (char) ('0'+i), changed = (char)('0' +change[i]);
            map.put(cur, changed);
        }
        char[] chars = num.toCharArray();
        int len = num.length();
        for(int i=0; i<len; i++){
            if(chars[i] < map.get(chars[i])){
//                 Found a greater one, start replacing all the one in right that matches.
                int j = i;
                while(j <len && chars[j] <= map.get(chars[j])){
                    chars[j] = map.get(chars[j]);
                    j++;
                }
                return String.valueOf(chars);
            }
        }
        return String.valueOf(chars);
    }
}

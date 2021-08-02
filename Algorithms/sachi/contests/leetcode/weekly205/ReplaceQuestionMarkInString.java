package contests.leetcode.weekly205;

import java.util.HashMap;
import java.util.Map;

public class ReplaceQuestionMarkInString {

    public static void main(String[] args) {

    }

    public String modifyString(String s) {
        int[] indices = new int[26];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<indices.length; i++){
            indices[i] = i;
            map.put(i,i);
        }
        for(char c : s.toCharArray()){

        }
        return null;
    }
}

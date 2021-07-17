package leetcode.v1.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Croaks {

    public static int minNumberOfFrogs(String croakOfFrogs) {

        if (croakOfFrogs == null || croakOfFrogs.length() < 5) return -1;

        List<List<Character>> sol = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 0);
        map.put('r', 1);
        map.put('o', 2);
        map.put('a', 3);
        map.put('k', 4);

        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char curr = croakOfFrogs.charAt(i);
            if (!map.containsKey(curr)) return -1;
            boolean added = false;
            int currPos = map.get(curr);
            for (List<Character> onerow : sol) {
                if (onerow.size() % 5 == currPos) {
                    added = true;
                    onerow.add(curr);
                    break;
                }
            }
            if (!added) {
                List<Character> newRow = new ArrayList<>();
                newRow.add(curr);
                sol.add(newRow);
            }
        }

        int ans = 0;
        for (List<Character> rows : sol) {
            if (rows.size() % 5 == 0) {
                ans++;
            } else {
                return -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minNumberOfFrogs("aa"));
    }
}

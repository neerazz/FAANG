import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowsSubstring {

    public static String minWindow(String s, String t) {
        //Missed base case
        if (s.length() < t.length()) return "";
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        //tData
        int tCount = t.length();
        for (char c : t.toCharArray()) {
            tMap.putIfAbsent(c, 0);
            tMap.put(c, tMap.get(c) + 1);
        }
        //Initialization was wrong for vp1 & vp2;
        int p1 = 0, p2 = 0, validCount = 0, vp1 = -1, vp2 = s.length() - 1;
        while (p2 < s.length()) {
            char c = s.charAt(p2);
            if (tMap.containsKey(c)) { //Found a valid char
                sMap.putIfAbsent(c, 0);
                sMap.put(c, sMap.get(c) + 1);   //Add it to counter Map
                int required = tMap.get(c);
                int actual = sMap.get(c);
                if (actual <= required) {          //Is this an additional char
                    validCount++;
                }
            }
            //Is this a valid window ? If so assign vp1 & vp2
            while (validCount == tCount) {
                //Is new window better than previous window
                if (Math.abs(p1 - p2) < Math.abs(vp1 - vp2)) {
                    //Valid Shorter Window - Assign
                    vp1 = p1;
                    vp2 = p2;
                }
                //Minimize window - Increase P1 till p1 becomes invalid
                char c1 = s.charAt(p1);
                if (sMap.containsKey(c1)) {
                    int required = tMap.get(c1);
                    int actual = sMap.get(c1);
                    if (actual <= required) {
                        validCount--;
                    }
                    if (sMap.get(c1) == 1) {
                        sMap.remove(c1);
                    } else {
                        sMap.put(c1, sMap.get(c1) - 1);
                    }
                }
                //These are to be incremented at the end
                p1++;
            }
            p2++;
        }
        if (vp1 == -1) return "";
        return s.substring(vp1, vp2 + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}

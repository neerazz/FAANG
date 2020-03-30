import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowsSubstring {

    public static String minWindow(String s, String t) {
        if (s.equals(t)) return s;
        int len = t.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        String sol = s;
        boolean updated = false;

        Set<Character> set = new HashSet<>();
        for (int z = 0; z < t.length(); z++) {
            set.add(t.charAt(z));
        }

        for (int j = 0; j < s.length(); j++) {

            char c = s.charAt(j);
            if (!set.contains(c)) continue;

            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() == len && j - i < sol.length()) {
                sol = s.substring(i, j + 1);
                updated = true;
            }

            while (j - i + 1 >= len && map.size() == len) {
                char d = s.charAt(i);
                if (!set.contains(d)) {
                    i++;
                    continue;
                }
                if (j - i < sol.length()) {
                    sol = s.substring(i, j + 1);
                }
                int val = map.get(d);
                if (val == 1) {
                    map.remove(d);
                } else {
                    map.put(d, val - 1);
                }
                i++;
            }
        }

        return updated ? sol : "";

    }

    public static void main(String[] args) {
        System.out.println(minWindow("bbaa", "aba"));
    }
}

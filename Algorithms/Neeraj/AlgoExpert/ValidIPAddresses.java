import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on:  Feb 18, 2021
 * Questions:
 */

public class ValidIPAddresses {

    public static void main(String[] args) {

    }

    private static ArrayList<String> helper(String str, int start, int k, Map<String, ArrayList<String>> memo) {
        String key = "" + start + " " + k;
        ArrayList<String> cur = new ArrayList<>();
        if (k == 0) {
            if (start == str.length()) {
                cur.add("");
            }
            return cur;
        }
        if (start >= str.length()) return cur;
        if (memo.containsKey(key)) return memo.get(key);
        int val = 0;
        String curDigit = "";
        for (int i = start; i < str.length(); i++) {
            curDigit += str.charAt(i);
            val = val * 10 + (str.charAt(i) - '0');
            if (val > 255 || curDigit.length() > 3) break;
            List<String> next = helper(str, i + 1, k - 1, memo);
            for (String poss : next) {
                cur.add(curDigit + (poss.length() == 0 ? "" : "." + poss));
            }
            if (curDigit.length() == 1 && val == 0) break;
        }
        memo.put(key, cur);
        return cur;
    }

    public ArrayList<String> validIPAddresses(String str) {
        if (str == null || str.length() < 4 || str.length() > 12) return new ArrayList<>();
        Map<String, ArrayList<String>> memo = new HashMap<>();
        return helper(str, 0, 4, memo);
    }
}

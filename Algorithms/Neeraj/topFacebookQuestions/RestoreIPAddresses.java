import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on:  Aug 17, 2020
 * Questions: https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {

    private static Set<String> set;

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("1111"));
        System.out.println(restoreIpAddresses("010010"));
        System.out.println(restoreIpAddresses("101023"));
    }

    public static List<String> restoreIpAddresses(String s) {
        set = new HashSet<>();
        int len = s.length();
        if (len < 4 || len > 12) return new ArrayList<>();
        helper(s, 0, 0, "");
        return new ArrayList<>(set);
    }

    private static void helper(String str, int start, int dots, String soFar) {
        if (dots == 4) {
            if (start == str.length()) set.add(soFar.substring(0, soFar.length() - 1));
        } else if (start >= str.length()) return;
        else if (str.charAt(start) == '0') {
            helper(str, start + 1, dots + 1, soFar.length() == 0 ? "0." : soFar + "0.");
        } else {
            int cur = 0;
            for (int i = start; i < str.length(); i++) {
                cur = cur * 10 + (str.charAt(i) - '0');
                if (cur > 255) break;
                helper(str, i + 1, dots + 1, soFar.length() == 0 ? cur + "." : soFar + cur + ".");
            }
        }
    }
}

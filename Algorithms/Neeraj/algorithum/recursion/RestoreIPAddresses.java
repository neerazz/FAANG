import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on:  Jun 01, 2020
 * Questions: https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("1111"));
        System.out.println(restoreIpAddresses("010010"));
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return new ArrayList<>();
        return helper(s, 0, 4);
    }

    private static List<String> helper(String input, int start, int rem) {
        int len = input.length();
        if (rem < 1 || start > len || len - start > 3 * rem) return Collections.emptyList();
        List<String> op = new ArrayList<>();
        if (rem == 1) {
            String cur = input.substring(start, len);
            int curVal = Integer.parseInt(cur);
            if (input.charAt(start) == '0') {
                if (cur.length() == 1) {
                    return Collections.singletonList(cur);
                }
            } else if (curVal > 0 && curVal < 256) {
                return Collections.singletonList(cur);
            }
            return op;
        } else if (input.charAt(start) == '0') {
            List<String> next = helper(input, start + 1, rem - 1);
            for (String val : next) {
                op.add(val.length() > 0 ? "0." + val : "0");
            }
        } else {
            StringBuilder cur = new StringBuilder();
            int curVal = 0;
            for (int end = start; end < Math.min(start + 3, len - rem + 1); end++) {
                cur.append(input.charAt(end));
                curVal = (curVal * 10) + (input.charAt(end) - '0');
                if (curVal > 0 && curVal < 256) {
                    List<String> next = helper(input, end + 1, rem - 1);
                    for (String val : next) {
                        op.add(cur.toString() + "." + val);
                    }
                } else break;
            }
        }
        return op;
    }
}

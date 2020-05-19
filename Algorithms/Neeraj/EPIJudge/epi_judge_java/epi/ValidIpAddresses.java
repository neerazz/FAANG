package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

public class ValidIpAddresses {
    static List<String> op;

    @EpiTest(testDataFile = "valid_ip_addresses.tsv")
    public static List<String> getValidIpAddress(String s) {
        op = new ArrayList<>();
        if (s.length() >= 4 && s.length() <= 12) {
            backtrace(s, 0, 0, "");
        }
        return op;
    }

    private static void backtrace(String s, int start, int dots, String soFar) {
        if (dots == 3) {
            int rem = s.length() - start, val = rem < 4 && rem > 0 ? Integer.parseInt(s.substring(start)) : -1;
            if ((val == 0 && rem == 1) || ((val > 0 && val < 256) && s.charAt(start) != '0')) {
                op.add(soFar + "." + s.substring(start));
            }
        } else if (dots < 3) {
            String cur = "";
            for (int end = start; end < s.length(); end++) {
                cur += s.charAt(end);
                if ((Integer.parseInt(cur) == 0 && cur.length() == 1) || ((Integer.parseInt(cur) > 0 && Integer.parseInt(cur) < 256) && cur.charAt(0) != '0')) {
                    backtrace(s, end + 1, dots + 1, soFar.equals("") ? soFar + cur : soFar + "." + cur);
                }
                if (Integer.parseInt(cur) >= 256 || cur.charAt(0) == '0') break;
            }
        }
    }

    @EpiTestComparator
    public static boolean comp(List<String> expected, List<String> result) {
        if (result == null) {
            return false;
        }
        Collections.sort(expected);
        Collections.sort(result);
        return expected.equals(result);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "ValidIpAddresses.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

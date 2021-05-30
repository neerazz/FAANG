package weekly.weekly243;

/**
 * Created on:  May 30, 2021
 * Questions:
 */

public class MaximumValueAfterInsertion {

    public static void main(String[] args) {
        System.out.println(maxValue("469975787943862651173569913153377", 3) + " = 4699757879438632651173569913153377");
        System.out.println(maxValue("469975787943862651173569913253377", 3) + " = 4699757879438632651173569913153377");
    }

    public static String maxValue(String n, int x) {
        if (n.charAt(0) == '-') {
            return "-" + getMin(n.substring(1), x);
        } else {
            return getMax(n, x);
//            return getMax_naive(n, x);
        }
    }

    private static String getMax(String str, int x) {
        for (int i = 0; i < str.length(); i++) {
            int cur = str.charAt(i) - '0';
            if (cur < x) {
                return str.substring(0, i) + x + str.substring(i);
            }
        }
        return str + x;
    }

    private static String getMin(String str, int x) {
        for (int i = 0; i < str.length(); i++) {
            int cur = str.charAt(i) - '0';
            if (cur > x) {
                return str.substring(0, i) + x + str.substring(i);
            }
        }
        return str + x;
    }

    private static String getMax_naive(String str, int x) {
        String result = str + x;
        for (int i = 0; i < str.length(); i++) {
            String cur = str.substring(0, i) + x + str.substring(i);
            if (result.compareTo(cur) < 0) {
                result = cur;
            }
        }
        return result;
    }

    private static String getMin_naive(String str, int x) {
        String result = str + x;
        for (int i = 0; i < str.length(); i++) {
            String cur = str.substring(0, i) + x + str.substring(i);
            if (result.compareTo(cur) > 0) {
                result = cur;
            }
        }
        return result;
    }
}

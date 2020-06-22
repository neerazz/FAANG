import java.util.regex.Pattern;

/**
 * Created on:  Jun 16, 2020
 * Questions: https://leetcode.com/problems/validate-ip-address
 */
public class ValidateIPAddress {
    private static final String ipv6RegEx = "([0-9a-fA-F]{1,4}:){7}([0-9a-fA-F]){1,4}";
    private static final Pattern ipv6Pattern = Pattern.compile(ipv6RegEx);

    public static void main(String[] args) {
        System.out.println(validIPAddress("192.0.0.1") + " should be [IPv4]");
        System.out.println(validIPAddress("172.16.254.1") + " should be [IPv4]");
        System.out.println(validIPAddress("1.0.1.") + " should be [Neither]");
        System.out.println(validIPAddress("172.16.254.1.") + " should be [Neither]");
        System.out.println(validIPAddress("256.256.256.256") + " should be [Neither]");
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334") + " should be [IPv6]");
    }

    public static String validIPAddress(String IP) {
        if (isIPV4Valid(IP)) {
            return "IPv4";
        } else if (isValidIPV6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private static boolean isValidIPV6(String ipv6) {
        return ipv6Pattern.matcher(ipv6).matches();
    }

    private static boolean isIPV4Valid(String ipv4) {
        int index = 0, dots = 0, values = 0;
        while (index < ipv4.length()) {
            String val = "";
            while (index < ipv4.length() && ipv4.charAt(index) != '.') {
                if (Character.isDigit(ipv4.charAt(index))) {
                    val += ipv4.charAt(index);
                    index++;
                } else {
                    return false;
                }
            }
            if (index < ipv4.length() && ipv4.charAt(index) == '.') {
                dots++;
                index++;
            }
            if (dots > 4 || val.length() == 0) return false;
            if (val.charAt(0) == '0' && val.length() > 1) return false;
            int num = 0;
            for (char c : val.toCharArray()) {
                num = num * 10 + (c - '0');
            }
            if (num > 255 || num < 0) return false;
            else {
                values++;
            }
        }
        return dots == 3 && values == 4;
    }
}

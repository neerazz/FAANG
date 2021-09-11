/**
 * Created on:  Jun 28, 2020
 * Questions: Validate IP Address
 * https://www.pramp.com/challenge/Q5G1jZ1OWdtZ3GbAGpNE
 */
public class ValidateIPAddress {
    static boolean validateIP(String ip) {
        String[] strs = ip.split("\\.", -1);
        if (strs.length != 4) return false;
        for (String str : strs) {
            if (!isValid(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(String str) {
        try {
            int n = Integer.parseInt(str);
            if (n == 0) return str.length() == 1;
            return n > 0 && n < 256;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validateIP("192.168.0.1"));
    }
}

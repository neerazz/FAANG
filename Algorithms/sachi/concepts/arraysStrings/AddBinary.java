package concepts.arraysStrings;

import java.util.Scanner;

public class AddBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(addBinary(a, b));
        System.out.println(addBinaryElegant(a, b));
        scanner.close();
    }

    //TODO - DO this Add binary numbers

    private static String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        int aL = a.length(), bL = b.length();
        int max = a.length() > b.length() ? a.length() : b.length();
        int sum = 0, carry = 0;
        char aC, bC;
        StringBuilder builder = new StringBuilder();
        for (int i = max; i > 0; i--) {
            aL--;
            bL--;
            if (aL >= 0) {
                aC = a.charAt(aL);
            } else {
                aC = '0';
            }
            if (bL >= 0) {
                bC = b.charAt(bL);
            } else {
                bC = '0';
            }
            sum = carry + aC + bC;
            int res = sum % 48;
            if (res == 0) {
                carry = 48;
                sum = 48;
            } else if (res == 1) {
                carry = 48;
                sum = 49;
            } else if (res == 2) {
                carry = 49;
                sum = 48;
            } else if (res == 3) {
                carry = 49;
                sum = 49;
            }
            builder.append((char) sum);
        }
        if (carry == 49) {
            builder.append('1');
        }
        return builder.reverse().toString();
    }

    private static String addBinaryElegant(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0)
                sum += b.charAt(j--) - '0';
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
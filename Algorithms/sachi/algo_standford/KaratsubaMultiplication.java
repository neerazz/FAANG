package algo_standford;

import java.math.BigInteger;
import java.util.Scanner;

public class KaratsubaMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n1 = scanner.nextLine();
        String n2 = scanner.nextLine();
        scanner.close();
        // System.out.println(naiveMutiplication(generateLargeNumber(n1),
        // generateLargeNumber(n2)));
        System.out.println(naiveMutiplication(n1, n2));
    }

    private static String karabtusa(String n1, String n2) {
        if (n1.length() <= 1 && n2.length() <= 1) {
            return String.valueOf(Integer.valueOf(n1) * Integer.valueOf(n2));
        } else {
            // Split and call karabtusa
            BigInteger b1 = new BigInteger(n1);
            BigInteger b2 = new BigInteger(n2);
            long min = 0;
            if (b1.compareTo(b2) > 0) {
                // min is B1
                min = b1.divide(new BigInteger("2")).longValue();
            } else {
                // min is B2
                min = b2.divide(new BigInteger("2")).longValue();
            }

        }
        return "";
    }

    private static String naiveMutiplication(String n1, String n2) {
        System.out.println(n1 + " \n * \n" + n2);
        System.out.println("\n Solutions is: ");
        return new BigInteger(n1).multiply(new BigInteger(n2)).toString();
    }

    private static String generateLargeNumber(int n) {
        return new BigInteger("99").pow(n).toString();
    }
}
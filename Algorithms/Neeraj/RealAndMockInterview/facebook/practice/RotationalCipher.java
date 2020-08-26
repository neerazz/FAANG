package practice;

/**
 * Created on:  Aug 25, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=238827593802550
 */
public class RotationalCipher {
    public static void main(String[] args) {
        System.out.println(rotationalCipher("Zebra-493?", 3).equals("Cheud-726?"));
        System.out.println(rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39).equals("nopqrstuvwxyzABCDEFGHIJKLM9012345678"));
    }

    static String rotationalCipher(String input, int rotationFactor) {
        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            char curRotated = c;
            if (rotationFactor == 0) {
                sb.append(curRotated);
            } else if (Character.isUpperCase(c)) {
                int k = rotationFactor % 26;
                if (c + k > 'Z') {
                    curRotated = (char) ('A' + c + k - 'Z' - 1);
                } else {
                    curRotated = (char) (c + k);
                }
            } else if (Character.isLowerCase(c)) {
                int k = rotationFactor % 26;
                if (c + k > 'z') {
                    curRotated = (char) ('a' + c + k - 'z' - 1);
                } else {
                    curRotated = (char) (c + k);
                }
            } else if (Character.isDigit(c)) {
                int k = rotationFactor % 10;
                if (c + k > '9') {
                    curRotated = (char) ('0' - '9' - 1 + k + c);
                } else {
                    curRotated = (char) (c + k);
                }
            }
            sb.append(curRotated);
        }
        return sb.toString();
    }
}

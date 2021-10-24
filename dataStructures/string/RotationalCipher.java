/**
 * Created on:  Jul 16, 2021
 * Ref: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=238827593802550
 */

public class RotationalCipher {

    public static void main(String[] args) {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
    }

    static String rotationalCipher(String input, int rotationFactor) {
        StringBuilder sb = new StringBuilder();
        for (char cur : input.toCharArray()) {
            if (isDigit(cur)) {
                int digit = cur - '0';
                digit = (digit + rotationFactor) % 10;
                sb.append(digit);
            } else if (isLowerLetter(cur)) {
                int idx = cur - 'a';
                idx = (idx + rotationFactor) % 26;
                sb.append((char) ('a' + idx));
            } else if (isUpperLetter(cur)) {
                int idx = cur - 'A';
                idx = (idx + rotationFactor) % 26;
                sb.append((char) ('A' + idx));
            } else {
                sb.append(cur);
            }
        }
        return sb.toString();
    }

    static boolean isDigit(char c) {
        int dig = c - '0';
        return dig >= 0 && dig <= 9;
    }

    static boolean isLowerLetter(char c) {
        int idx = c - 'a';
        return idx >= 0 && idx < 26;
    }

    static boolean isUpperLetter(char c) {
        int idx = c - 'A';
        return idx >= 0 && idx < 26;
    }

    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }
}

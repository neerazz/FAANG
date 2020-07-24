/**
 * Created on:  Jul 23, 2020
 * Questions: https://leetcode.com/problems/valid-number/
 */
public class ValidNumber {
    public static void main(String[] args) {

    }

    public boolean isNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.trim().toCharArray()) {
            if (Character.isDigit(c) || c == '+' || c == '-' || c == 'e' || c == '.') {
                sb.append(c);
            } else {
                if (sb.length() > 0 && c == ' ') return false;
                else return false;
            }
        }
        try {
            Double.parseDouble(sb.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

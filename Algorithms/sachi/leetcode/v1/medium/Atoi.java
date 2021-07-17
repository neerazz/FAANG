package leetcode.v1.medium;

public class Atoi {

    public int myAtoi(String str) {
        long sol = 0;
        int sign = 0; //1 positive, -1 negative, 0 unset
        boolean foundFirstChar = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!foundFirstChar && (c == '-' || c == '+')) {
                foundFirstChar = true;
                sign = c == '-' ? -1 : 1;
            } else if (Character.isDigit(c)) {
                foundFirstChar = true;
                sol = (sol * 10) + Character.getNumericValue(c);
            } else if (c != ' ' || foundFirstChar) {
                break;
            }
            //Check out of bounds
            long temp = sign == 0 ? sol : sign * sol;
            if (temp >= Integer.MAX_VALUE) {
                sol = Integer.MAX_VALUE;
                break;
            } else if (temp <= Integer.MIN_VALUE) {
                sol = Integer.MIN_VALUE;
                break;
            }
        }
        sol = sign == 0 ? sol : sign * sol;
        return (int) sol;
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        int i = atoi.myAtoi("-91283472332");
        System.out.println(i);
    }

}

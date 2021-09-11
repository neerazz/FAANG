package concepts.arraysStrings;

public class IntToStringStringToInt {

    public static void main(String[] args) {
        System.out.print(stringToInt("-4323"));
    }

    public static int stringToInt(String s) {
        // TODO - you fill in here.
        //Input is "123" make it 123
        if (s == null || s.length() == 0) return 0;
        boolean isNegative = false, extraChar = false;
        int solution = 0;
        int length = s.length() - 1;
        if (s.charAt(0) == '-') {
            length--;
            isNegative = true;
            extraChar = true;
        } else if (s.charAt(0) == '+') {
            length--;
            isNegative = false;
            extraChar = true;
        }
        for (Character c : s.toCharArray()) {
            if (extraChar) {
                extraChar = false;
                continue;
            }
            solution += (c - '0') * (int) Math.pow(10, length--);
        }
        return isNegative ? -solution : solution;
    }
}

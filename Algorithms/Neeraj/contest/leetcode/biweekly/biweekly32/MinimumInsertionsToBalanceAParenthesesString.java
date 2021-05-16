package biweekly.biweekly32;

/**
 * Created on:  Aug 08, 2020
 * Questions:
 */
public class MinimumInsertionsToBalanceAParenthesesString {
    public static void main(String[] args) {
        System.out.println(minInsertions("(()))(()))()())))") + " = 4");
        System.out.println(minInsertions("()()()()()(") + " = 7");
    }

    public static int minInsertions(String s) {
        int start = 0, change = 0;
        char pre = ' ';
        for (char c : s.toCharArray()) {
            if (pre == ')') {
                if (c == ')') start--;
                else {
                    change++;
                    start++;
                }
                pre = ' ';
            } else {
                if (c == '(') {
                    start += 2;
                } else {
                    if (start > 0) start--;
                    else {
                        change++;
                        start++;
                    }
                    pre = ')';
                }
            }
        }
        return start + change;
    }
}

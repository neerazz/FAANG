/**
 * Created on:  Nov 07, 2020
 * Questions:
 * Write a function that reverses characters in (possibly nested) parentheses in the input string.
 * <p>
 * Input strings will always be well-formed with matching ()s.
 * <p>
 * Example
 * <p>
 * For inputString = "(bar)", the output should be
 * reverseInParentheses(inputString) = "rab";
 * For inputString = "foo(bar)baz", the output should be
 * reverseInParentheses(inputString) = "foorabbaz";
 * For inputString = "foo(bar)baz(blim)", the output should be
 * reverseInParentheses(inputString) = "foorabbazmilb";
 * For inputString = "foo(bar(baz))blim", the output should be
 * reverseInParentheses(inputString) = "foobazrabblim".
 * Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim".
 */

public class ReverseChars {

    public static void main(String[] args) {

    }

    static String reverseInParentheses(String inputString) {
        System.out.println(inputString);
        StringBuilder sb = new StringBuilder();
        int i = 0, len = inputString.length();
        while (i < len) {
            if (inputString.charAt(i) == '(') {
                i++;
                int open = 1;
                StringBuilder sb1 = new StringBuilder();
                while (i < len) {
                    if (inputString.charAt(i) == ')') {
                        open--;
                        if (open == 0) {
                            i++;
                            break;
                        } else {
                            sb1.append(')');
                        }
                    } else if (inputString.charAt(i) == '(') {
                        open++;
                        sb1.append('(');
                    } else {
                        sb1.append(inputString.charAt(i));
                    }
                    i++;
                }
                sb.append(new StringBuilder(reverseInParentheses(sb1.toString())).reverse());
            } else {
                sb.append(inputString.charAt(i++));
            }
        }
        return sb.toString();
    }
}

package telephone;

/**
 * Crated on:  Apr 08, 2020
 */
public class BroQ1 {
    public static void main(String[] args) {
        setDisplay('1');
    }

    static int left = 0, right = 0, output = 0;

    private static int setDisplay(char c) {
        if (isOperationSymbol(c)) {
            output = left = performOperation(c);
            right = 0;
        } else if (Character.isDigit(c)) {
            right = (right) * 10 + c;
        }
        return output;
    }

    private static int performOperation(char ope) {
        if (ope == '+') {
            return left + right;
        }
        if (ope == '-') {
            return left + right;
        }
        if (ope == '*') {
            return left * right;
        }
        if (ope == '/') {
            if (right == 0) return 0;
            return left / right;
        }
        return 0;
    }

    private static boolean isOperationSymbol(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '=';
    }
}

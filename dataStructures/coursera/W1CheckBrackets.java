import java.util.Scanner;
import java.util.Stack;

/*
Input Format. Input contains one string 𝑆 which consists of big and small latin letters, digits, punctuation
marks and brackets from the set []{}().
Constraints. The length of 𝑆 is at least 1 and at most 105
.
Output Format. If the code in 𝑆 uses brackets correctly, output “Success" (without the quotes). Otherwise,
output the 1-based index of the first unmatched closing bracket, and if there are no unmatched closing
brackets, output the 1-based index of the first unmatched opening bracket.
Sample 1.
Input:
[]
Output:
Success
Sample 2.
Input:
{}[]
Output:
Success
Sample 3.
Input:
[()]
Output:
Success
Sample 4.
Input:
(())
Output:
Success
Sample 5.
Input:
{[]}()
Output:
Success
Sample 6.
Input:
{
Output:
1
 */
public class W1CheckBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(checkBrackets(input));

//        System.out.println(checkBrackets("[]"));
//        System.out.println(checkBrackets("{}[]"));
//        System.out.println(checkBrackets("[()]"));
//        System.out.println(checkBrackets("(())"));
//        System.out.println(checkBrackets("{[]}()"));
//        System.out.println(checkBrackets("{"));
//        System.out.println(checkBrackets("{[}"));
//        System.out.println(checkBrackets("foo(bar);"));
//        System.out.println(checkBrackets("foo(bar[i);"));
//        System.out.println(checkBrackets("{[}"));
//        System.out.println(checkBrackets("[](()"));
    }

    private static String checkBrackets(String input) {
//        System.out.println("input = " + input);
        if (input.length() < 2) {
            return String.valueOf(input.length());
        }
        char[] chars = input.toCharArray();
        Stack<BracketsAt> stringStack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            String current = String.valueOf(chars[i]);
            if (current.equals("(") || current.equals("[") || current.equals("{")) {
                stringStack.push(new BracketsAt(current, i + 1));
            } else if (current.equals(")") || current.equals("]") || current.equals("}")) {
                if (isValidBracket(current, stringStack)) {
                    stringStack.pop();
                } else {
                    return String.valueOf(i + 1);
                }
            }
        }
        return stringStack.empty() ? "Success" : String.valueOf(stringStack.pop().index);
    }

    private static boolean isValidBracket(String current, Stack<BracketsAt> stringStack) {
        if (!stringStack.empty()) {
            if (current.equals(")") && stringStack.peek().bracket.equalsIgnoreCase("(")) {
                return true;
            } else if (current.equals("]") && stringStack.peek().bracket.equalsIgnoreCase("[")) {
                return true;
            } else return current.equals("}") && stringStack.peek().bracket.equalsIgnoreCase("{");
        }
        return false;
    }

    static class BracketsAt {
        String bracket;
        int index;

        public BracketsAt(String bracket, int index) {
            this.bracket = bracket;
            this.index = index;
        }
    }
}

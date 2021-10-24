import java.util.Stack;

/**
 * Created on:  Jan 20, 2021
 * Questions: https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/
 * <p>
 * Given the postfix tokens of an arithmetic expression, build and return the binary expression tree that represents this expression.
 * <p>
 * Postfix notation is a notation for writing arithmetic expressions in which the operands (numbers) appear before their operators. For example, the postfix tokens of the expression 4*(5-(7+2)) are represented in the array postfix = ["4","5","7","2","+","-","*"].
 * <p>
 * The class ArithmeticNode is an interface you should use to implement the binary expression tree. The returned tree will be tested using the evaluate function, which is supposed to evaluate the tree's value. You should not remove the ArithmeticNode class; however, you can modify it as you wish, and you can define other classes to implement it if needed.
 * <p>
 * A binary expression tree is a kind of binary tree used to represent arithmetic expressions. Each node of a binary expression tree has either zero or two children. Leaf nodes (nodes with 0 children) correspond to operands (numbers), and internal nodes (nodes with two children) correspond to the operators '+' (addition), '-' (subtraction), '*' (multiplication), and '/' (division).
 * <p>
 * It's guaranteed that no subtree will yield a value that exceeds 109 in absolute value, and all the operations are valid (i.e., no division by zero).
 * <p>
 * Follow up: Could you design the expression tree such that it is more modular? For example, is your design able to support additional operators without making changes to your existing evaluate implementation?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: s = ["3","4","+","2","*","7","/"]
 * Output: 2
 * Explanation: this expression evaluates to the above binary tree with expression ((3+4)*2)/7) = 14/7 = 2.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: s = ["4","5","7","2","+","-","*"]
 * Output: -16
 * Explanation: this expression evaluates to the above binary tree with expression 4*(5-(2+7)) = 4*(-4) = -16.
 * Example 3:
 * <p>
 * Input: s = ["4","2","+","3","5","1","-","*","+"]
 * Output: 18
 * Example 4:
 * <p>
 * Input: s = ["100","200","+","2","/","5","*","7","+"]
 * Output: 757
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length < 100
 * s.length is odd.
 * s consists of numbers and the characters '+', '-', '*', and '/'.
 * If s[i] is a number, its integer representation is no more than 105.
 * It is guaranteed that s is a valid expression.
 * The absolute value of the result and intermediate values will not exceed 109.
 * It is guaranteed that no expression will include division by zero.
 */

public class DesignAnExpressionTreeWithEvaluateFunction {

    public static void main(String[] args) {

    }

}

abstract class ArithmeticNode {
    ArithmeticNode left, right;
    int val;

    public abstract int evaluate();
}

class MyNode extends ArithmeticNode {
    @Override
    public int evaluate() {
        return val;
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a ArithmeticNode.
 */

class TreeBuilder {
    ArithmeticNode buildTree(String[] postfix) {
        Stack<ArithmeticNode> stack = new Stack<>();
        for (String cur : postfix) {
            ArithmeticNode arithmeticNode = new MyNode();
            if (isSymbol(cur)) {
                ArithmeticNode v2 = stack.pop(), v1 = stack.pop();
                arithmeticNode.left = v1;
                arithmeticNode.right = v2;
                arithmeticNode.val = getVal(v1.val, cur, v2.val);
            } else {
                arithmeticNode.val = Integer.parseInt(cur);
            }
            stack.add(arithmeticNode);
        }
        return stack.peek();
    }

    private int getVal(int a, String ope, int b) {
        return switch (ope) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }

    private boolean isSymbol(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}
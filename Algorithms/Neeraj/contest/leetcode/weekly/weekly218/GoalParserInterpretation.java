package weekly.weekly218;

import java.util.*;

/**
 * Created on:  Dec 05, 2020
 * Questions: https://leetcode.com/contest/weekly-contest-218/problems/goal-parser-interpretation/
 */

public class GoalParserInterpretation {

    public static void main(String[] args) {

    }

    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char cur : command.toCharArray()) {
            if (cur == '(' || cur == 'a' || cur == 'l') {
                stack.add(cur);
            } else if (cur == ')') {
                if (stack.size() == 1) {
                    sb.append("o");
                } else {
                    sb.append("al");
                }
                stack = new Stack<>();
            } else {
                sb.append(cur);
            }
        }
        if (stack.size() == 1) {
            sb.append("o");
        } else if (stack.size() == 3) {
            sb.append("al");
        }
        return sb.toString();
    }
}

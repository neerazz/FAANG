package weekly.weekly208;

import java.util.Stack;

/**
 * Created on:  Sep 26, 2020
 * Questions: https://leetcode.com/problems/crawler-log-folder
 */
public class CrawlerLogFolder {
    public static void main(String[] args) {

    }

    public static int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            if (log.equals("./")) continue;
            if (log.equals("../")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.add(log);
            }
        }
        return stack.size();
    }
}

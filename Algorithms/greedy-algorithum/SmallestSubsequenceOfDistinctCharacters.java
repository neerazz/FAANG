import java.util.Stack;

/**
 * Created on:  Oct 11, 2020
 * Questions: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */

public class SmallestSubsequenceOfDistinctCharacters {

    public static void main(String[] args) {

    }

    public static String smallestSubsequence(String s) {
        int[] counts = new int[26];
        for (char cur : s.toCharArray()) {
            counts[cur - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for (char cur : s.toCharArray()) {
//            Reduce the counter of the current character.
            counts[cur - 'a']--;
//            If it is already take previously then ignore processing and move forward.
            if (visited[cur - 'a']) continue;

//            Check the stack and remove if there is any character that is greater then current and is present after cur.
            while (!stack.isEmpty() && cur < stack.peek() && counts[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

//            Add the current value to stack.
            stack.add(cur);
            visited[cur - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

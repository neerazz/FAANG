import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/?envType=daily-question&envId=2024-04-04
public class MaximumNestingDepthOfTheParentheses {

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
    }

    public static int maxDepth(String s) {
        int depth = 0;
        if (s.isEmpty()) return depth;
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                int start = -1, cal = 0;
                for (int j = 0; j < poll.length(); j++) {
                    char c = poll.charAt(j);
                    if (c == '(') {
                        cal++;
                        if (start == -1) {
                            start = j;
                        }
                    } else if (c == ')') {
                        cal--;
                        if (cal == 0) {
                            queue.add(poll.substring(start + 1, j));
                            start = -1;
                        }
                    }
                }
                if (start != -1) {
                    queue.add(poll.substring(start + 1));
                }
            }
            depth++;
//            System.out.println("Depth " + depth + " Queue = " + queue);
        }
        return depth - 1;
    }
}

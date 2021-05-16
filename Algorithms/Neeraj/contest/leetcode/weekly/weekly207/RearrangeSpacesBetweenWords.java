package weekly.weekly207;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Sep 19, 2020
 * Questions: https://leetcode.com/problems/rearrange-spaces-between-words
 */
public class RearrangeSpacesBetweenWords {
    public static void main(String[] args) {
        System.out.println(reorderSpaces("  this   is  a sentence "));
        System.out.println(reorderSpaces("a"));
        System.out.println(reorderSpaces(" hello"));
        System.out.println("---" + reorderSpaces("  hello") + "---");
        System.out.println("---" + reorderSpaces(" practice   makes   perfect") + "---");
    }

    public static String reorderSpaces(String text) {
        int len = text.length(), spaces = 0;
        int p1 = 0;
        List<String> op = new ArrayList<>();
        for (int p2 = 0; p2 < len; p2++) {
            char cur = text.charAt(p2);
            if (cur == ' ') {
                spaces++;
                if (p1 != p2) op.add(text.substring(p1, p2));
                p1 = p2 + 1;
            }
        }
        if (p1 != len) op.add(text.substring(p1, len));
        int perWord = op.size() == 1 ? 0 : spaces / (op.size() - 1);
        String delimit = " ".repeat(perWord);
        String result = String.join(delimit, op);
        while (result.length() < text.length()) {
            result += " ";
        }
        return result;
    }
}

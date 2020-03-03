import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc") + " should be [abc]");
        System.out.println(removeDuplicateLetters("cbacdcbc") + " should be [acdb]");
    }
    public static String removeDuplicateLetters(String s) {
        HashSet<Character> unique = new HashSet<>();
        Map<Character,Integer> characterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            characterMap.put(s.charAt(i),i);
        }
        int index = 0;
        Stack<Character> stack = new Stack<>();
        while (index < s.length()){
            char cur = s.charAt(index);
            if (!unique.contains(cur)){
                while (!stack.isEmpty() && cur < stack.peek() && characterMap.get(stack.peek()) > index){
                    unique.remove(stack.pop());
                }
                unique.add(cur);
                stack.add(cur);
            }
            index++;
        }
        StringBuilder sb = new StringBuilder(stack.size());
        stack.forEach(sb::append);
        return sb.toString();
    }
}

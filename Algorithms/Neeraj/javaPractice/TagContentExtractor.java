package javaPractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//This is incomplete.
 public class TagContentExtractor {
    public static void main(String[] args) {
        extractString("<h1>Sanjay has no watch</h1><par>So wait for a while</par>");
        extractString("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>");
    }

    private static void extractString(String input) {
        StringBuilder outputStringBuilder = new StringBuilder();
        Stack<String> tagsStack = new Stack<>();
        Queue<String> output = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '<'){
//                check if it is the starting tag or ending tag.
                if (i+1 <= input.length() && input.charAt(i+1) == '/'){
//                    Then is the ending tag.
                    i++;
                    String tag = findTag(input,i);
                    if (tagsStack.peek().equals(tag)){
                        output.add(outputStringBuilder.toString());
                        outputStringBuilder = new StringBuilder();
                    }else {
                        output.add("None");
                    }
                    i+= tag.length()+1;
                }else{
//                Start of tag.
                    String tag = findTag(input,i);
                    tagsStack.add(tag);
                    i+= tag.length()+1;
                }
            }else {
                outputStringBuilder.append(current);
            }
        }
        output.forEach(System.out::println);
    }

    private static String findTag(String input, int pos) {
        StringBuffer tagStringBuilder = new StringBuffer();
        while (true){
            pos++;
            char c = input.charAt(pos);
            if (c != '>'){
                tagStringBuilder.append(c);
            }else {
//             The tag had ended.
                String tag = tagStringBuilder.toString();
                System.out.println("Tag value is :" + tag);
                break;
            }
        }
        return tagStringBuilder.toString();
    }
}

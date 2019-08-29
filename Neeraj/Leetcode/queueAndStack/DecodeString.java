package queueAndStack;

import java.util.ArrayList;
import java.util.Stack;

/*
https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1379/
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println("Answer is: " + decodeString("3[a]2[bc]") + " should be [aaabcbc].");
    }

    public static String decodeString(String s) {
        Stack<Integer> numbers = new Stack<>();
        ArrayList<String> output = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '[') {

            }
            if (current == ']') {

            }
            if (Character.isDigit(current)) {
                numbers.add(Integer.valueOf(String.valueOf(current)));
            }
        }
        System.out.println("Numbers : " + numbers);
        return null;
//        return createString(s,indices,numbers);
    }
}
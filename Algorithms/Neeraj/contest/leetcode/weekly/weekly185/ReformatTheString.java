package weekly.weekly185;
/*
    Created on:  Apr 18, 2020
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Questions:
 */
public class ReformatTheString {
    public static void main(String[] args) {
        System.out.println(reformat("a0b1c2"));
    }
    public static String reformat(String s) {
        Queue<Character> chars = new LinkedList<>(), nums = new LinkedList<>();
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                nums.add(c);
            }else{
                chars.add(c);
            }
        }
        System.out.println("chars = " + chars);
        System.out.println("nums = " + nums);
        if(chars.size() >= nums.size()){
            return getString(chars,nums);
        }
        return getString(nums,chars);
    }
    private static String getString(Queue<Character> stack1, Queue<Character> stack2){
//         First stack should be larger.
        StringBuilder sb = new StringBuilder();
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            sb.append(stack1.poll()).append(stack2.poll());
        }
        if(stack1.size() == 1){
            return sb.append(stack1.poll()).toString();
        }
        if(stack1.isEmpty() && stack2.isEmpty()) return sb.toString();
        return "";
    }
}

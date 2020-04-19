/*
    Created on:  Apr 16, 2020
 */

/**
 * Questions:
 */
public class ValidParenthesisString {
    public static void main(String[] args) {

    }
    public boolean checkValidString(String s) {
        int len = s.length();
        int left =0;
//        Keep replacing the "*" with "(" and move from left to right. Check the balance of "(" in the string.
//        Increase the counter every time "(" is encountered, reduce when ")" is encountered.
//        At any given point if the counter is negative then it is an invalid string.
        for(char c: s.toCharArray()){
            if(c == '(' || c == '*') left++;
            else left--;
            if(left < 0) return false;
        }
//        Keep replacing the "*" to ")" and move from right. Now check the balance of ")" in the string.
        int right =0;
        for(int i =len-1; i>= 0; i--){
            char c = s.charAt(i);
            if(c == ')' || c == '*') right++;
            else right--;
            if(right < 0) return false;
        }
        return true;
    }
}

/**
 * Created on:  May 27, 2020
 * Questions: https://leetcode.com/problems/score-of-parentheses/
 */
public class ScoreOfParentheses {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("()") + " should be [1]");
        index =0;
        System.out.println(scoreOfParentheses("(())") + " should be [2]");
        index =0;
        System.out.println(scoreOfParentheses("()()") + " should be [2]");
        index =0;
        System.out.println(scoreOfParentheses("((()())())") + " should be [10]");
    }
    static int index =0;
    public static int scoreOfParentheses(String S) {
        if(S.length() == index) return 0;
        boolean isStart = true;
        int count = 0;
        while(index < S.length()){
            if(S.charAt(index) == '('){
                if(isStart){
                    index++;
                    isStart = false;
                }else{
                    count += 2 * scoreOfParentheses(S);
                    index++;
                    isStart = true;
                }
            }else{
                if(isStart){
//                    If a start is expected but it is end. Then return the count
                    break;
                }else{
                    count++;
                    index++;
                    isStart = true;
                }
            }
        }
        return count;
    }
}

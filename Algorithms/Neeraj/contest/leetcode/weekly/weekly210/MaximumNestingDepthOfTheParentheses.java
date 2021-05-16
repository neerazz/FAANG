package weekly.weekly210;

/**
 * Created on:  Oct 10, 2020
 * Questions: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses
 */

public class MaximumNestingDepthOfTheParentheses {

    public static void main(String[] args) {

    }
    public int maxDepth(String s) {
        int max = 0, open = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                max = Math.max(max, ++open);
            }else if(c == ')'){
                open--;
            }
        }
        return max;
    }
}

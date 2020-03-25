import java.util.*;
/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf") + " should be [2]");
        System.out.println(lengthOfLongestSubstring2("dvdf") + " should be [2]");
        System.out.println(lengthOfLongestSubstring("pwwkew") + " should be [3]");
        System.out.println(lengthOfLongestSubstring2("pwwkew") + " should be [3]");
    }

    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE, p1 =0;
        for(int i =0; i<s.length() ; i++){
            char c = s.charAt(i);
            if(set.contains(c)){
//                 Then keep removing from the queue till you encounter the current char.
                while(p1 <= i){
                  char p1Char =s.charAt(p1++);
                    if(p1Char == c){
                        break;
                    }else{
                      set.remove(p1Char);
                    }
                }
            }
            set.add(c);
            max = Math.max(max,set.size());
            // System.out.println(set);
        }
        return max;
    }

    private static int lengthOfLongestSubstring(String input) {
        if (input.length() < 2) {
            return input.length();
        }

        char[] chars = input.toCharArray();
        int max = 0, current = max;
        String subString = null;

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            String currentCharString = String.valueOf(currentChar);

            if (subString != null) {
                int index = subString.lastIndexOf(currentChar);
                if (index >= 0) {
//                    max = current > max ? current : max;
//                    current = current-(index +1);
                    subString = subString.substring(index + 1) + currentCharString;
                    current = subString.length();
                } else {
                    subString = subString + currentCharString;
                    current++;
                }
            } else {
                subString = currentCharString;
                current++;
            }
            max = Math.max(current, max);
        }
        return Math.max(current, max);
    }
}

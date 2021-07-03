import java.util.Arrays;

/**
 * Created on:  Jun 30, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/N8vB7OVYo2D#permutation-in-a-string-hard
 */

public class StringPermutation {

    public static void main(String[] args) {

    }

    public static boolean findPermutation(String str, String pattern) {
        int[] required = new int[26];
        for(char c: pattern.toCharArray()) required[c-'a']++;
        int[] window = new int[26];
        int p1 =0, p2 = 0, len = str.length(), reqLen = pattern.length();
        while(p2 < len){
            window[str.charAt(p2)-'a']++;
            if(p2-p1+1 == reqLen){
                if(Arrays.equals(required, window)) return true;
                window[str.charAt(p1++)-'a']--;
            }
            p2++;
        }
        return false;
    }
}

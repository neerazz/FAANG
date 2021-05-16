package biweekly.biweekly51;

/**
 * Created on:  May 01, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-51/problems/replace-all-digits-with-characters/
 */

public class ReplaceAllDigitsWithCharacters {

    public static void main(String[] args) {

    }
    public String replaceDigits(String s) {
        char pre = ' ';
        StringBuilder sb = new StringBuilder();
        for(char cur: s.toCharArray()){
            if(Character.isDigit(cur)){
                sb.append(swap(pre, (int)(cur-'0')));
            }else{
                sb.append(cur);
                pre = cur;
            }
        }
        return sb.toString();
    }
    char swap(char cur, int shift){
        char shifted = (char)(cur + shift);
        return shifted;
    }
}

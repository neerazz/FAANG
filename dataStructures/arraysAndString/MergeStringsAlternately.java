import java.util.*;

/**
 * 
 * @author   : bnira
 * Created on: 7/27/2025
 * Question  : https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 *
 */
 
public class MergeStringsAlternately {

    public static void main(String[] args) {

    }

    public String mergeAlternately(String word1, String word2) {
        int i1=0, i2=0, l1=word1.length(), l2=word2.length();
        StringBuilder sb = new StringBuilder();
        while(i1 < l1 && i2 < l2){
            sb.append(word1.charAt(i1++));
            sb.append(word2.charAt(i2++));
        }
        if(i1<l1){
            sb.append(word1.substring(i1));
        }
        if(i2<l2){
            sb.append(word2.substring(i2));
        }
        return sb.toString();
    }
}

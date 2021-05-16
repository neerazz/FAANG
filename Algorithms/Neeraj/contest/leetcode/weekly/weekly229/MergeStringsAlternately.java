package weekly.weekly229;

/**
 * Created on:  Feb 20, 2021
 * Questions:
 */

public class MergeStringsAlternately {

    public static void main(String[] args) {

    }
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i1 =0, l1 = word1.length(), i2=0, l2 = word2.length();
        while(i1 <l1 && i2 < l2){
            sb.append(word1.charAt(i1++));
            sb.append(word2.charAt(i2++));
        }
        while(i1 < l1) sb.append(word1.charAt(i1++));
        while(i2 < l2) sb.append(word2.charAt(i2++));
        return sb.toString();
    }
}

package biweekly.biweekly45;

/**
 * Created on:  Feb 06, 2021
 * Questions:
 */

public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    public static void main(String[] args) {
//        System.out.println(minimumLength("aabccabba"));
        System.out.println(minimumLength("cabaabac"));
    }

    public static int minimumLength(String str) {
        int s = 0, e = str.length() - 1;
        while (s < e && str.charAt(s) == str.charAt(e)) {
            char cur = str.charAt(s);
            while (s <= e && str.charAt(s) == cur) s++;
            while (e >= s && str.charAt(e) == cur) e--;
        }
        return e - s + 1;
    }
}

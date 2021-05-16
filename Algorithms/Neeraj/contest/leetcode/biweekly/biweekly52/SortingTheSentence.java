package biweekly.biweekly52;

/**
 * Created on:  May 15, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-52/problems/sorting-the-sentence/
 */

public class SortingTheSentence {

    public static void main(String[] args) {

    }

    public static String sortSentence(String s) {
        String[] split = s.split(" ");
        String[] result = new String[split.length];
        for (String input : split) {
            int len = input.length();
            int position = input.charAt(len - 1) - '1';
            result[position] = input.substring(0, len - 1);
        }
        return String.join(" ", result);
    }
}

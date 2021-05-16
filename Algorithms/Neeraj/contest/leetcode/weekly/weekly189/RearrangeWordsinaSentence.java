package weekly.weekly189;

import java.util.Arrays;

/**
 * Created on:  May 16, 2020
 * Questions: https://leetcode.com/contest/weekly-contest-189/problems/rearrange-words-in-a-sentence/
 */
public class RearrangeWordsinaSentence {
    public static void main(String[] args) {
        System.out.println(arrangeWords("Leetcode is cool") + " should be [Is cool leetcode]");
        System.out.println(arrangeWords("Keep calm and code on") + " should be [On and keep calm code]");
        System.out.println(arrangeWords("To be or not to be") + " should be [To be or to be not]");
    }

    public static String arrangeWords(String text) {
        String[] split = text.split("\\s+");
        Arrays.sort(split, (w1, w2) -> Integer.compare(w1.length(), w2.length()));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String word = split[i];
            if (i == 0) {
                char[] chars = word.toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                word = String.valueOf(chars);
            } else if (Character.isUpperCase(word.charAt(0))) {
                char[] chars = word.toCharArray();
                chars[0] = Character.toLowerCase(chars[0]);
                word = String.valueOf(chars);
            }
            sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }
}

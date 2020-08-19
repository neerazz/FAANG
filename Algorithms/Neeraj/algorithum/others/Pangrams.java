
import java.util.HashSet;
import java.util.Set;

/*
https://www.hackerrank.com/challenges/pangrams/problem
Roy wanted to increase his typing speed for programming contests. His friend suggested that he type the sentence "The quick brown fox jumps over the lazy dog" repeatedly.
This sentence is known as a pangram because it contains every letter of the alphabet.
After typing the sentence several times, Roy became bored with it so he started to look for other pangrams.
Given a sentence, determine whether it is a pangram. Ignore case.
Function Description
Complete the function pangrams in the editor below. It should return the string pangram if the input string is a pangram. Otherwise, it should return not pangram.
pangrams has the following parameter(s):
s: a string to test
 */
public class Pangrams {
    public static void main(String[] args) {
        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize") + " should be [pangram]");
        System.out.println(pangrams("We promptly judged antique ivory buckles for the prize") + " should be [not pangram]");
    }

    static String pangrams(String s) {
        if (s == null || s.length() < 26){
            return "not pangram";
        }
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isAlphabetic(cur)){
                if (Character.isUpperCase(cur)){
                    characters.add(Character.toLowerCase(cur));
                }else {
                    characters.add(cur);
                }
            }
        }
        return characters.size() == 26 ? "pangram" : "not pangram";
    }
}

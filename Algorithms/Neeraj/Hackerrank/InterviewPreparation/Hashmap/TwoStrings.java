package InterviewPreparation.Hashmap;

import java.util.Arrays;
import java.util.HashSet;

public class TwoStrings {
    public static void main(String[] args) {
        System.out.println(twoStrings("hello","world"));
        System.out.println(twoStrings("hi","world"));
    }

    static String twoStrings(String s1, String s2) {
        if (s1.length() < s2.length()){
            return twoStrings(s2,s1);
        }else {
            char[] chars = s1.toCharArray();
            HashSet<Character> characters = new HashSet<>();
            for (int i = 0; i < s1.length(); i++) {
                characters.add(s1.charAt(i));
            }
            for (int i = 0; i < s2.length(); i++) {
                if (characters.contains(s2.charAt(i))){
                    return "YES";
                }
            }
            return "NO";
        }
    }
}

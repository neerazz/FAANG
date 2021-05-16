package weekly.weekly184;
/*
    Created on:  Apr 11, 2020
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Questions:
 */
public class StringMatchingInAnArray {
    public static void main(String[] args) {
        System.out.println(stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        System.out.println(stringMatching(new String[]{"leetcode", "et", "code"}));
        System.out.println(stringMatching(new String[]{"blue", "green", "bu"}));
    }

    public static List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String iW = words[i];
            for (int j = i + 1; j < words.length; j++) {
                if (set.contains(iW)) break;
                String jW = words[j];
                if (iW.length() > jW.length() && iW.contains(jW)) set.add(jW);
                if (iW.length() < jW.length() && jW.contains(iW)) set.add(iW);
            }
        }
        return new ArrayList<>(set);
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/NEOZDEg5PlN
 */

public class GeneralizedAbbreviation {

    public static List<String> generateGeneralizedAbbreviation(final String word) {
        final Set<String> result = new HashSet<String>();
        GeneralizedAbbreviation.helper(word, 0, result);
        System.out.println(result.size());
        return new ArrayList<>(result);
    }

    private static void helper(final String word, final int idx, final Set<String> set) {
        if (idx == word.length()) {
            set.add("" + word.length());
            return;
        }
        final int len = word.length();
        final String prefix = idx == 0 ? "" : "" + idx;
        for (int i = idx + 1; i <= len; i++) {
            final String center = word.substring(idx, i);
            set.add(prefix + center + (i == len ? "" : len - i));
        }
        set.add(word.substring(0, idx) + 1 + word.substring(idx + 1));
        GeneralizedAbbreviation.helper(word, idx + 1, set);
    }

    public static void main(final String[] args) {
        List<String> result = generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}

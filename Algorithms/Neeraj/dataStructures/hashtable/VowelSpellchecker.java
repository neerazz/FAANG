import java.util.*;

/**
 * Created on:  Mar 22, 2021
 * Questions:
 */

public class VowelSpellchecker {

    public static void main(String[] args) {

    }

    public static String[] spellchecker_rev1(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> charsMatch = new HashMap<>();
        Map<String, String> vowelMatch = new HashMap<>();
        for (String word : wordlist) {
            exact.add(word);
            String lower = word.toLowerCase();
            charsMatch.putIfAbsent(lower, word);
            vowelMatch.putIfAbsent(transform(lower), word);
        }
        for (int i = 0; i < queries.length; i++) {
            queries[i] = getString(queries[i], exact, charsMatch, vowelMatch);
        }
        return queries;
    }

    private static String getString(String str, Set<String> exact, Map<String, String> charsMatch, Map<String, String> vowelMatch) {
        if (exact.contains(str)) return str;
        String lower = str.toLowerCase();
        if (charsMatch.containsKey(lower)) return charsMatch.get(lower);
        String vowel = transform(lower);
        if (vowelMatch.containsKey(vowel)) return vowelMatch.get(vowel);
        return "";
    }

    private static String transform(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) chars[i] = '*';
        }
        return new String(chars);
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        Map<Integer, LinkedHashSet<String>> map = new HashMap<>();
        for (String word : wordlist) {
            map.computeIfAbsent(word.length(), val -> new LinkedHashSet<>()).add(word);
        }
        String[] result = new String[queries.length];
        int i = 0;
        for (String query : queries) {
            String best = "";
            int pro = 0;
            for (String word : map.getOrDefault(query.length(), new LinkedHashSet<>())) {
                if (word.equals(query)) {
                    best = word;
                    break;
                } else if (word.equalsIgnoreCase(query)) {
                    if (best.length() == 0) {
                        best = word;
                    } else if (pro == 2) {
                        best = word;
                    }
                    pro = 1;
                } else if (best.length() == 0 && vowelMatch(query, word)) {
                    best = word;
                    pro = 2;
                }
                // System.out.println("Query = " + query + " word = " + word + " best = " + best);
            }
            result[i++] = best;
        }
        return result;
    }

    static boolean vowelMatch(String s1, String s2) {
        int i1 = 0, l1 = s1.length(), i2 = 0, l2 = s2.length();
        if (l1 != l2) return false;
        // System.out.println("\t\t Vowel Match: " + s1 + " , " + s2);
        while (i1 < l1 && i2 < l2) {
            char c1 = Character.toLowerCase(s1.charAt(i1++)), c2 = Character.toLowerCase(s2.charAt(i2++));
            if (c1 == c2) continue;
            if (isVowel(c1) && isVowel(c2)) continue;
            return false;
        }
        return true;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

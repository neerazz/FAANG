package ds.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1137/
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
a) it                      --> it    (no abbreviation)
     1
     ↓
b) d|o|g                   --> d1g
              1    1  1
     1---5----0----5--8
     ↓   ↓    ↓    ↓  ↓
c) i|nternationalizatio|n  --> i18n
              1
     1---5----0
     ↓   ↓    ↓
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
Example: Given dictionary = [ "deer", "door", "cake", "card" ]
isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
 */
public class UniqueWordAbbreviation {
    public static void main(String[] args) {
        ValidWordAbbr obj = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        System.out.println(obj.isUnique("dear") + " -> false");
        System.out.println(obj.isUnique("cart") + " -> true");
        System.out.println(obj.isUnique("cane") + " -> false");
        System.out.println(obj.isUnique("make") + " -> true");
        System.out.println("===============================================");
        System.out.println(obj.isUnique("dear") + " -> false");
        System.out.println(obj.isUnique("door") + " -> false");
        System.out.println(obj.isUnique("cart") + " -> true");
        System.out.println(obj.isUnique("cake") + " -> true");
        System.out.println("===============================================");
        obj = new ValidWordAbbr(new String[]{"hello"});
        System.out.println(obj.isUnique("hello") + " -> true");
        obj = new ValidWordAbbr(new String[]{"hello"});
        System.out.println(obj.isUnique("hello") + " -> true");
    }
}

class ValidWordAbbr {
    HashMap<String, HashSet<String>> hashMap = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        Arrays.stream(dictionary).forEach(s -> {
            String acronym = getAcronym(s);
            HashSet<String> hashSet = hashMap.getOrDefault(acronym, new HashSet<>());
            hashSet.add(s);
            hashMap.put(acronym, hashSet);
        });
    }

    private String getAcronym(String string) {
        int length = string.length();
        if (length <= 2) return string;
        else return String.valueOf(string.charAt(0)) + (length - 2) + string.charAt(length - 1);
    }

    public boolean isUnique(String word) {
        String abbr = getAcronym(word);
        Set<String> words = hashMap.get(abbr);
        return words == null || (words.size() == 1 && words.contains(word));
    }
}
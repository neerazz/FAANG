import java.util.HashMap;

/*
https://www.hackerrank.com/challenges/java-anagrams/problem
 */
public class JavaAnagrams {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "anagram") + " should be [Anagrams]");
        System.out.println(isAnagram("anagramm", "marganaa") + " should be [Not Anagrams]");
        System.out.println(isAnagram("Hello", "hello") + " should be [Anagrams]");
    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        java.util.Map<String, Integer> first = new java.util.HashMap<>();
        java.util.Map<String, Integer> second = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            String current = String.valueOf(a.charAt(i)).toUpperCase();
            if (first.containsKey(current)) first.put(current, first.get(current) + 1);
            else first.put(current.toUpperCase(), 1);
        }

        for (int i = 0; i < b.length(); i++) {
            String current = String.valueOf(b.charAt(i)).toUpperCase();
            if (second.containsKey(current)) second.put(current, second.get(current) + 1);
            else second.put(current, 1);
        }

        for (java.util.Map.Entry<String, Integer> e : first.entrySet()) {
            if (!second.containsKey(e.getKey()) || !second.get(e.getKey()).equals(e.getValue())) return false;
        }
        return true;
    }
}

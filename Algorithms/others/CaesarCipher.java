import java.util.HashMap;

/*
https://www.hackerrank.com/challenges/caesar-cipher-1/problem
 */
public class CaesarCipher {
    public static void main(String[] args) {
        System.out.println(caesarCipher("middle-Outz", 2) + " should be [okffng-Qwvb]");
    }

    static String caesarCipher(String s, int k) {
        if (s == null || s.isEmpty() || k == 0) {
            return s;
        }
//         Take a hash map with swaps and the corresponding mapping.
        HashMap<Character, Character> characterHashMap = new HashMap<>();
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int swaps = k % 26;
        for (int i = 0; i < 26; i++) {
            int swappedNumber = i + swaps >= 26 ? i + swaps - 26 : i + swaps;
            characterHashMap.put(chars[i], chars[swappedNumber]);
        }
        char[] charArray = s.toCharArray();
//        Loop through the string and change the input.
        for (int i = 0; i < charArray.length; i++) {
            char cur = charArray[i];
            charArray[i] = characterHashMap.containsKey(cur) ? characterHashMap.get(cur) : charArray[i];
            if (Character.isUpperCase(cur)) {
                charArray[i] = Character.toUpperCase(characterHashMap.get(Character.toLowerCase(cur)));
            }
        }
        return String.valueOf(charArray);
    }
}

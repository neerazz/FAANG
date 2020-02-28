import java.util.*;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {
    static Map<Character, List<Character>> map;
    static List<String> output;

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
    }

    public static List<String> letterCombinations(String digits) {
        output = new ArrayList<>();
        map = new HashMap<>();
        if (digits.isEmpty()) return output;
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        backtrace(digits, 0, "");
        return output;
    }

    private static void backtrace(String digits, int index, String carry) {
        if (index >= digits.length()) {
            output.add(carry);
        } else {
            char current = digits.charAt(index);
            List<Character> characters = map.get(current);
            for (Character c : characters) {
                backtrace(digits, index + 1, carry + c);
            }
        }
    }
}

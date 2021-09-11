import java.util.*;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the sachi.telephone buttons) is given below. Note that 1 does not map to any letters.
Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {

    static Map<Character, List<Character>> map;
    static List<String> output;
    static Map<String, List<String>> memo = new HashMap<>();

    static {
        map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public static void main(String[] args) {
        System.out.println("****************  Method 1 ********************");
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println("****************  Method 2 ********************");
        System.out.println(letterCombinations_rev("23"));
        System.out.println(letterCombinations_rev(""));
        System.out.println("****************  Method 3 ********************");
        System.out.println(letterCombinations_memo("23"));
        System.out.println(letterCombinations_memo(""));
    }

    public static List<String> letterCombinations_memo(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        } else {
            return helper_memo(digits);
        }
    }

    public static List<String> helper_memo(String digits) {
        if (digits.length() == 0) {
            return Collections.singletonList("");
        } else if (memo.containsKey(digits)) {
            return memo.get(digits);
        } else {
            List<String> op = new ArrayList<>();
            for (char c : map.get(digits.charAt(0))) {
                for (String letters : helper_memo(digits.substring(1))) {
                    op.add(c + letters);
                }
            }
            memo.put(digits, op);
            return op;
        }
    }

    public static List<String> letterCombinations_rev(String digits) {
        output = new ArrayList<>();
        if (digits == null || digits.length() == 0) return output;
        helper(digits, "");
        return output;
    }

    private static void helper(String digits, String soFar) {
        if (digits.length() <= 0) {
            output.add(soFar);
            return;
        }
        for (char c : map.get(digits.charAt(0))) {
            helper(digits.substring(1), soFar + c);
        }
    }

    public static List<String> letterCombinations(String digits) {
        output = new ArrayList<>();
        if (digits.isEmpty()) return output;
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

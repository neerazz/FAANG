package leetcode.v1.medium;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {

    Map<Character, List<String>> map = new HashMap<>();

    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {

        List<String> sol = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return sol;
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        StringBuilder sb = new StringBuilder();
        generate(sol, digits, 0, sb);
        return sol;
    }

    public void generate(List<String> sol, String input, int n, StringBuilder sb) {
        //Base case
        if (sb.length() == input.length()) {
            sol.add(sb.toString());  //ad,
            return;
        }
        List<String> strings = map.get(input.charAt(n)); //abc, //def
        for (String str : strings) {
            sb.append(str);     //a, e
            generate(sol, input, n + 1, sb); //n = 1, 2
            sb.deleteCharAt(sb.length() - 1); //a
        }
    }


}

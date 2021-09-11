import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DecodeVariants {

    static HashSet<String> possibilities;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(decodeVariations("1262"));
        System.out.println(decodeVariations("0"));
    }

    static int decodeVariations_1(String S) {
        if (S == null || S.length() < 1) return 0;
        // Keep all the charecter's and the int mapping in a map.
        Map<String, Character> map = new HashMap<>();
        String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf(i + 1), input.charAt(i));
        }
        possibilities = new HashSet<>();
        recursion(0, "", S, map);
        return possibilities.size();
    }

    static int decodeVariations(String s) {
        if (s.length() > 0 && s.charAt(0) == '0') return 0;
        if (s.length() <= 1) return 1;
        if (map.containsKey(s)) return map.get(s);
        int result = 0;
        if (Integer.parseInt(s.substring(0, 2)) <= 26) {
            result = decodeVariations(s.substring(1)) + decodeVariations(s.substring(2));
        } else {
            result = decodeVariations(s.substring(1));
        }
        map.put(s, result);
        return result;
    }

    static void recursion(int inputIndex, String curValue, String input, Map<String, Character> map) {
        if (inputIndex > input.length()) return;
        if (inputIndex == input.length()) {
            possibilities.add(curValue);
            return;
        }
        // Take the char from the index point and place a recursive call.
        char c1 = input.charAt(inputIndex);
        if (map.containsKey("" + c1)) {
            char first = map.get("" + c1);
            recursion(inputIndex + 1, curValue + first, input, map);
        }
        //Then check of we can use the next two digits to get a char.
        if (inputIndex + 1 <= input.length() - 1) {
            String secondChar = "" + c1 + input.charAt(inputIndex + 1);
            if (map.containsKey(secondChar)) {
                recursion(inputIndex + 2, curValue + map.get(secondChar), input, map);
            }
        }
    }
}

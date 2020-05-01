import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringContaining {

    public static String smallestSubstringContaining(String bigString, String smallString) {
        Map<Character, Integer> mainMap = new HashMap<>();
        Map<Character, Integer> countMap = new HashMap<>();
        int missingChars = smallString.length();
        for (char c : smallString.toCharArray()) {
            mainMap.putIfAbsent(c, 0);
            mainMap.put(c, mainMap.get(c) + 1);
        }
        int sp1 = 0, sp2 = bigString.length() - 1, p1 = 0, p2 = 0;
        while (p2 < bigString.length()) {
            //Increment p2 till we find a matching window
            char c = bigString.charAt(p2);
            if (!mainMap.containsKey(c)) {
                p2++;
                continue;
            }
            countMap.putIfAbsent(c, 0);
            int exp = mainMap.get(c);
            int actual = countMap.get(c);
            if (actual < exp) {
                missingChars--;
            }
            countMap.put(c, countMap.get(c) + 1);
            //Shrink the window till valid
            while (missingChars == 0) {
                int currMax = sp2 - sp1;
                int newMax = p2 - p1;
                if (newMax < currMax) {
                    sp2 = p2;
                    sp1 = p1;
                }
                char d = bigString.charAt(p1);
                //Invalid char
                if (!mainMap.containsKey(d)) {
                    p1++;
                    continue;
                }
                if (countMap.get(d) == 0) {
                    countMap.remove(d);
                } else {
                    countMap.put(d, countMap.get(d) - 1);
                }
                //Check Valid Char window
                exp = mainMap.get(d);
                actual = countMap.get(d);
                if (actual < exp) {
                    missingChars++;
                }
                p1++;
            }
            p2++;
        }
        return bigString.substring(sp1, sp2 + 1);
    }

    public static void main(String[] args) {
        String sol = smallestSubstringContaining("abcd$ef$axb$c$", "$$abf");
        System.out.println(sol);
    }

}

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfVowelsInASubstring {

    public static int maxVowels(String s, int k) {
        int sol = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int p1 = 0, p2 = 0, currCount = 0;

        while (p2 < k) {
            if (set.contains(s.charAt(p2))) currCount++;
            p2++;
        }
        p2--;
        sol = Math.max(sol, currCount);

        while (p2 < s.length() - 1) {
            char c1 = s.charAt(p1);
            if (set.contains(c1)) currCount--;
            p1++;
            p2++;
            char c2 = s.charAt(p2);
            if (set.contains(c2)) currCount++;
            sol = Math.max(sol, currCount);
        }
        return sol;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("aeiou", 2));
    }
}

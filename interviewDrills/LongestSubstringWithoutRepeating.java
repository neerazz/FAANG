import java.util.HashMap;
import java.util.Map;

/**
 * MAANG screen drill: Longest Substring Without Repeating Characters.
 *
 * Interview signal:
 * - Can you maintain a valid sliding window without re-scanning characters?
 * - Can you move the left pointer only forward when a duplicate appears?
 *
 * Problem:
 * Return the length of the longest substring that contains no repeated
 * characters.
 *
 * Approach:
 * 1. Track the last index where each character appeared.
 * 2. Keep a sliding window [left, right] with no duplicates.
 * 3. When a character repeats inside the current window, move left to one
 *    position after its previous occurrence.
 * 4. Update the best window length after each character.
 *
 * Complexity:
 * - Time: O(n), where n is s.length().
 * - Space: O(m), where m is the number of distinct characters in the window.
 */
public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            Integer previousIndex = lastSeen.get(current);

            if (previousIndex != null && previousIndex >= left) {
                left = previousIndex + 1;
            }

            lastSeen.put(current, right);
            best = Math.max(best, right - left + 1);
        }

        return best;
    }

    public static void main(String[] args) {
        expect(3, lengthOfLongestSubstring("abcabcbb"), "moves through repeated pattern");
        expect(1, lengthOfLongestSubstring("bbbbb"), "all characters repeat");
        expect(3, lengthOfLongestSubstring("pwwkew"), "does not count subsequences");
        expect(2, lengthOfLongestSubstring("abba"), "left pointer never moves backward");
        expect(0, lengthOfLongestSubstring(""), "empty string");

        System.out.println("All LongestSubstringWithoutRepeating drill checks passed.");
    }

    private static void expect(int expected, int actual, String label) {
        if (expected != actual) {
            throw new AssertionError(label + " expected " + expected + " but got " + actual);
        }
    }
}

package binarysearch;

/*
https://leetcode.com/explore/learn/card/binary-search/137/conclusion/977/
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"
Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"
Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"
Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"
Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"
Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.
 */
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        System.out.println("Answer is :" + nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a') + " should be [c].");
        System.out.println("Answer is :" + nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c') + " should be [f].");
        System.out.println("Answer is :" + nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd') + " should be [f].");
        System.out.println("Answer is :" + nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g') + " should be [j].");
        System.out.println("Answer is :" + nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j') + " should be [c].");
        System.out.println("Answer is :" + nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k') + " should be [c].");
        System.out.println("Answer is :" + nextGreatestLetter(new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'e') + " should be [n].");
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target < letters[mid]) end = mid;
            if (target >= letters[mid]) start = mid + 1;

            if (start >= letters.length - 1 && target >= letters[start]) return letters[0];
            if (start == 0 && target < letters[start]) return letters[start];
        }
        if (start != letters.length && letters[start] > target) return letters[start];
        return ' ';
    }
}

package weekly.weekly243;

/**
 * Created on:  May 30, 2021
 * Questions: https://leetcode.com/contest/weekly-contest-243/problems/check-if-word-equals-summation-of-two-words/
 */

public class CheckIfWordEqualsSummationOfTwoWords {

    public static void main(String[] args) {
        System.out.println(isSumEqual("j", "j", "bi"));
    }

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int a = getCount(firstWord), b = getCount(secondWord), c = getCount(targetWord);
        return a + b == c;
    }

    private static int getCount(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            count = count * 10 + c - 'a';
        }
        return count;
    }
}

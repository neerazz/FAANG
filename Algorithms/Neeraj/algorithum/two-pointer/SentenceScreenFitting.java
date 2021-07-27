/**
 * Created on:  Jul 26, 2021
 * Ref : https://leetcode.com/problems/sentence-screen-fitting/
 */
public class SentenceScreenFitting {
    public static void main(String[] args) {

    }

    public static int wordsTyping(String[] sentence, int rows, int cols) {
        int row = 0, col = 0, count = 0, len = sentence.length, i = 0;
        while (row < rows && col < cols && i < len) {
            while (sentence[i].length() <= cols - col && i < len) {
                col += sentence[i++].length() + 1;
                if (i == len) {
                    count++;
                    i = 0;
                }
            }
            row++;
            col = 0;
        }
        return count;
    }
}

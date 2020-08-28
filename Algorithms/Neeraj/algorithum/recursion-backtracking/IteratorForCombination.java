import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on:  Aug 13, 2020
 * Questions: https://leetcode.com/problems/iterator-for-combination/
 */
public class IteratorForCombination {
    public static void main(String[] args) {

    }

    static class CombinationIterator {

        Queue<String> queue = new LinkedList<>();

        public CombinationIterator(String characters, int combinationLength) {
            generateCombinations(characters, 0, "", combinationLength);
        }

        private void generateCombinations(String str, int start, String soFar, int len) {
            if (soFar.length() > len || (start == str.length() && soFar.length() < len)) return;
            if (soFar.length() == len) {
                queue.add(soFar);
            } else {
                for (int i = start; i < str.length(); i++) {
                    generateCombinations(str, i + 1, soFar + str.charAt(i), len);
                }
            }
        }

        public String next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}

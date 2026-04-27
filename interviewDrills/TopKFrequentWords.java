import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * MAANG screen drill: Top K Frequent Words.
 *
 * Interview signal:
 * - Can you combine counting with a bounded heap?
 * - Can you keep the tie-breaker straight under pressure?
 *
 * Problem:
 * Return the k most frequent words. Higher frequency comes first. If two words
 * have the same frequency, lexicographically smaller words come first.
 *
 * Approach:
 * 1. Count each word with a HashMap.
 * 2. Keep a min-heap of at most k words.
 * 3. The heap removes the worst current candidate first: lower frequency, or
 *    lexicographically larger word when frequencies tie.
 * 4. Pop the heap and reverse it to get best-to-worst order.
 *
 * Complexity:
 * - Time: O(n + u log k), where n is words.length and u is unique words.
 * - Space: O(u + k).
 */
public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0 || k <= 0) {
            return Collections.emptyList();
        }

        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            int frequencyCompare = Integer.compare(counts.get(a), counts.get(b));
            if (frequencyCompare != 0) {
                return frequencyCompare;
            }
            return b.compareTo(a);
        });

        for (String word : counts.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        expect(
                Arrays.asList("i", "love"),
                topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2),
                "basic frequency ranking"
        );

        expect(
                Arrays.asList("the", "is", "sunny", "day"),
                topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4),
                "frequency desc, lexical asc on ties"
        );

        expect(
                Arrays.asList("a", "b", "c"),
                topKFrequent(new String[]{"b", "a", "c"}, 10),
                "k larger than unique words"
        );

        expect(
                Collections.emptyList(),
                topKFrequent(new String[]{"only"}, 0),
                "non-positive k"
        );

        System.out.println("All TopKFrequentWords drill checks passed.");
    }

    private static void expect(List<String> expected, List<String> actual, String label) {
        if (!expected.equals(actual)) {
            throw new AssertionError(label + " expected " + expected + " but got " + actual);
        }
    }
}

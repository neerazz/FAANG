package biweekly.biweekly49;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on:  Apr 03, 2021
 * Questions:
 */

public class SentenceSimilarityIII {

    public static void main(String[] args) {

    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        LinkedList<String> words1 = buildList(sentence1), words2 = buildList(sentence2);
        while (!words1.isEmpty() && !words2.isEmpty() && words1.peek().equals(words2.peek())) {
            words1.pollFirst();
            words2.pollFirst();
        }
        while (!words1.isEmpty() && !words2.isEmpty() && words1.peekLast().equals(words2.peekLast())) {
            words1.pollLast();
            words2.pollLast();
        }
        return words1.isEmpty() || words2.isEmpty();
    }

    private static LinkedList<String> buildList(String sentence) {
        String[] words = sentence.split(" ");
        return Arrays.stream(words).collect(Collectors.toCollection(LinkedList::new));
    }
}

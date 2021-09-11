package topQuestions.amazon;/*
Given a non-empty list of words, return the k most frequent elements.
Your answer should be sorted by frequency from highest to lowest. If two words 
have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.


Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
with the number of occurrence being 4, 3, 2 and 1 respectively.

*/

import java.util.*;

class TopKFrequentWords {

    public static void main(String[] args) {
        //String[] input = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(input, 4));
    }


    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> counter = new HashMap<>();
        for (String word : words) {
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> {
            if (counter.get(w1).equals(counter.get(w2))) {
                return w2.compareTo(w1);
            } else {
                return counter.get(w1) - counter.get(w2);
            }
        });

        for (String s : counter.keySet()) {
            pq.offer(s);
            if (pq.size() > k) {
                pq.poll();
            }
        }


        List<String> sol = new ArrayList<>();
        while (!pq.isEmpty()) {
            sol.add(pq.poll());
        }
        Collections.reverse(sol);
        return sol;

    }

}


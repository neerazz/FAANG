package topQuestions.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// "static void main" must be defined in a public class.
public class TopWords {
    public static void main(String[] args) {
        System.out.println(
                topToys(6, 2, new String[]{"elmo", "elsa", "legos", "drone", "tablet", "warcraft"}, 6,
                        new String[]{
                                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                                "The new Elmo dolls are super high quality",
                                "Expect the Elsa dolls to be very popular this year, Elsa!",
                                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                                "For parents of older kids, look into buying them a drone",
                                "Warcraft is slowly rising in popularity ahead of the holiday season"
                        }));
    }

    public static List<String> topToys(int newFeatures, int topFeatures, String[] possibleFeatures, int numFeatures,
                                       String[] features) {

        Map<String, int[]> requests = new HashMap<>();

        for (String toy : possibleFeatures) {
            requests.put(toy, new int[]{0, 0});
        }

        for (String quote : features) {

            Set<String> sameReq = new HashSet<>();
            String[] words = quote.toLowerCase().split("\\W+");

            for (String word : words) {
                if (!requests.containsKey(word)) {
                    continue;
                }
                int[] nums = requests.get(word);
                nums[0]++;
                if (!sameReq.contains(word)) {
                    nums[1]++;
                }
                sameReq.add(word);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>((t1, t2) -> {

            if (requests.get(t1)[0] != requests.get(t2)[0]) {
                return requests.get(t1)[0] - requests.get(t2)[0];
            }

            if (requests.get(t1)[1] != requests.get(t2)[1]) {
                return requests.get(t1)[1] - requests.get(t2)[1];
            }

            return t2.compareTo(t1);
        });

        if (topFeatures > newFeatures) {
            for (String toy : requests.keySet()) {
                if (requests.get(toy)[0] > 0) {
                    pq.add(toy);
                }
            }
        } else {
            for (String toy : possibleFeatures) {
                pq.add(toy);

                if (pq.size() > topFeatures) {
                    pq.poll();
                }
            }
        }

        List<String> output = new ArrayList<>();
        while (!pq.isEmpty()) {
            output.add(pq.poll());
        }
        Collections.reverse(output);
        return output;
    }
}
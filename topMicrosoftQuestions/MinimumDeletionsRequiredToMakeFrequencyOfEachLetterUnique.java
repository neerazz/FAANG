import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Oct 30, 2020
 * Questions: https://leetcode.com/playground/7BziN4Hb
 */

public class MinimumDeletionsRequiredToMakeFrequencyOfEachLetterUnique {

    public static void main(String[] args) {
        System.out.println(minDeletions("aaaabbbb"));
        System.out.println(minDeletions("ccaaffddecee"));
        System.out.println(minDeletions("eeee"));
        System.out.println(minDeletions("example"));
    }

    private static int minDeletions(String str) {
        int[] counts = new int[26];
        int remove = 0;
        for (char cur : str.toCharArray()) {
            counts[cur - 'a']++;
        }
        Set<Integer> uniqueCounts = new HashSet<>(), removeAllCount = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0) continue;
            int cur = counts[i];
            if (removeAllCount.contains(cur)) {
                remove += cur;
            } else {
//            Loop till a unique value is found
                while (uniqueCounts.contains(cur)) {
                    cur--;
                    remove++;
                    if (cur == 0) {
                        removeAllCount.add(counts[i]);
                        break;
                    }
                }
                uniqueCounts.add(cur);
            }
        }
        return remove;
    }

}

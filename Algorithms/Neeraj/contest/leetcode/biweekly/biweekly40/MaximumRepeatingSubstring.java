package biweekly.biweekly40;

/**
 * Created on:  Nov 28, 2020
 * Questions:
 */

public class MaximumRepeatingSubstring {

    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc", "ab"));
    }

    public static int maxRepeating(String sequence, String word) {
        if (word.length() == 0 || sequence.length() == 0) return 0;
        int k = 0;
        String cur = word;
        while (cur.length() <= sequence.length() && sequence.contains(cur)) {
            k++;
            cur = cur + word;
        }
        return k;
    }
}

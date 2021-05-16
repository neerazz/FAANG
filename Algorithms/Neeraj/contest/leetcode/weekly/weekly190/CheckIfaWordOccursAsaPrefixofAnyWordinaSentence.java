package weekly.weekly190;

/**
 * Created on:  May 23, 2020
 * Questions: https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence
 */
public class CheckIfaWordOccursAsaPrefixofAnyWordinaSentence {
    public static void main(String[] args) {

    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split("\\s+");
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() >= searchWord.length() && split[i].startsWith(searchWord)) {
                return i;
            }
        }
        return -1;
    }
}

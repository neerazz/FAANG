/**
 * Created on:  Sep 07, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=559324704673058
 */
public class MatchingPairs {
    public static void main(String[] args) {

    }

    static int getMatches(String s, String t) {
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            match += s.charAt(i) == t.charAt(i) ? 1 : 0;
        }
        return match;
    }

    static int matchingPairs(String s, String t) {
        int match = getMatches(s, t), result = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int cur = match;
                if (s.charAt(j) == t.charAt(i)) {
                    cur += s.charAt(i) == t.charAt(i) ? 0 : 1;
                } else {
                    cur -= s.charAt(i) == t.charAt(i) ? 1 : 0;
                }
                if (s.charAt(i) == t.charAt(j)) {
                    cur += s.charAt(j) == t.charAt(j) ? 0 : 1;
                } else {
                    cur -= s.charAt(j) == t.charAt(j) ? 1 : 0;
                }
                result = Math.max(result, cur);
            }
        }
        return result;
    }
}

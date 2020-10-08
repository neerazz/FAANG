/**
 * Created on:  Aug 19, 2020
 * Questions: https://leetcode.com/problems/goat-latin/
 */
public class GoatLatin {
    public static void main(String[] args) {

    }

    public static String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        String[] split = S.split(" ");
        int i = 0;

        while (i < split.length) {
            String cur = split[i++];
            if (isVowel(cur)) {
                sb.append(cur).append("ma");
            } else {
                sb.append(cur.substring(1)).append(cur.charAt(0)).append("ma");
            }
            int temp = i;
            while (temp > 0) {
                sb.append("a");
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    private static boolean isVowel(String str) {
        char first = Character.toLowerCase(str.charAt(0));
        return first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u';
    }
}

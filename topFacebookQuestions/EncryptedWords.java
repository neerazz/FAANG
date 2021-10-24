/**
 * Created on:  Sep 08, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=223547538732703
 */
public class EncryptedWords {
    public static void main(String[] args) {
        System.out.println(findEncryptedWord("abc") + " = bac");
        System.out.println(findEncryptedWord("abcd") + " = bacd");
        System.out.println(findEncryptedWord("abcxcba") + " = xbacbca");
        System.out.println(findEncryptedWord("facebook") + " = eafcobok");
    }

    static String findEncryptedWord(String s) {
        if (s.length() < 2) return s;
        int mid = (s.length() - 1) / 2;
        return s.charAt(mid) +
                findEncryptedWord(s.substring(0, mid)) +
                findEncryptedWord(s.substring(mid + 1));
    }
}

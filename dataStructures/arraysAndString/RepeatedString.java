/*
https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class RepeatedString {
    public static void main(String[] args) {
        System.out.println("Answer is:" + repeatedString("aba", 10) + " should be 7.");
        System.out.println("Answer is:" + repeatedString("x", 970770) + " should be 0.");
        System.out.println("Answer is:" + repeatedString("a", Long.parseLong("1000000000000")) + " should be 1000000000000.");
        System.out.println("Answer is:" +
                repeatedString(
                        "epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq",
                        Long.parseLong("549382313570"))
                + " should be 16481469408.");
    }

    static long repeatedString(String s, long n) {
        if (n == 0) return 0;
        int length = s.length();
        long actualOccurrenceValue = getOccurrences(s, s.length());

        if (actualOccurrenceValue == 0) return 0;
        if (length == 1 && actualOccurrenceValue == 1) return n;

        long div = n / length;
        long remainder = n % length;
        return div * actualOccurrenceValue + getOccurrences(s, remainder);
    }

    static long getOccurrences(String s, long value) {
        long count = 0;
        for (int i = 0; i < value; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }
}

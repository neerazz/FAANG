import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1379/
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Answer is: \t" + decodeString("3[a]2[bc]") + "\nshould be \taaabcbc.");
        System.out.println("Answer is: \t" + decodeString("3[a2[c]]") + "\nshould be \taccaccacc.");
        System.out.println("Answer is: \t" + decodeString("2[abc]3[cd]ef") + "\nshould be \tabcabccdcdcdef.");
        System.out.println("Answer is: \t" + decodeString("3[a]2[b4[F]c]") + "\nshould be \taaabFFFFcbFFFFc.");
        System.out.println("Answer is: \t" + decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef") + "\nshould be \tzzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef.");
    }

    public static String decodeString(String s) {
        if (map.containsKey(s)) return map.get(s);
        char[] arr = s.toCharArray();
        int k = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                String num = getNumber(s, i);
                i += (num.length() - 1);
                // i should be at last digit
                k = Integer.parseInt(num);
                String decoded = getDecoded(s, i + 1);
                // Increment i to next encoding
                i += (decoded.length() + 2);
                for (int j = 0; j < k; j++) {
                    sb.append(decodeString(decoded));
                }
            } else if (arr[i] != '[' && arr[i] != ']') {
                sb.append(arr[i]);
            }
        }
        map.put(s, sb.toString());
        return sb.toString();
    }

    private static String getNumber(String s, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    private static String getDecoded(String s, int start) {
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                left++;
            } else if (s.charAt(i) == ']') {
                right++;
            }
            sb.append(s.charAt(i));

            if (left == right) {
                return sb.substring(1, sb.length() - 1);
            }
        }
        return sb.substring(1, sb.length() - 1);
    }

    public static String decodeString_wrong(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char current = chars[i];
            if (Character.isDigit(current)) {
                String getNumber = getNumber(chars, i);
                i += getNumber.length() + 1;
                String getString = getString(chars, i);
                if (!getString.isEmpty()) stringBuilder.append(repeatStringNTimes(getString, getNumber));
            }
            if (current != '$' && Character.isLetter(current)) stringBuilder.append(current);
        }
        return stringBuilder.toString();
    }

    private static String repeatStringNTimes(String getString, String getNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(getNumber); i++) {
            stringBuilder.append(getString);
        }
        return stringBuilder.toString();
    }

    private static String getString(char[] input, int index) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i < input.length; i++) {
            char current = input[i];
            if (current == '$') continue;
            if (Character.isDigit(current)) {
                String getNumber = getNumber(input, i);
                i += getNumber.length() + 1;
                String getString = getString(input, i);
                i += getNumber.length();
                stringBuilder.append(repeatStringNTimes(getString, getNumber));
            } else if (current == ']') {
                break;
            } else {
                stringBuilder.append(current);
                input[i] = '$';
            }
        }
        return stringBuilder.toString();
    }

    private static String getNumber(char[] input, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < input.length; i++) {
            char current = input[i];
            if (Character.isDigit(current)) sb.append(current);
            else break;
        }
        return sb.toString();
    }
}
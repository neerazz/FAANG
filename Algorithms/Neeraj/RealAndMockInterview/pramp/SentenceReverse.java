import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Crated on:  Apr 04, 2020
 */
public class SentenceReverse {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseWords(new char[]{' ', ' '})));
        System.out.println(Arrays.toString(reverseWords(new char[]{'y', 'o', 'u', ' ', 'w', 'i', 't', 'h', ' ', 'b', 'e', ' ', 'f', 'o', 'r', 'c', 'e', ' ', 't', 'h', 'e', ' ', 'm', 'a', 'y'})));
    }

    static char[] reverseWords(char[] arr) {
        if (arr == null || arr.length == 0) return new char[0];
        List<String> input = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c == ' ') {
                input.addAll(Arrays.asList(sb.toString(), " "));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        if (sb.length() != 0) input.add(sb.toString());
        sb = new StringBuilder();
        for (int i = input.size() - 1; i >= 0; i--) {
            sb.append(input.get(i));
        }
        return sb.toString().toCharArray();
    }
}

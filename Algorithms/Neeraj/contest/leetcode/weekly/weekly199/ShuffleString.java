package weekly.weekly199;

import java.util.stream.IntStream;

/**
 * Created on:  Jul 25, 2020
 * Questions: https://leetcode.com/problems/shuffle-string/
 */
public class ShuffleString {
    public static void main(String[] args) {

    }

    public String restoreString(String s, int[] indices) {
        char[] op = new char[s.length()];
        IntStream.range(0, s.length()).forEach(i -> op[indices[i]] = s.charAt(i));
//        for (int i = 0; i < indices.length; i++) {
//            op[indices[i]] = s.charAt(i);
//        }
        return String.valueOf(op);
    }
}

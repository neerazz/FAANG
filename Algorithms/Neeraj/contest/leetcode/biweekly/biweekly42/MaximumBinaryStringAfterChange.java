package biweekly.biweekly42;

import java.util.*;

/**
 * Created on:  Dec 26, 2020
 * Questions:
 */

public class MaximumBinaryStringAfterChange {

    public static void main(String[] args) {
        System.out.println(maximumBinaryString("000110"));
        System.out.println(maximumBinaryString("01"));
        System.out.println(maximumBinaryString("1001011"));
        System.out.println(maximumBinaryString("0000011010101011111001001"));
        System.out.println(maximumBinaryString("101010111011001101000110010001100001111"));
    }

    //    https://www.youtube.com/watch?v=Of73lOvUFQM&feature=emb_title
    public static String maximumBinaryString(String binary) {
        int len = binary.length(), zeros = 0;
        char[] result = new char[len], chars = binary.toCharArray();
        Arrays.fill(result, '1');
        for (char c : chars) zeros += c == '0' ? 1 : 0;
        for (int i = 0; i < len; i++) {
//            When the first zero is encountered, then set that zero after the total number of zero's
//              Ex: 1001011
//                  0123456, zeros = 3
//              Op: 1110111
//            When at index 1, move the zero to the end of  to 1+3-1=3
            if (chars[i] == '0') {
                result[i + zeros - 1] = '0';
            }
        }
        return String.valueOf(result);
    }

    public static String maximumBinaryString_bruteForce(String binary) {
        TreeSet<String> visited = new TreeSet<>();
        Queue<char[]> queue = new LinkedList<>();
        visited.add(binary);
        queue.add(binary.toCharArray());
        int len = binary.length();
        while (!queue.isEmpty()) {
            char[] poll = queue.poll();
            for (int i = 0; i < len - 1; i++) {
                if (poll[i] == '0' && poll[i + 1] == '0') {
                    char[] temp = Arrays.copyOf(poll, len);
                    temp[i] = '1';
                    temp[i + 1] = '0';
                    String tempStr = String.valueOf(temp);
                    if (visited.first().compareTo(tempStr) < 0 && visited.add(tempStr)) {
                        queue.add(temp);
                    }
                } else if (poll[i] == '1' && poll[i + 1] == '0') {
                    char[] temp = Arrays.copyOf(poll, len);
                    temp[i] = '0';
                    temp[i + 1] = '1';
//                    if (visited.add(String.valueOf(temp))) {
//                        queue.add(temp);
//                    }
                    String tempStr = String.valueOf(temp);
                    if (visited.first().compareTo(tempStr) > 0 && visited.add(tempStr)) {
                        queue.add(temp);
                    }
                }
            }
        }
        return visited.last();
    }
}

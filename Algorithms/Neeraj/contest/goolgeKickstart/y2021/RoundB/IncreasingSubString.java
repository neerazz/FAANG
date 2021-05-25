package y2021.RoundB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created on:  May 16, 2021
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435a5b/000000000077a882
 */

public class IncreasingSubString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        String[] result = new String[tests];
        for (int i = 0; i < tests; i++) {
            int len = sc.nextInt();
            String string = sc.next();
            int[] current = getSubString(string, len);
            result[i] = Arrays.stream(current).boxed().map(String::valueOf).collect(Collectors.joining(" "));
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int[] getSubString(String str, int len) {
        int[] result = new int[len];
        Arrays.fill(result, 1);
        for (int i = 1; i < len; i++) {
            if (str.charAt(i - 1) < str.charAt(i)) {
                result[i] += result[i - 1];
            }
        }
        return result;
    }
}

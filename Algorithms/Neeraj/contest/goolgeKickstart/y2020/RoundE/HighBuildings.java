package y2020.RoundE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created on:  Aug 22, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff47/00000000003bef73
 */
public class HighBuildings {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = fr.nextInt();
        String[] result = new String[tests];
        for (int i = 0; i < tests; i++) {
            int n = fr.nextInt(), a = fr.nextInt(), b = fr.nextInt(), c = fr.nextInt();
            result[i] = getBuildingHeights(n, a, b, c);
        }

        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static String getBuildingHeights(int n, int a, int b, int c) {
//        Check if possible.
        if (a - c + b > n) return "IMPOSSIBLE";
        if (n == 1) return "1";
//        Take the highest and arrange in center.
        int heights = n;
        LinkedList<Integer> list = new LinkedList<>();
//        Append the heights building in the center.
        for (int i = 0; i < c; i++) list.add(heights);
        heights--;

//        Keep appending a-c buildings in the left side.
        for (int i = 0; i < a - c; i++) list.addFirst(heights--);
//        Keep appending b-c buildings in the right side.
        for (int i = 0; i < b - c; i++) list.add(heights--);

        while (list.size() < n) list.add(1, heights--);

        return list.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}

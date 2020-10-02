package contest1426;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

/**
 * Created on:  Oct 01, 2020
 * Questions: https://codeforces.com/contest/1426/problem/F
 */
public class NumberOfSubsequences {
    static int count = 0, mod = 1_000_000_007;
    static Set<String> visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int n = sc.nextInt();
        String str = sc.next();
        count = 0;
        calculateNumberOfSubsequences(n, str);
        System.out.println(count);
    }

    private static void calculateNumberOfSubsequences(int n, String str) {

    }

    private static void calculateNumberOfSubsequences_naive(int n, String str) {
        visited = new HashSet<>();
        char[] chars = str.toCharArray();
        Set<Integer> questions = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') questions.add(i);
        }
        checkAllCombinations(chars, questions);
    }

    private static void checkAllCombinations(char[] chars, Set<Integer> questions) {
        if (questions.isEmpty()) {
            if (visited.add(String.valueOf(chars))) {
                calculateSubsequences(chars);
//            calculateSubsequences_naive(String.valueOf(chars));
            }
        } else {
//            Keep all the letters
            Set<Integer> temp = new HashSet<>(questions);
            for (int idx : questions) {
                temp.remove(idx);
                for (int i = 0; i < 3; i++) {
                    chars[idx] = (char) ('a' + i);
                    checkAllCombinations(chars, temp);
                }
            }
        }
    }

    private static void calculateSubsequences(char[] chars) {
//        System.out.println("chars = " + Arrays.toString(chars));
        long a = 0, ab = 0, abc = 0;
        for (char cur : chars) {
            if (cur == 'a') a++;
            if (cur == 'b') ab += a;
            if (cur == 'c') abc += ab;
        }
        count = (int) ((count + abc) % mod);
    }

    private static void calculateSubsequences_naive(char[] chars) {
        long cur = 0;
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>(), c = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') a.add(i);
            if (chars[i] == 'b') b.add(i);
            if (chars[i] == 'c') c.add(i);
        }
        for (int aIdx : a) {
            for (int bIdx : b) {
                if (bIdx < aIdx) continue;
                for (int cIdx : c) {
                    if (cIdx < bIdx) continue;
                    cur++;
                }
            }
        }
        cur %= mod;
//        if (cur > 0)
//            System.out.println("chars = " + chars + " cur = " + cur);
        count = (int) ((count + cur) % mod);
    }
}

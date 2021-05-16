package biweekly.biweekly27;

import java.util.*;

/**
 * Created on:  May 30, 2020
 * Questions:
 */
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public static void main(String[] args) {
        System.out.println("*********************** Method 1 *************************");
        System.out.println(hasAllCodes("00110110", 2) + "\tshould be [true].");
        System.out.println(hasAllCodes("00110", 2) + "\tshould be [true].");
        System.out.println(hasAllCodes("0110", 1) + "\tshould be [true].");
        System.out.println(hasAllCodes("0110", 2) + "\tshould be [false].");
        System.out.println(hasAllCodes("0000000001011100", 4) + "\tshould be [false].");
        System.out.println(hasAllCodes("110101011011000011011111000000", 5) + "\tshould be [false].");
        System.out.println(hasAllCodes("0101", 13) + "\tshould be [false].");

        System.out.println("*********************** Method 2 *************************");
        System.out.println(hasAllCodes_correct("00110110", 2) + "\tshould be [true].");
        System.out.println(hasAllCodes_correct("00110", 2) + "\tshould be [true].");
        System.out.println(hasAllCodes_correct("0110", 1) + "\tshould be [true].");
        System.out.println(hasAllCodes_correct("0110", 2) + "\tshould be [false].");
        System.out.println(hasAllCodes_correct("0000000001011100", 4) + "\tshould be [false].");
        System.out.println(hasAllCodes_correct("110101011011000011011111000000", 5) + "\tshould be [false].");
        System.out.println(hasAllCodes_correct("0101", 13) + "\tshould be [false].");
        System.out.println(hasAllCodes_correct("1011110111001001101001110001100111101111010101011100111001110010010001000111010110101110000110101001011100100010100110011101011110001000100010101101011"
                ,20) + "\tshould be [false].");

        System.out.println("*********************** Method 3 *************************");
        System.out.println(hasAllCodes_optimal_Space("00110110", 2) + "\tshould be [true].");
        System.out.println(hasAllCodes_optimal_Space("00110", 2) + "\tshould be [true].");
        System.out.println(hasAllCodes_optimal_Space("0110", 1) + "\tshould be [true].");
        System.out.println(hasAllCodes_optimal_Space("0110", 2) + "\tshould be [false].");
        System.out.println(hasAllCodes_optimal_Space("0000000001011100", 4) + "\tshould be [false].");
        System.out.println(hasAllCodes_optimal_Space("110101011011000011011111000000", 5) + "\tshould be [false].");
        System.out.println(hasAllCodes_optimal_Space("0101", 13) + "\tshould be [false].");
        System.out.println(hasAllCodes_optimal_Space("1011110111001001101001110001100111101111010101011100111001110010010001000111010110101110000110101001011100100010100110011101011110001000100010101101011"
                ,20) + "\tshould be [false].");

        System.out.println("*********************** Method 4 *************************");
        System.out.println(hasAllCodes_optimal_time("00110110", 2) + "\tshould be [true].");
        System.out.println(hasAllCodes_optimal_time("00110", 2) + "\tshould be [true].");
        System.out.println(hasAllCodes_optimal_time("0110", 1) + "\tshould be [true].");
        System.out.println(hasAllCodes_optimal_time("0110", 2) + "\tshould be [false].");
        System.out.println(hasAllCodes_optimal_time("0000000001011100", 4) + "\tshould be [false].");
        System.out.println(hasAllCodes_optimal_time("110101011011000011011111000000", 5) + "\tshould be [false].");
        System.out.println(hasAllCodes_optimal_time("0101", 13) + "\tshould be [false].");
        System.out.println(hasAllCodes_optimal_time("1011110111001001101001110001100111101111010101011100111001110010010001000111010110101110000110101001011100100010100110011101011110001000100010101101011"
                ,20) + "\tshould be [false].");
    }

//    Runtime: O(N)
    public static boolean hasAllCodes_optimal_time(String s, int k) {
        if (s.length() <= k) return false;
//        There can be total 2 ^K possibilities.
        int possibilities = (int) Math.pow(2, k);
        Set<String> set = new HashSet<>();
        StringBuilder cur = new StringBuilder();
        int end = 0;
//            Collect all the unique possible substring of size K
        while (end < k - 1) {
            cur.append(s.charAt(end++));
        }
        while (end < s.length()) {
//            Add the end element to string.
            cur.append(s.charAt(end++));
//            Add it to list.
            set.add(cur.toString());
//            Remove the first element from the list.
            cur.deleteCharAt(0);
        }
//        The unique possibility size should be 2^K so satisfy the condition.
        return set.size() >= possibilities;
    }

    //     Runtime: O(2^K)
    public static boolean hasAllCodes_optimal_Space(String s, int k) {
        if (s.length() <= k) return false;
        boolean[] possibilities = new boolean[(int) Math.pow(2, k)];
        for (int i = 0; i + k <= s.length(); i++) {
            possibilities[Integer.parseInt(s.substring(i, i + k), 2)] = true;
        }
        for(boolean possible: possibilities){
            if(!possible) return false;
        }
        return true;
    }

    //     Runtime: O(2^K)
    public static boolean hasAllCodes_correct(String s, int k) {
        if (s.length() <= k) return false;
        Set<String> list = getAllPossible(k);
        Set<String> subSetOfS = new HashSet<>();
        String cur = "";
        int end = 0;
        while (end < k - 1) {
            cur += s.charAt(end++);
        }
        while (end < s.length()) {
            cur += s.charAt(end++);
            subSetOfS.add(cur);
            cur = cur.substring(1);
        }
        for (String str : list) {
            if (!subSetOfS.contains(str)) {
                return false;
            }
        }
        return true;
    }

    //     Runtime: O(2^K)
    public static boolean hasAllCodes(String s, int k) {
        Set<String> list = getAllPossible(k);
        for (String str : list) {
            int[] counts = new int[2];
            for (char c : str.toCharArray()) counts[c - '0']++;
            int start = 0, end = 0;
            boolean found = false;
            while (end < s.length()) {
                if (counts[s.charAt(end) - '0'] > 0) {
                    counts[s.charAt(end) - '0']--;
                    end++;
                } else if (start == end) {
                    start++;
                    end++;
                } else {
                    counts[s.charAt(start) - '0']++;
                    start++;
                }
                if (end - start == k) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    static Map<Integer, Set<String>> memo = new HashMap<>();

    private static Set<String> getAllPossible(int k) {
        if (k == 0) return new HashSet<>(Collections.singletonList(""));
        if (memo.containsKey(k)) return memo.get(k);
        Set<String> op = new HashSet<>();
        for (String str : getAllPossible(k - 1)) {
            op.add("0" + str);
            op.add("1" + str);
        }
        memo.put(k, op);
        return op;
    }
}

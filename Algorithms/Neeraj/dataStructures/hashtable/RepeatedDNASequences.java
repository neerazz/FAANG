import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Created on:  Oct 17, 2020
 * Questions: https://leetcode.com/problems/repeated-dna-sequences/
 */

public class RepeatedDNASequences {

    public static void main(String[] args) {

    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String cur = s.substring(i, i + 10);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return map.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).collect(Collectors.toList());
    }
}

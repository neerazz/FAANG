import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/discuss/interview-question/989768/Amazon-or-OA-2020-or-Transaction-logs
 */

public class TransactionLogs {

    public static void main(String[] args) {
        System.out.println(getFraudIds(new String[]{
                "345366 89921 45",
                "029323 38239 23",
                "029323 38239 77",
                "345366 38239 23",
                "38239 38239 23",
                "029323 345366 13",
                "38239 345366 15"}, 3));

        System.out.println(getFraudIds(new String[]{
                "345366 89921 45",
                "029323 38239 23",
                "029323 38239 77",
                "345366 38239 23",
                "38239 38239 23",
                "029323 345366 13",
                "38239 345366 15"}, 4));
    }

    private static List<String> getFraudIds(String[] logs, int threshold) {
        Map<String, Integer> counts = new HashMap<>();
        for (String log : logs) {
            String[] cur = log.split(" ");
            String u1 = cur[0], u2 = cur[1];
            if (u1.equals(u2)) {
                counts.put(u1, counts.getOrDefault(u1, 0) + 1);
            } else {
                counts.put(u1, counts.getOrDefault(u1, 0) + 1);
                counts.put(u2, counts.getOrDefault(u2, 0) + 1);
            }
        }
        return counts.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= threshold)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }
}

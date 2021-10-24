import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Created on:  May 26, 2021
 * Questions: https://www.javacodemonk.com/top-10-occurring-words-in-a-very-large-file-java-algorithm-f42e0e67
 */

public class SplitWordCount {

    public static void main(String[] args) {
        List<String> terms = Arrays.asList(
                "Coding is great",
                "Search Engine are great",
                "Google is a nice search engine",
                "Bing is also a nice engine");
        System.out.println("*************************** Solution 1 **************************");
        printTop(terms, 10);
        System.out.println("*************************** Solution 2 **************************");
        printTop_flatMap(terms, 10);
        System.out.println("*************************** Solution 3 **************************");
        printTop_pq(terms, 10);
    }

    private static void printTop_pq(List<String> strings, int k) {

    }

    private static void printTop_flatMap(List<String> strings, int k) {
        ConcurrentMap<String, Integer> map = strings.parallelStream()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .collect(Collectors.toConcurrentMap(String::toLowerCase, word -> 1, Integer::sum));
//        Get the top K occurrences
        var collect = map.values().parallelStream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .collect(Collectors.toMap(occ -> occ, val -> new ArrayList<String>()));
        map.entrySet().parallelStream()
                .filter(entry -> collect.containsKey(entry.getValue()))
                .forEachOrdered(entry -> collect.get(entry.getValue()).add(entry.getKey()));
        collect.entrySet().forEach(System.out::println);
    }

    private static void printTop(List<String> strings, int k) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        strings.parallelStream()
                .map(string -> Arrays.stream(string.split(" ")))
                .forEach(stringStream -> stringStream
                        .map(String::toLowerCase)
                        .forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1)));
//        Get the top K occurrences
        var collect = map.values().stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .collect(Collectors.toConcurrentMap(val -> val, values -> new ArrayList<String>()));
        map.entrySet().parallelStream()
                .filter(entry -> collect.containsKey(entry.getValue()))
                .forEach(entry -> collect.get(entry.getValue()).add(entry.getKey()));
        collect.entrySet().forEach(System.out::println);
    }
}
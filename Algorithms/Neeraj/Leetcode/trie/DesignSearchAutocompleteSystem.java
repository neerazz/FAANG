package trie;

import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1054/
 */
public class DesignSearchAutocompleteSystem {
    public static void main(String[] args) {
        AutocompleteSystem autocompleteSystem =
                new AutocompleteSystem(new String[]{"i love you", "island", "ironman", "i love leetcode"}, new int[]{5, 3, 2, 2});
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
        System.out.println(autocompleteSystem.map);
    }
}

class AutocompleteSystem {

    Map<String, Integer> map;
    String input;
    private Comparator<Map.Entry<String, Integer>> comparator = (e1, e2) -> {
        int compareTo = e2.getValue().compareTo(e1.getValue());
        if (compareTo == 0) {
            return e1.getKey().compareTo(e2.getKey());
        } else {
            return compareTo;
        }
    };

    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new HashMap<>();
        input = null;
        for (int i = 0; i < sentences.length; i++) {
            map.put(sentences[i], times[i]);
        }
        sortMap();
    }

    private void sortMap() {
        map = map.entrySet().stream().sorted(comparator).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public List<String> input(char c) {
        if (c == '#') {
            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else {
                map.put(input, 1);
            }
            sortMap();
            input = null;
            return new ArrayList<>();
        }
        input = input == null ? String.valueOf(c) : input + c;
        return map.entrySet().stream()
                .filter(e -> e.getKey().startsWith(input)).limit(3)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
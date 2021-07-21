import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1054/
 */
public class DesignSearchAutocompleteSystem {
    public static void main(String[] args) {
        System.out.println("**************************************** Solution 1 ***********************************");
        System.out.println("**************************************** Test 1 ***********************************");
        AutocompleteSystem autocompleteSystem =
                new AutocompleteSystem(new String[]{"i love you", "island", "ironman", "i love leetcode"}, new int[]{5, 3, 2, 2});
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
        System.out.println(autocompleteSystem.map);

        System.out.println("**************************************** Test 2 ***********************************");
        autocompleteSystem =
                new AutocompleteSystem(new String[]{"i love you", "island", "ironman", "i love leetcode"}, new int[]{5, 3, 2, 2});
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
        System.out.println(autocompleteSystem.map);

        System.out.println("**************************************** Solution 2 ***********************************");
        System.out.println("**************************************** Test 1 ***********************************");
        AutocompleteSystem_rev1 autocompleteSystem_rev1 =
                new AutocompleteSystem_rev1(new String[]{"i love you", "island", "ironman", "i love leetcode"}, new int[]{5, 3, 2, 2});
        System.out.println(autocompleteSystem_rev1.input('i'));
        System.out.println(autocompleteSystem_rev1.input(' '));
        System.out.println(autocompleteSystem_rev1.input('a'));
        System.out.println(autocompleteSystem_rev1.input('#'));
        System.out.println(autocompleteSystem_rev1.trie.map);

        System.out.println("**************************************** Test 2 ***********************************");
        autocompleteSystem_rev1 =
                new AutocompleteSystem_rev1(new String[]{"i love you", "island", "ironman", "i love leetcode"}, new int[]{5, 3, 2, 2});
        System.out.println(autocompleteSystem_rev1.input('i'));
        System.out.println(autocompleteSystem_rev1.input(' '));
        System.out.println(autocompleteSystem_rev1.input('a'));
        System.out.println(autocompleteSystem_rev1.input('#'));
        System.out.println(autocompleteSystem_rev1.input('i'));
        System.out.println(autocompleteSystem_rev1.input(' '));
        System.out.println(autocompleteSystem_rev1.input('a'));
        System.out.println(autocompleteSystem_rev1.input('#'));
        System.out.println(autocompleteSystem_rev1.input('i'));
        System.out.println(autocompleteSystem_rev1.input(' '));
        System.out.println(autocompleteSystem_rev1.input('a'));
        System.out.println(autocompleteSystem_rev1.input('#'));
        System.out.println(autocompleteSystem_rev1.trie.map);
    }
}

class AutocompleteSystem_rev1 {
    Trie trie;
    StringBuilder sb = new StringBuilder();

    public AutocompleteSystem_rev1(String[] sentences, int[] times) {
        trie = new Trie(' ');
        int len = times.length;
        for (int i = 0; i < len; i++) {
            trie.build(sentences[i], 0, times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            List<String> result = trie.getSuggestion(sb.toString(), 0);
            trie.build(sb.toString(), 0, 1);
            sb = new StringBuilder();
            return result;
        } else if (Character.isLowerCase(c) || c == ' ') {
            sb.append(c);
            List<String> result = trie.getSuggestion(sb.toString(), 0);
            trie.addSearchSuggestion(sb.toString(), 0);
            return result;
        } else {
            sb = new StringBuilder();
            return new ArrayList<>();
        }
    }

    static class Trie {
        Trie[] trie = new Trie[27];
        char cur;
        boolean isEnd;
        Map<String, Integer> map = new HashMap<>();

        Trie(char cur) {
            this.cur = cur;
        }

        @Override
        public String toString() {
            return "Trie{" +
                    "trie=" + Arrays.toString(trie) +
                    ", cur=" + cur +
                    ", map=" + map +
                    '}';
        }

        int getIdx(char c) {
            return c == ' ' ? 26 : c - 'a';
        }

        void build(String str, int i, int freq) {
            char c = str.charAt(i);
            int idx = getIdx(c);
            Trie current = trie[idx];
            if (current == null) {
                trie[idx] = current = new Trie(c);
            }
            if (i == str.length() - 1) {
                current.isEnd = true;
            } else {
                current.build(str, i + 1, freq);
            }
            addFreq(str, freq);
        }

        private void addFreq(String str, int freq) {
            map.put(str, map.getOrDefault(str, 0) + freq);
        }

        List<String> getTop() {
            return map.entrySet().stream()
                    .sorted((e1, e2) -> e1.getValue().equals(e2.getValue()) ? e1.getKey().compareTo(e2.getKey()) : Integer.compare(e2.getValue(), e1.getValue())).limit(3)
                    .map(entry -> entry.getKey()).collect(Collectors.toList());
        }

        public List<String> getSuggestion(String str, int idx) {
            if (str.length() == idx) {
                return getTop();
            }
            char c = str.charAt(idx);
            Trie t = trie[getIdx(c)];
            if (t == null) return new ArrayList<>();
            return t.getSuggestion(str, idx + 1);
        }

        public void addSearchSuggestion(String str, int i) {
            if (map.containsKey(str)) {
                addFreq(str, 1);
                Trie t = trie[getIdx(str.charAt(i))];
                if (t != null) t.addSearchSuggestion(str, i + 1);
            }
        }
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
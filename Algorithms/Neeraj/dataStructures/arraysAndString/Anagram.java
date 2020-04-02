import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(stringAnagram(Arrays.asList("heater","cold","clod","reheat","docl"),Arrays.asList("codl","heater","abcd")));
    }
    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        // Collect all the words with its sorted values and the unsorted array.
        Map<String, Integer> map = new HashMap<>();
        for(String word: dictionary){
            String sorted = sortByChars(word);
            map.put(sorted, map.getOrDefault(sorted,0)+1);
        }
        List<Integer> op = new ArrayList<>();
        for(String q: query){
            String sorted = sortByChars(q);
            op.add(map.getOrDefault(sorted,0));
        }
        return op;
    }

    static String sortByChars(String input){
        char[] wordChars = input.toCharArray();
        Arrays.sort(wordChars);
        return new StringBuilder().append(wordChars).toString();
    }
}

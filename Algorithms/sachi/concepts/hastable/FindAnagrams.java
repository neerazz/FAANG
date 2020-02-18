import java.util.*;

public class FindAnagrams {

    public static List<List<String>> findAnagrams(List<String> dictionary) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> cache = new HashMap<>();

        dictionary.forEach(unsorted -> {
            char[] chars = unsorted.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (cache.containsKey(sorted)) {
                cache.get(sorted).add(unsorted);
            } else {
                List<String> unsortedItems = new ArrayList<>();
                unsortedItems.add(unsorted);
                cache.put(sorted, unsortedItems);
            }
        });

        for (String str : cache.keySet()) {
            List<String> anagrams = cache.get(str);
            if (anagrams.size() > 1) {
                result.add(anagrams);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<String> strings = Arrays.asList("debitcard", "elvis", "silent", "badcredit", "lives", "freedom", "listen", "levis", "money");
        System.out.println(findAnagrams(strings));
    }

}

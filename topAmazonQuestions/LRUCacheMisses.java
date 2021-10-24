import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/discuss/interview-question/992179/Amazon-or-OA-2021-or-LRU-Cache-Misses
 */

public class LRUCacheMisses {

    public static void main(String[] args) {
        System.out.println(lruCacheMisses(6, Arrays.asList("1", "2", "1", "3", "1", "2"), 2));
        System.out.println(lruCacheMisses(10, Arrays.asList("1", "2", "1", "3", "1", "2", "5", "7", "1", "5", "7", "1"), 4));
        System.out.println(lruCacheMisses(10, Arrays.asList("1", "2", "1", "3", "1", "2", "5", "3", "1", "5", "3", "1"), 6));
    }

    private static int lruCacheMisses_int(int num, List<Integer> pages, int maxCacheSize) {
//        If the max cache size is zero. Then every element will be a new item.
        if (maxCacheSize == 0) return pages.size();
        LinkedHashSet<Integer> cache = new LinkedHashSet<>();
        int count = 0;
        for (int page : pages) {
            if (cache.contains(page)) {
//                Move the element to the end.
                cache.remove(page);
                cache.add(page);
            } else {
                if (cache.size() == maxCacheSize) {
//                    If cache is full, then get the first element and remove from cache
                    int first = cache.stream().findFirst().get();
                    cache.remove(first);
                }
                cache.add(page);
                count++;
            }
        }
        return count;
    }

    private static int lruCacheMisses(int num, List<String> pages, int maxCacheSize) {
//        If the max cache size is zero. Then every element will be a new item.
        if (maxCacheSize == 0) return pages.size();
        LinkedHashSet<String> cache = new LinkedHashSet<>();
        int count = 0;
        for (String page : pages) {
            if (cache.contains(page)) {
//                Move the element to the end.
                cache.remove(page);
                cache.add(page);
            } else {
                if (cache.size() == maxCacheSize) {
//                    If cache is full, then get the first element and remove from cache
                    String first = cache.stream().findFirst().get();
                    cache.remove(first);
                }
                cache.add(page);
                count++;
            }
        }
        return count;
    }
}

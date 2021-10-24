import java.util.*;

/*
https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1177/
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.
 */
public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}))
        );
        System.out.println(
                Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"KFC", "Shogun", "Burger King"}))
        );
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> set = new ArrayList<>(Arrays.asList(list1));
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            String current = list2[i];
            if (set.contains(current)) {
                int index = set.indexOf(current) + i;
                map.put(current, index);
                minValue = Math.min(minValue, index);
            }
        }
        int finalMinValue = minValue;
        return map.entrySet().stream().filter(e -> e.getValue() == finalMinValue).map(Map.Entry::getKey).toArray(String[]::new);
    }
}

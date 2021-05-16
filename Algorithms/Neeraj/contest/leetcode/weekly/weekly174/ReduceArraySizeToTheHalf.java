package weekly.weekly174;

import java.util.*;
import java.util.stream.Collectors;

/*
Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
Return the minimum size of the set so that at least half of the integers of the array are removed.

Example 1:
Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
Example 2:
Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.
Example 3:
Input: arr = [1,9]
Output: 1
Example 4:
Input: arr = [1000,1000,3,7]
Output: 1
Example 5:
Input: arr = [1,2,3,4,5,6,7,8,9,10]
Output: 5

Constraints:
1 <= arr.length <= 10^5
arr.length is even.
1 <= arr[i] <= 10^5
 */
public class ReduceArraySizeToTheHalf {
    public static void main(String[] args) {
        System.out.println(minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}) + " should be [2].");
        System.out.println(minSetSize(new int[]{7,7,7,7,7,7}) + " should be [1].");
        System.out.println(minSetSize(new int[]{1,9}) + " should be [1].");
        System.out.println(minSetSize(new int[]{1000,1000,3,7}) + " should be [1].");
        System.out.println(minSetSize(new int[]{1,2,3,4,5,6,7,8,9,10}) + " should be [5].");
        System.out.println(minSetSize(new int[]{9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19}) + " should be [5].");
    }

    public static int minSetSize_similar(int[] arr) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int n = arr.length;
        n /= 2;

        //count occurence of each element in array
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);

        //if no item is repeated
        if(arr.length == map.size())
            return n;

        int c = 0, c1 = 0, k = 0;

        while(c == 0) {
            //find most frequent character
            Map.Entry<Integer, Integer> maxEntry = null;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                    maxEntry = entry;
            }
            c1 += maxEntry.getValue();
            k++;
            map.replace(maxEntry.getKey(), Integer.MIN_VALUE);
            if(c1 >= n)
                c = 1;
        }
        return k;
    }

//    My Solution, few test cases failed.
    public static int minSetSize(int[] arr) {
        int size = arr.length, requiredSize = size/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int cur = arr[i];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

//        If no item is repeated
        if(arr.length == map.size()){
            return requiredSize;
        }
//        If every thing is repeated.
        if (map.size() == 1){
            return 1;
        }

        List<Integer> integers = map.values().stream().sorted().collect(Collectors.toList());
        int combinations = Integer.MAX_VALUE, sum = 0, start = 0, valuesConsidered = 0 , firstPointer = 0;
        while (start < integers.size()){
            sum += integers.get(start);
            valuesConsidered ++;
            while (sum >= requiredSize){
                combinations = Math.min(combinations,valuesConsidered);
                sum -= integers.get(firstPointer++);
                valuesConsidered--;
            }
            start++;
        }
        return combinations;
    }
}

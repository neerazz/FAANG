import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  Sep 25, 2020
 * Questions: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3472/
 */
public class LargestNumber {
    public static void main(String[] args) {

    }

    public static String largestNumber(int[] nums) {
        List<String> list = Arrays.stream(nums).boxed()
                .map(Object::toString)
                .sorted((v1, v2) -> compare(v1, v2))
                .collect(Collectors.toList());
        return list.isEmpty() || list.get(0).equals("0") ? "0" : String.join("", list);
    }

    private static int compare(String a, String b) {
        // System.out.println(a + " and  " + b);
        String str1 = a + b, str2 = b + a;
        return str2.compareTo(str1);
    }
}

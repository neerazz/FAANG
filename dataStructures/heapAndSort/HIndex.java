import java.util.Arrays;

/**
 * Created on:  Aug 11, 2020
 * Questions: https://leetcode.com/problems/h-index/
 */
public class HIndex {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{0}) + " = 0");
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}) + " = 3");
        System.out.println(hIndex(new int[]{100}) + " = 1");
    }

    public static int hIndex(int[] citations) {
        int result = 0, equalAndGreater = 0;
        Arrays.sort(citations);
//        Start from end, and keep the count of citations.
//          if number of citations soFar is greater than then current value. That could be the answer.
//        Keep the max of all possible answers.
        for (int i = citations.length - 1; i >= 0; i--) {
            equalAndGreater++;
            if (citations[i] >= equalAndGreater) result = Math.max(result, equalAndGreater);
        }
        return result;
    }
}

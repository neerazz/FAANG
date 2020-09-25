import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Sep 24, 2020
 * Questions:
 * Given a non-empty array N, of non-negative integers , the degree of this array is defined as the maximum frequency of any one of its elements. Your task is to find the smallest possible length of a (contiguous) subarray of N, that has the same degree as N. For example, in the array [1 2 2 3 1], integer 2 occurs maximum of twice. Hence the degree is 2.
 * <p>
 * Input
 * <p>
 * Test case input contains 2 lines.
 * First line contains an integer T, representing the number of elements in the array.
 * The second line contains the array N, list of T integers each separated by space.
 * <p>
 * Output
 * <p>
 * Print the length of the smallest contiguous subarray of input array N, that has the same degree as N.
 * Code evaluation is based on your output, please follow the sample format and do NOT print anything else.
 */
public class DegreeOfAnArray {
    public static void main(String[] args) throws Exception {
        String inputData = "";
        String thisLine = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((thisLine = br.readLine()) != null) {
            inputData += thisLine + "\n";
        }
        System.out.println(codeHere(inputData));
    }

    public static String codeHere(String inputData) {
        // Get the starting, ending and degree of each elements in the array.
        Map<String, int[]> map = new HashMap<>();
        String[] split = inputData.split("\\s+");
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            int[] cur = map.getOrDefault(split[i], new int[]{i, i, 0});
            // Set the end point to current point, and increase the degree, every time an element is found
            cur[1] = i;
            cur[2]++;
            map.put(split[i], cur);
            max = Math.max(max, cur[2]);
        }
        int len = Integer.MAX_VALUE;
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            int[] cur = entry.getValue();
            if (cur[2] == max) {
                len = Math.min(len, cur[1] - cur[0] + 1);
            }
        }
        if (len == Integer.MAX_VALUE) {
            // It is not apossilbe
            return "Not Possible";
        } else {
            return "" + len;
        }
    }
}

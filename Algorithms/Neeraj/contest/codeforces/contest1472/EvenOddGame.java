package contest1472;

import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 28, 2021
 * Questions:
 */

public class EvenOddGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Integer[] nums = new Integer[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            long score = 0;
            Arrays.sort(nums, (v1, v2) -> Integer.compare(v2, v1));
            for (int j = 0; j < n; j++) {
//                If the index is even and value is also even then alice takes the score.
                if (j % 2 == 0 && nums[j] % 2 == 0) score += nums[j];
//                If index is odd and score is odd, the the score goies to Bon, since we are only taking the diff reduce.
                else if (j % 2 == 1 && nums[j] % 2 == 1) score -= nums[j];
            }
            if (score > 0) System.out.println("Alice");
            else if (score < 0) System.out.println("Bob");
            else System.out.println("Tie");
        }
    }
}

/*
    Created on:  May 06, 2020
 */

import java.util.Arrays;

/**
 * Questions: https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/pairs-having-similar-element-eed098aa/
 */
public class PairsHavingSimilarElements {
    public static void main(String[] args) {
        System.out.println(SimilarElementsPairs(new int[]{1, 3, 5, 7, 8, 2, 5, 7}, 8));
    }

    static long SimilarElementsPairs(int[] A, int N) {
        long count = 0, sCount = 1, dCount = 1;
        Arrays.sort(A);
        for (int i = 1; i < N; i++) {
            if (A[i] == A[i - 1]) {
                sCount++;
            } else if (A[i] == A[i - 1] + 1) {
                sCount++;
                dCount++;
            } else {
//                If continues pairs have the satisfied condition.
                if (sCount >= 2 && dCount >= 2) {
//                    Find teh sum of all the counts
                    count += ((sCount) * (sCount - 1)) / 2;
                }
                sCount = 1;
                dCount = 1;
            }
        }
        if (sCount >= 2 && dCount >= 2) {
            count += ((sCount) * (sCount - 1)) / 2;
        }
        return count;
    }
}

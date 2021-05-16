package biweekly.biweekly29;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Jun 27, 2020
 * Questions:https://leetcode.com/problems/the-kth-factor-of-n
 */
public class TheKthFactorOfN {
    public static void main(String[] args) {

    }

    public static int kthFactor(int n, int k) {
        List<Integer> facts = new ArrayList<>();
        int idx = 1;
        while (idx <= n && facts.size() < k) {
            if (n % idx == 0) {
                facts.add(idx);
            }
            idx++;
        }
        return facts.isEmpty() || facts.size() < k ? -1 : facts.get(k - 1);
    }
}

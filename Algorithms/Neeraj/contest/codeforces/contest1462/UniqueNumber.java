package contest1462;

import java.util.*;
import java.io.*;

/**
 * Created on:  Dec 19, 2020
 * Questions: https://codeforces.com/contest/1462/problem/C
 */

public class UniqueNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(getNumber(sc.nextInt()));
        }
    }

    private static int getNumber(int num) {
        if (num > 45) return -1;
        boolean[] taken = new boolean[10];
        List<Integer> nums = getNumber(taken, num);
        Collections.sort(nums);
        int result = 0;
        for (int n : nums) {
            result = result * 10 + n;
        }
        return result;
    }

    private static List<Integer> getNumber(boolean[] taken, int num) {
        List<Integer> list = new ArrayList<>();
        if (num < 0) return list;
        if (num == 0) {
            list.add(0);
        } else {
            for (int i = 9; i >= 0; i--) {
                if (taken[i]) continue;
                taken[i] = true;
                List<Integer> next = getNumber(taken, num - i);
                if (!next.isEmpty()) {
                    list.add(i);
                    list.addAll(next);
                    break;
                }
                taken[i] = false;
            }
        }
        return list;
    }
}

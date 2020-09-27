package y2020.RoundF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on:  Sep 26, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff48/00000000003f4ed8
 */
public class ATMQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        String[] result = new String[tests];
        for (int i = 0; i < tests; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
//            result[i] = getOrder(n, x, nums);
            result[i] = getOrder_Optimal(n, x, nums);
        }

        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static String getOrder_Optimal(int n, int x, int[] nums) {
//        0 : round number, 1 : index
        LinkedList<int[]> temp = new LinkedList<>();
        LinkedList<Integer> op = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int round = nums[i] / x;
            if (nums[i] % x > 0) round++;
            temp.add(new int[]{round, i + 1});
        }
        Collections.sort(temp, (v1, v2) -> v1[0] == v2[0] ? v2[1] - v1[1] : v2[0] - v1[0]);
        for (int[] val : temp) {
            op.add(0, val[1]);
        }
        return op.stream().map(Object::toString).collect(Collectors.joining(" "));
    }

    private static String getOrder(int n, int x, int[] nums) {
//        0: rem , 1 : idx
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> op = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= x) op.add(i + 1);
            else queue.add(new int[]{nums[i] - x, i});
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] <= x) {
                op.add(poll[1] + 1);
            } else {
                poll[0] -= x;
                queue.add(poll);
            }
        }
        return op.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}

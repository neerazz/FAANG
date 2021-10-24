import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created on:  Oct 30, 2020
 * Questions: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 */

public class FindNUniqueIntegersSumUpToZero {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
    }

    public static int[] sumZero(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        int len = n;
        int[] result = new int[n];
        if (n % 2 == 1) {
            list.add(0);
            n--;
        }
        int num = 1;
        while (n > 0) {
            list.addFirst(-1 * num);
            list.addLast(num);
            num++;
            n -= 2;
        }
        for (int i = 0; i < len; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

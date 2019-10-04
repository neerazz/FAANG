import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/ugly-number-ii/
Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
Example:
Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:
1 is typically treated as an ugly number.
n does not exceed 1690.
 */
public class UglyNumberII {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10) + " should be " + nthUglyNumber_elegant(10));
        System.out.println(nthUglyNumber(103) + " should be " + nthUglyNumber_elegant(103));
        System.out.println(nthUglyNumber(253) + " should be " + nthUglyNumber_elegant(253));
    }

    public static int nthUglyNumber_elegant(int n) {
        int[] uglyNumbers = new int[n];
        int k = 0;
        uglyNumbers[k++] = 1;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        while (k < n) {
            uglyNumbers[k] = Math.min(uglyNumbers[i1] * 2, Math.min(uglyNumbers[i2] * 3, uglyNumbers[i3] * 5));
            int uglyNumber = uglyNumbers[k++];
            if (uglyNumber == uglyNumbers[i1] * 2) i1++;
            if (uglyNumber == uglyNumbers[i2] * 3) i2++;
            if (uglyNumber == uglyNumbers[i3] * 5) i3++;
        }
        return uglyNumbers[n - 1];
    }

    public static int nthUglyNumber(int n) {
        List<Integer> values = new ArrayList<>();
        int index = 1;
        while (true) {
            if (isUgly(index, values)) {
                values.add(index);
            }
            if (values.size() == n) return values.get(n - 1);
            if (values.size() >= 1690) return -1;
            index++;
        }
    }

    public static boolean isUgly(int num, List<Integer> values) {
        if (num == 0) return false;
        if (num == 1) return true;
        boolean ugly = false;
        if (num % 2 == 0) {
            if (values.contains(num / 2)) return true;
            ugly = ugly || isUgly(num / 2, values);
        }
        if (num % 3 == 0) {
            if (values.contains(num / 3)) return true;
            ugly = ugly || isUgly(num / 3, values);
        }
        if (num % 5 == 0) {
            if (values.contains(num / 5)) return true;
            ugly = ugly || isUgly(num / 5, values);
        }
        return ugly;
    }
}

package codesignalOnlineAssesment;

import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 08, 2020
 * Questions: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */

public class Q1 {

    public static void main(String[] args) {

    }

    public int subtractProductAndSum(int n) {
        long prod = 1, sum = 0;
        while (n > 0) {
            int cur = n % 10;
            prod *= cur;
            sum += cur;
            n /= 10;
        }
        return (int) (prod - sum);
    }
}

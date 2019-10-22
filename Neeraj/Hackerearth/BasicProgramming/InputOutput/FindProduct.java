package BasicProgramming.InputOutput;

import java.util.Scanner;

/*
https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/find-product/
 */
public class FindProduct {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arraySize = s.nextInt();
        long output = 1;
        double modValue = Math.pow(10, 7) + 7;
        for (int i = 0; i < arraySize; i++) {
            int curr = s.nextInt();
            output = (long) ((output * curr) % modValue);
            System.out.println("curr = " + curr + " output = " + output);
        }
        System.out.println(output);
    }
}
//5442744, 328683326
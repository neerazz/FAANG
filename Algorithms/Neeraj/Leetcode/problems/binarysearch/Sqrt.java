package problems.binarysearch;

/*
https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println("Answer is:" + mySqrt(4) + " should be [2].");
        System.out.println("Answer is:" + mySqrt(8) + " should be [2].");
        System.out.println("Answer is:" + mySqrt(10) + " should be [3].");
        System.out.println("Answer is:" + mySqrt(2147395600) + " should be [46340].");
    }

    public static int mySqrt(int x) {
        if (x < 2) return x;
        int left = (int) Math.sqrt(x);
        int right = left + 1;
        long rightSquare = (long) right * (long) right;
        return rightSquare > x ? left : right;
    }
}

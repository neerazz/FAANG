/*
    Created on:  Apr 19, 2020
 */

/**
 * Questions: https://www.hackerrank.com/challenges/apple-and-orange/problem
 */
public class AppleAndOrange {
    public static void main(String[] args) {

    }

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int apl = 0, org = 0;
        for (int i : apples) {
            if (fellInHouse(s, t, a + i)) apl++;
        }
        for (int i : oranges) {
            if (fellInHouse(s, t, b + i)) org++;
        }
        System.out.println(apl);
        System.out.println(org);
    }

    static boolean fellInHouse(int s, int t, int point) {
        return s <= point && t >= point;
    }
}

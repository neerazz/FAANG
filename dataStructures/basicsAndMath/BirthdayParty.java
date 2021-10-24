/*
    Created on:  May 02, 2020
 */

/**
 * Questions:
 */
public class BirthdayParty {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fr.nextInt(), m = fr.nextInt();
            if (m % n == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}

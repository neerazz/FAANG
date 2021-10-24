/*
    Created on:  Apr 30, 2020
 */

/**
 * Questions: https://www.hackerearth.com/practice/basic-programming/operators/basics-of-operators/practice-problems/algorithm/going-to-office-e2ef3feb/
 */
public class GoingToOffice {
    public static void main(String[] args) {
        FastReader sr = new FastReader("C:\\Users\\bnira\\Downloads\\9d3ba57adb9511e9.txt.clean.txt");
        int kms = sr.nextInt();
        double online_base_price = sr.nextInt();
        double online_base_kms = sr.nextInt();
        double online_rem_price = sr.nextInt();
        double classic_speed = sr.nextInt();
        double classic_base = sr.nextInt();
        double classic_per_minute = sr.nextInt();
        double classic_per_kms = sr.nextInt();

        double onlinePrice = 0.0;
        if (kms <= online_base_kms) {
            onlinePrice += online_base_price;
        } else {
            onlinePrice += online_base_price + ((kms - online_base_kms) * online_rem_price);
        }

        double classicPrice = classic_base + Math.ceil((kms / classic_speed) * classic_per_minute) + (kms * classic_per_kms);

        if (onlinePrice <= classicPrice) {
            System.out.println("Online Taxi");
        } else {
            System.out.println("Classic Taxi");
        }
    }
}

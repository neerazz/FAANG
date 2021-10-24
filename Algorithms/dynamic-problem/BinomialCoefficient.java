/**
 * Questions:
 * Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k).
 * A binomial coefficient C(n, k) also gives the number of ways, disregarding order, that k objects can be chosen from among n objects;
 * more formally, the number of k-element subsets (or k-combinations) of an n-element set.
 * Example: function should return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.
 */
public class BinomialCoefficient {
    public static void main(String[] args) {
        System.out.println(binomialCoeff(4, 2) + " should be [6].");
        System.out.println(binomialCoeff(5, 2) + " should be [10].");
    }

    private static int binomialCoeff(int n, int k) {
        return 0;
    }
}

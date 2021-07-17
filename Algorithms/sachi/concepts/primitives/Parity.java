package concepts.primitives;

/**
 * Check Parity of a number -
 * If the number of 1's are odd - Parity is 1
 * If the number of 1's is even - Parity is 0
 * Parity is 1 (110 - 1)
 * arity is 0  (1001 - 0 )
 */


//Mistakes - Wha is the format of Inuput ? Binary or Decimal ?

public class Parity {
    public static void main(String[] args) {

        //long x = 1011;
        long x = 101;
        System.out.println(parity(x));
        System.out.println(parity1(x));
    }

    private static int parity(long x) {
        //Go through the entire list
        long count = 0;
        while (x != 0) {
            count = count + (x & 1);
            x = x >>> 1;
        }
        return (count % 2 == 0) ? 0 : 1;
    }

    public static short parity1(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }
}
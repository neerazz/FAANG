//If number of 1s are odd -> Parity is 1 (110 - 1)
//No of 1s are even - Parity is 0  (1001 - 0 )
public class Parity {
    public static void main(String[] args) {
        long x = 1011;
        System.out.println(parity(x));
    }

    private static short parity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }
}
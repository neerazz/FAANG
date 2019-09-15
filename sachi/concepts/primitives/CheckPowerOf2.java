/*Check if a number is Power of 2
SOL:  
x & x-1 -> Removes LSB (Least Significant bit from the number)
Power of 2 will have 1 and all zeros.
  100000000 // number
& 011111111 // number - 1
-----------
  000000000 
-----------
*/
public class CheckPowerOf2 {
    public static void main(String[] args) {
        long x = 18;
        System.out.println(cheeckPowerOf2(x));
    }

    private static boolean cheeckPowerOf2(long x) {
        return x > 0 && ((x & (x - 1)) == 0);
    }
}